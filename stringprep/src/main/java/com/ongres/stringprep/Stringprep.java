/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.text.Normalizer;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;

/**
 * Java implementation of StringPrep (RFC 3454).
 *
 * @see <a href="https://tools.ietf.org/html/rfc3454">RFC 3454</a>
 * @version 2.0
 */
public final class Stringprep {

  private final Profile profile;
  private final boolean mapToNothing;
  private final boolean additionalMapping;
  private final boolean caseFoldNfkc;
  private final boolean caseFoldNoNormalization;
  private final boolean normalizeKc;
  private final boolean checkBidi;
  private final boolean forbidAdditionalCharacters;
  private final boolean forbidAsciiSpaces;
  private final boolean forbidNonAsciiSpaces;
  private final boolean forbidAsciiControl;
  private final boolean forbidNonAsciiControl;
  private final boolean forbidPrivateUse;
  private final boolean forbidNonCharacter;
  private final boolean forbidSurrogate;
  private final boolean forbidInappropriatePlainText;
  private final boolean forbidInappropriateCanonRep;
  private final boolean forbidChangeDisplayDeprecated;
  private final boolean forbidTagging;
  private final boolean forbidUnassigned;

  /**
   * Create a Stringprep instance based on a {@link Profile} {@link Option}s and the two different
   * types of strings in typical protocols where internationalized strings are used: "stored
   * strings" and "queries".
   *
   * @param profile includes the options to implement a Stringprep profile.
   * @param storedStrings "stored strings" MUST NOT contain unassigned code points, "queries" MAY
   *        include them.
   * @throws NullPointerException if {@code profile} is {@code null}.
   */
  Stringprep(Profile profile, boolean storedStrings) {
    Objects.requireNonNull(profile);
    EnumSet<Option> options = EnumSet.copyOf(Objects.requireNonNull(profile.profile()));
    this.mapToNothing = options.contains(Option.MAP_TO_NOTHING);
    this.additionalMapping = options.contains(Option.ADDITIONAL_MAPPING);
    this.caseFoldNfkc = options.contains(Option.CASE_FOLD_NFKC);
    this.caseFoldNoNormalization = options.contains(Option.CASE_FOLD_NO_NORMALIZATION);
    this.normalizeKc = options.contains(Option.NORMALIZE_KC);
    this.checkBidi = options.contains(Option.CHECK_BIDI);
    this.forbidAdditionalCharacters = options.contains(Option.FORBID_ADDITIONAL_CHARACTERS);
    this.forbidAsciiSpaces = options.contains(Option.FORBID_ASCII_SPACES);
    this.forbidNonAsciiSpaces = options.contains(Option.FORBID_NON_ASCII_SPACES);
    this.forbidAsciiControl = options.contains(Option.FORBID_ASCII_CONTROL);
    this.forbidNonAsciiControl = options.contains(Option.FORBID_NON_ASCII_CONTROL);
    this.forbidPrivateUse = options.contains(Option.FORBID_PRIVATE_USE);
    this.forbidNonCharacter = options.contains(Option.FORBID_NON_CHARACTER);
    this.forbidSurrogate = options.contains(Option.FORBID_SURROGATE);
    this.forbidInappropriatePlainText =
        options.contains(Option.FORBID_INAPPROPRIATE_FOR_PLAIN_TEXT);
    this.forbidInappropriateCanonRep = options.contains(Option.FORBID_INAPPROPRIATE_FOR_CANON_REP);
    this.forbidChangeDisplayDeprecated =
        options.contains(Option.FORBID_CHANGE_DISPLAY_AND_DEPRECATED);
    this.forbidTagging = options.contains(Option.FORBID_TAGGING);
    this.forbidUnassigned = storedStrings;
    this.profile = profile;
  }

  /**
   * Lookup the provider service that contains the profile.
   *
   * @param profileName name of the profile to lookup from the ServiceLoader.
   * @return Profile if there is a provider match.
   * @throws IllegalArgumentException if no provider is found.
   * @throws NullPointerException if {@code profileName} is {@code null}.
   */
  public static Profile getProvider(String profileName) {
    Objects.requireNonNull(profileName, "The profile name must not be null");
    Iterator<Profile> profiles = ServiceLoader.load(Profile.class).iterator();
    while (profiles.hasNext()) {
      Profile profile = profiles.next();
      if (profile.getClass().getSimpleName().equals(profileName)) {
        return profile;
      }
    }
    throw new IllegalArgumentException("No provider found for: " + profileName);
  }

  /**
   * Preparation of Internationalized Strings.
   *
   * <p>The steps for preparing strings are:
   *
   * <ol> <li>Map -- For each character in the input, check if it has a mapping and, if so, replace
   * it with its mapping. This is described in <a
   * href="https://tools.ietf.org/html/rfc3454#section-3">section 3</a>.
   *
   * <li>Normalize -- Possibly normalize the result of step 1 using Unicode normalization. This is
   * described in <a href="https://tools.ietf.org/html/rfc3454#section-4">section 4</a>.
   *
   * <li>Prohibit -- Check for any characters that are not allowed in the output. If any are found,
   * return an error. This is described in <a
   * href="https://tools.ietf.org/html/rfc3454#section-5">section 5</a>.
   *
   * <li>Check bidi -- Possibly check for right-to-left characters, and if any are found, make sure
   * that the whole string satisfies the requirements for bidirectional strings. If the string does
   * not satisfy the requirements for bidirectional strings, return an error. This is described in
   * <a href="https://tools.ietf.org/html/rfc3454#section-6">section 6</a>. </ol>
   *
   * @param string to prepare.
   *
   * @return The prepared string following the options of the profile.
   * @throws IllegalArgumentException if there are prohibited or bidi characters depending on the
   *         profile used.
   * @throws NullPointerException if {@code string} is {@code null}.
   */
  String prepare(String string) {
    Objects.requireNonNull(string, "The string to prepare must not be null");

    if (string.length() == 0) {
      return string;
    }

    // 1) Map -- For each character in the input, check if it has a mapping
    // and, if so, replace it with its mapping.
    string = map(string);

    // 2) Normalize -- Possibly normalize the result of step 1 using Unicode
    // normalization.
    if (normalizeKc) {
      string = Normalizer.normalize(string, Normalizer.Form.NFKC);
    }

    boolean firstRandAlCat = Tables.bidirectionalPropertyRorAL(string.codePointAt(0));
    boolean lastRandAlCat =
        Tables.bidirectionalPropertyRorAL(string.codePointAt(string.length() - 1));
    boolean containsRandAlCat = false;
    boolean containsLcat = false;
    int codePoint;
    for (int i = 0; i < string.length(); i += Character.charCount(codePoint)) {
      codePoint = string.codePointAt(i);

      // 3) Prohibit -- Check for any characters that are not allowed in the
      // output. If any are found, return an error.
      prohibitedOutput(codePoint);

      // 4) Check bidi -- Possibly check for right-to-left characters, and if
      // any are found, make sure that the whole string satisfies the
      // requirements for bidirectional strings. If the string does not
      // satisfy the requirements for bidirectional strings, return an
      // error.
      if (checkBidi) {
        // 1) The characters in section 5.8 MUST be prohibited.
        if (Tables.prohibitionChangeDisplayProperties(codePoint)) {
          throw prohibitedCharater("Prohibited control character", codePoint);
        }
        if (Tables.bidirectionalPropertyRorAL(codePoint)) {
          containsRandAlCat = true;
        }
        if (Tables.bidirectionalPropertyL(codePoint)) {
          containsLcat = true;
        }
        // 2) If a string contains any RandALCat character,
        // the string MUST NOT contain any LCat character.
        if (containsRandAlCat && containsLcat) {
          throw new IllegalArgumentException("Prohibited string with RandALCat and LCat");
        }
        // 3) If a string contains any RandALCat character, a RandALCat
        // character MUST be the first character of the string, and a
        // RandALCat character MUST be the last character of the string.
        if (containsRandAlCat && !(firstRandAlCat && lastRandAlCat)) {
          throw new IllegalArgumentException(
              "RandALCat character is not the first and the last character");
        }
      }
    }

    return string;
  }

  private String map(String string) {
    StringBuilder mapping = new StringBuilder(string.length());
    for (int codePoint, i = 0; i < string.length(); i += Character.charCount(codePoint)) {
      codePoint = string.codePointAt(i);

      if (mapToNothing && Tables.mapToNothing(codePoint)) { // NOPMD
        // The following characters are simply deleted from the input (that is,
        // they are mapped to nothing) because their presence or absence in
        // protocol identifiers should not make two strings different. They are
        // listed in Table B.1.
      } else if (normalizeKc && caseFoldNfkc) {
        // appendix B.2 is for profiles that also use Unicode
        // normalization form KC
        for (int cp : Tables.mapWithNfkc(codePoint)) {
          mapping.appendCodePoint(cp);
        }
      } else if (!normalizeKc && caseFoldNoNormalization) {
        // while appendix B.3 is for profiles that do
        // not use Unicode normalization
        for (int cp : Tables.mapWithoutNormalization(codePoint)) {
          mapping.appendCodePoint(cp);
        }
      } else if (additionalMapping) {
        // - Any additional mapping tables specific to the profile
        for (int cp : profile.additionalMappingTable(codePoint)) {
          mapping.appendCodePoint(cp);
        }
      } else {
        mapping.appendCodePoint(codePoint);
      }
    }

    return mapping.toString();
  }

  private void prohibitedOutput(int codePoint) {
    if (forbidAdditionalCharacters && profile.prohibitedAdditionalCharacters(codePoint)) {
      // - Any additional characters that are prohibited as output specific to
      // the profile
      throw prohibitedCharater("Prohibited code point", codePoint);
    }
    if (forbidAsciiSpaces && Tables.prohibitionAsciiSpace(codePoint)) {
      throw prohibitedCharater("Prohibited ASCII space", codePoint);
    }
    if (forbidNonAsciiSpaces && Tables.prohibitionNonAsciiSpace(codePoint)) {
      throw prohibitedCharater("Prohibited non-ASCII space", codePoint);
    }
    if (forbidAsciiControl && Tables.prohibitionAsciiControl(codePoint)) {
      throw prohibitedCharater("Prohibited ASCII control", codePoint);
    }
    if (forbidNonAsciiControl && Tables.prohibitionNonAsciiControl(codePoint)) {
      throw prohibitedCharater("Prohibited non-ASCII control", codePoint);
    }
    if (forbidPrivateUse && Tables.prohibitionPrivateUse(codePoint)) {
      throw prohibitedCharater("Prohibited private use character", codePoint);
    }
    if (forbidNonCharacter && Tables.prohibitionNonCharacterCodePoints(codePoint)) {
      throw prohibitedCharater("Prohibited non-character code point", codePoint);
    }
    if (forbidSurrogate && Tables.prohibitionSurrogateCodes(codePoint)) {
      throw prohibitedCharater("Prohibited surrogate code point", codePoint);
    }
    if (forbidInappropriatePlainText && Tables.prohibitionInappropriatePlainText(codePoint)) {
      throw prohibitedCharater("Prohibited plain text code point", codePoint);
    }
    if (forbidInappropriateCanonRep
        && Tables.prohibitionInappropriateCanonicalRepresentation(codePoint)) {
      throw prohibitedCharater("Prohibited non-canonical code point", codePoint);
    }
    if (forbidChangeDisplayDeprecated && Tables.prohibitionChangeDisplayProperties(codePoint)) {
      throw prohibitedCharater("Prohibited control character", codePoint);
    }
    if (forbidTagging && Tables.prohibitionTaggingCharacters(codePoint)) {
      throw prohibitedCharater("Prohibited tagging character", codePoint);
    }
    if (forbidUnassigned && Tables.unassignedCodePoints(codePoint)) {
      // All code points not assigned in the character repertoire named in a
      // stringprep profile are called "unassigned code points". Stored
      // strings using the profile MUST NOT contain any unassigned code
      // points. Queries for matching strings MAY contain unassigned code
      // points.
      throw prohibitedCharater("Unassigned code point", codePoint);
    }
  }

  private static IllegalArgumentException prohibitedCharater(String msg, int cp) {
    String codePointHex = String.format("0x%4X", cp).replace(' ', '0');
    return new IllegalArgumentException(String.format("%s \"%s\"", msg, codePointHex));
  }

}
