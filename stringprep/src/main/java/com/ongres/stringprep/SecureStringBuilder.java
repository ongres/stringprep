/*
 * Copyright (c) 2026 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.util.Arrays;

/**
 * A memory-safe string builder alternative designed specifically for cryptographic operations.
 *
 * <p>Standard {@link String} and {@link StringBuilder} classes leave sensitive data (like passwords
 * or encryption keys) in memory until garbage collection occurs. This class mitigates that risk
 * by ensuring that internal character arrays are explicitly zeroed out when the buffer is resized,
 * and when the resource is closed.
 *
 * @see AutoCloseable
 */
final class SecureStringBuilder implements AutoCloseable {
  private char[] buffer;
  private int length;

  /**
   * Constructs a new {@code SecureStringBuilder} with the specified initial capacity.
   *
   * @param initialCapacity the initial capacity of the secure buffer.
   * @throws IllegalArgumentException if {@code initialCapacity} is negative.
   */
  SecureStringBuilder(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Initial capacity cannot be negative");
    }
    this.buffer = new char[initialCapacity];
    this.length = 0;
  }

  /**
   * Ensures that the internal buffer has enough capacity to hold the specified minimum
   * number of characters. If a resize is required, the old array is securely wiped
   * before being discarded.
   *
   * @param minCapacity the desired minimum capacity.
   * @throws OutOfMemoryError if the required size exceeds JVM array limits.
   */
  private void ensureCapacity(int minCapacity) {
    if (minCapacity > buffer.length) {
      // Use long to prevent integer overflow when doubling
      int newCapacity = (int) Math.min(Integer.MAX_VALUE, Math.max(buffer.length * 2L, minCapacity));
      char[] newBuffer = new char[newCapacity];
      System.arraycopy(buffer, 0, newBuffer, 0, length);

      // SECURE WIPE: Zero out the old array before abandoning it to the GC
      Arrays.fill(buffer, '\0');
      buffer = newBuffer;
    }
  }

  /**
   * Appends a single Unicode code point to this buffer.
   *
   * <p>This method correctly handles supplementary characters by converting them
   * into their corresponding UTF-16 surrogate pairs if necessary.
   *
   * @param codePoint the Unicode code point to append.
   * @throws IllegalArgumentException if the specified code point is not a valid Unicode code point.
   * @throws IllegalStateException if the builder has been closed.
   */
  void appendCodePoint(int codePoint) {
    if (buffer == null) {
      throw new IllegalStateException("SecureStringBuilder is closed");
    }
    int charCount = Character.charCount(codePoint);
    ensureCapacity(this.length + charCount);
    Character.toChars(codePoint, this.buffer, this.length);
    this.length += charCount;
  }

  /**
   * Extracts a copy of the current buffer sized exactly to the appended content.
   *
   * <p><b>Security Warning:</b> This method allocates a <i>new</i> array containing the
   * sensitive data. The internal buffer remains intact until {@link #close()} is called.
   * The caller assumes full responsibility for securely wiping the returned array
   * (e.g., using {@link Arrays#fill(char[], char)}) as soon as it is no longer needed.
   *
   * @return a new, exact-sized character array containing the buffer's contents.
   * @throws IllegalStateException if the builder has been closed.
   */
  char[] toCharArray() {
    if (buffer == null) {
      throw new IllegalStateException("SecureStringBuilder is closed");
    }
    char[] result = new char[length];
    System.arraycopy(buffer, 0, result, 0, length);
    return result;
  }

  /**
   * Securely wipes the internal buffer by overwriting all contents with null characters
   * ('\0') and resets the length to zero.
   *
   * <p>This method should be called inside a {@code finally} block or implicitly via
   * a {@code try-with-resources} statement to guarantee cleanup.
   */
  @Override
  public void close() {
    if (buffer != null) {
      Arrays.fill(buffer, '\0');
      buffer = null; //NOPMD
    }
    length = 0;
  }
}
