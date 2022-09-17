/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.util.Set;

/**
 * The {@code Profile} interface is used to define stringprep profiles in order to fully specify the
 * processing options.
 *
 * <p>Stringprep profiles can also exclude characters that should not normally appear in text that
 * is used in the protocol. The profile can prevent such characters by changing the characters to be
 * excluded to other characters, by removing those characters, or by causing an error if the
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
   *           "queries" MAY include unassigned code points. This method should not necessarily be
   *           overridden by implementations.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared String.
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
   *           "queries" MAY include unassigned code points. This method should not necessarily be
   *           overridden by implementations.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared String.
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
   *           "stored strings" MUST NOT contain unassigned code points. This method should not
   *           necessarily be overridden by implementations.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared String.
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
   *           "stored strings" MUST NOT contain unassigned code points. This method should not
   *           necessarily be overridden by implementations.
   *
   * @param string to prepare based on a "stringprep" profile.
   * @return The prepared String.
   * @throws IllegalArgumentException if there is a prohibited output.
   */
  default String prepareStored(String string) {
    return new String(prepareStored(string.toCharArray()));
  }

  /**
   * Any additional mapping tables specific to the profile.
   *
   * @implSpec Profiles that requires additional mapping tables must implement this method. A code
   *           point match return the mapped array with the new code points or if there is no match,
   *           it should return the same input code point as {@code new int[] {codePoint};}.
   *           Implementations MUST also set {@link Option#ADDITIONAL_MAPPING} to enable the
   *           proccesing of this rule.
   *
   * @implNote The default implementation always return the same code point mapping ({@code new
   *           int[] {codePoint}}), no change is done to the code point.
   *
   * @param codePoint the character (Unicode code point) to be mapped.
   * @return Mapping with the int[] array or with the same codePoint.
   */
  default int[] additionalMappingTable(int codePoint) {
    return new int[] {codePoint};
  }

  /**
   * Any additional characters that are prohibited as output specific to the profile.
   *
   * @implSpec Profiles that prohibit additional characters must implement this method. A code point
   *           match return {@code true}, or if the code point should not be prohibited it should
   *           return {@code false}. Implementations MUST also set
   *           {@link Option#FORBID_ADDITIONAL_CHARACTERS} to enable the proccesing of this rule.
   *
   * @implNote The default implementation always return {@code false}, all characters are accepted.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is prohibited on this profile.
   */
  default boolean prohibitedAdditionalCharacters(int codePoint) {
    return false;
  }

}
