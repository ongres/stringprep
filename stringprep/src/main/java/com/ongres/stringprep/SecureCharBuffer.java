/*
 * Copyright (c) 2026 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.util.Arrays;

/**
 * A memory-safe string builder alternative for cryptographic operations.
 * It ensures that resized arrays and the final buffer are securely wiped with zeros.
 */
final class SecureCharBuffer implements AutoCloseable {
  private char[] buffer;
  private int length;

  SecureCharBuffer(int initialCapacity) {
    this.buffer = new char[initialCapacity];
    this.length = 0;
  }

  void append(char[] chars, int offset, int len) {
    ensureCapacity(this.length + len);
    System.arraycopy(chars, offset, this.buffer, this.length, len);
    this.length += len;
  }

  void appendCodePoint(int codePoint) {
    int charCount = Character.charCount(codePoint);
    ensureCapacity(this.length + charCount);
    Character.toChars(codePoint, this.buffer, this.length);
    this.length += charCount;
  }

  private void ensureCapacity(int minCapacity) {
    if (minCapacity > buffer.length) {
      int newCapacity = Math.max(buffer.length * 2, minCapacity);
      char[] newBuffer = new char[newCapacity];
      System.arraycopy(buffer, 0, newBuffer, 0, length);

      // SECURE WIPE: Zero out the old array before abandoning it to the GC
      Arrays.fill(buffer, '\0');
      buffer = newBuffer;
    }
  }

  /**
   * Extracts the exact-sized array and leaves the internal buffer intact.
   * The caller is now responsible for wiping the returned array.
   */
  char[] toCharArray() {
    char[] result = new char[length];
    System.arraycopy(buffer, 0, result, 0, length);
    return result;
  }

  @Override
  public void close() {
    if (buffer != null) {
      Arrays.fill(buffer, '\0');
    }
    length = 0;
  }
}
