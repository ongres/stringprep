/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.util.Set;

/**
 * The {@code Profile} interface is used to define stringprep profiles in order to fully specify the
 * processing options.
 *
 * <p>Stringprep profiles can also exclude characters that should not normally appear in text that
 * is used in the protocol. The profile can prevent such characters by mapping the prohibited
 * characters to replacement characters, by removing those characters, or by causing an error if the
 * characters would appear in the output.
 *
 * @since 2.0
 */
public interface Profile {

  /**
   * Set of options used by the profile.
   *
   * @return profile options.
   */
  Set<Option> profile();

  /**
   * "Queries" are strings that are used to match against strings that are stored identifiers, such
   * as user-entered names for digital certificate authorities and DNS lookups.
   *
   * @implNote The default method sets the storedStrings Stringprep parameter to {@code false}, as
   *           "queries" MAY include unassigned code points. Overriding this method is
   *           generally unnecessary unless specific String-based optimizations are required.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared string.
   * @throws IllegalArgumentException if there is a prohibited output.
   * @since 2.1
   */
  default char[] prepareQuery(char[] string) {
    return new Stringprep(this, false).prepare(string);
  }

  /**
   * "Queries" are strings that are used to match against strings that are stored identifiers, such
   * as user-entered names for digital certificate authorities and DNS lookups.
   *
   * @implNote The default method sets the storedStrings Stringprep parameter to {@code false}, as
   *           "queries" MAY include unassigned code points. Overriding this method is generally
   *           unnecessary unless specific String-based optimizations are required.
   * @apiNote This is a convenience method that delegates to {@link #prepareQuery(char[])}.
   *          <p>
   *          <strong>Security Warning:</strong> This method is <em>not</em> recommended for
   *          handling sensitive data like passwords or private keys. Because {@link String}
   *          objects are immutable, their contents cannot be zeroed out after use and may persist in
   *          memory indefinitely. For cryptographic secrets, use
   *          {@link #prepareQuery(char[])} to ensure the data can be cleared immediately after
   *          processing.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared string.
   * @throws IllegalArgumentException if there is a prohibited output.
   */
  default String prepareQuery(String string) {
    return new String(prepareQuery(string.toCharArray()));
  }

  /**
   * "Stored strings" are strings that are used in protocol identifiers and named entities, such as
   * names in digital certificates and DNS domain name parts.
   *
   * @implNote The default method sets the storedStrings Stringprep parameter to {@code true}, as
   *           "stored strings" MUST NOT contain unassigned code points. Overriding this method is
   *           generally unnecessary unless specific String-based optimizations are required.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared string.
   * @throws IllegalArgumentException if there is a prohibited output.
   * @since 2.1
   */
  default char[] prepareStored(char[] string) {
    return new Stringprep(this, true).prepare(string);
  }

  /**
   * "Stored strings" are strings that are used in protocol identifiers and named entities, such as
   * names in digital certificates and DNS domain name parts.
   *
   * @implNote The default method sets the storedStrings Stringprep parameter to {@code true}, as
   *           "stored strings" MUST NOT contain unassigned code points. Overriding this method is
   *           generally unnecessary unless specific String-based optimizations are required.
   * @apiNote This is a convenience method that delegates to {@link #prepareStored(char[])}.
   *          <p>
   *          <strong>Security Warning:</strong> This method is <em>not</em> recommended for
   *          handling sensitive data like passwords or private keys. Because {@link String}
   *          objects are immutable, their contents cannot be zeroed out after use and may persist in
   *          memory indefinitely. For cryptographic secrets, use
   *          {@link #prepareStored(char[])} to ensure the data can be cleared immediately after
   *          processing.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared string.
   * @throws IllegalArgumentException if there is a prohibited output.
   */
  default String prepareStored(String string) {
    return new String(prepareStored(string.toCharArray()));
  }

  /**
   * Any additional mapping tables specific to the profile.
   *
   * @implSpec Profiles that requires additional mapping tables must implement this method. A code
   *           point match returns the mapped array with the new code points or if there is no match,
   *           it should return the same input code point as {@code new int[] {codePoint};}.
   *           Implementations MUST also set {@link Option#ADDITIONAL_MAPPING} to enable the
   *           processing of this rule.
   *
   * @implNote The default implementation always return the same code point mapping ({@code new
   *           int[] {codePoint}}), no change is done to the code point.
   *
   * @param codePoint the character (Unicode code point) to be mapped.
   * @return An array containing the mapped code points, or an array containing the original
   *         code point if no mapping applies.
   */
  default int[] additionalMappingTable(int codePoint) {
    return new int[] {codePoint};
  }

  /**
   * Any additional characters that are prohibited as output specific to the profile.
   *
   * @implSpec Profiles that prohibit additional characters must implement this method. A code point
   *           match returns {@code true}, or if the code point should not be prohibited it returns
   *           {@code false}. Implementations MUST also set
   *           {@link Option#FORBID_ADDITIONAL_CHARACTERS} to enable the processing of this rule.
   *
   * @implNote The default implementation always returns {@code false}; all characters are accepted.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is prohibited on this profile.
   */
  default boolean prohibitedAdditionalCharacters(int codePoint) {
    return false;
  }

}
