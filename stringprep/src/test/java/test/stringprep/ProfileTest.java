/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.stringprep;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.IntStream;

import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.Stringprep;
import com.ongres.stringprep.Tables;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProfileTest {

  @Test
  void nullProvider() {
    assertThrows(NullPointerException.class, () -> Stringprep.getProvider(null));
    assertThrows(IllegalArgumentException.class, () -> Stringprep.getProvider(""));
  }

  @Test
  void testAllOptions() {
    Profile profile = () -> EnumSet.allOf(Option.class);
    String example1 = "A\u00ADDⅨ";
    assertEquals("adix", profile.prepareStored(example1));
    assertEquals("adix", profile.prepareQuery(example1));
  }

  @Test
  void testNoneOptions() {
    Profile profile = () -> EnumSet.noneOf(Option.class);
    String example1 = "A\u00AD\u200A\u0BBCZ";
    assertEquals(example1, profile.prepareQuery(example1));
    IllegalArgumentException storedIllegal =
        assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example1));
    assertEquals("Unassigned code point \"0x0BBC\"", storedIllegal.getMessage());
  }

  @Test
  void testNormKcOptions() {
    Profile profile = () -> EnumSet.of(Option.NORMALIZE_KC, Option.MAP_TO_NOTHING);
    String example1 = "℻";
    assertEquals("FAX", profile.prepareStored(example1));
    assertEquals("FAX", profile.prepareQuery(example1));
    String example2 = "⑳";
    assertEquals("20", profile.prepareStored(example2));
    assertEquals("20", profile.prepareQuery(example2));
    String example3 = "㎓";
    assertEquals("GHz", profile.prepareStored(example3));
    assertEquals("GHz", profile.prepareQuery(example3));
    String example4 = "A\u00ADD ⑳";
    assertEquals("AD 20", profile.prepareStored(example4));
    assertEquals("AD 20", profile.prepareQuery(example4));
  }

  @Test
  void testAdditionalProhibitionsOptions() {
    Profile profile = new Profile() {
      @Override
      public Set<Option> profile() {
        return EnumSet.of(Option.FORBID_ADDITIONAL_CHARACTERS);
      }

      @Override
      public boolean prohibitedAdditionalCharacters(int codePoint) {
        return codePoint >= 'a' && codePoint <= 'c';
      }
    };
    String example1 = "xAbcydefz";
    IllegalArgumentException storedIllegal =
        assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example1));
    assertEquals("Prohibited code point \"0x0062\"", storedIllegal.getMessage());
    IllegalArgumentException queryIllegal =
        assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example1));
    assertEquals("Prohibited code point \"0x0062\"", queryIllegal.getMessage());
  }

  @Test
  void testEmptyAdditionalMappingOptions() {
    Profile profile = () -> EnumSet.of(Option.ADDITIONAL_MAPPING);
    String example = "ab";
    assertEquals(example, profile.prepareStored(example));
    assertEquals(example, profile.prepareQuery(example));
  }

  @Test
  void testAdditionalMappingOptions() {
    Profile profile = new Profile() {
      @Override
      public Set<Option> profile() {
        return EnumSet.of(Option.ADDITIONAL_MAPPING);
      }

      @Override
      public int[] additionalMappingTable(int codePoint) {
        if (codePoint == 'd' || codePoint == 'e' || codePoint == 'f') {
          return new int[] {'a', 'b', 'c'};
        } else {
          return new int[] {codePoint};
        }
      }
    };
    String example1 = "xabcydefz";
    assertEquals("xabcyabcabcabcz", profile.prepareStored(example1));
    assertEquals("xabcyabcabcabcz", profile.prepareQuery(example1));
  }

  @ParameterizedTest
  @ValueSource(ints = {0x00A0, 0x1680, 0x2000, 0x2001, 0x2002, 0x2003, 0x2004,
      0x2005, 0x2006, 0x2007, 0x2008, 0x2009, 0x200A, 0x200B, 0x202F, 0x205F, 0x3000})
  void testNonAsciiSpaces(int codePoint) {
    Profile profile = () -> EnumSet.of(Option.FORBID_NON_ASCII_SPACES);
    String character = String.valueOf(Character.toChars(codePoint));
    String characterHex = String.format(Locale.ROOT, "0x%4X", codePoint).replace(' ', '0');
    String example = "I" + character + "X";
    IllegalArgumentException storedIllegal =
        assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example));
    assertEquals("Prohibited non-ASCII space \"" + characterHex + "\"", storedIllegal.getMessage());
    IllegalArgumentException queryIllegal =
        assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example));
    assertEquals("Prohibited non-ASCII space \"" + characterHex + "\"", queryIllegal.getMessage());
  }

  @Test
  void testUndefinedPreparation() {
    Profile profile = () -> EnumSet.noneOf(Option.class);
    IntStream unassigned = IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
        .filter(Tables::unassignedCodePoints);

    for (int cp : unassigned.toArray()) {
      String chars = new String(Character.toChars(cp));
      String example = "abc" + chars + "def";
      assertDoesNotThrow(() -> profile.prepareQuery(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
      assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
    }
  }

  @Test
  void testProhibitionSurrogate() {
    Profile profile = () -> EnumSet.of(Option.FORBID_SURROGATE);
    IntStream unassigned = IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
        .filter(u -> Character.getType(u) == Character.SURROGATE);

    for (int cp : unassigned.toArray()) {
      String chars = new String(Character.toChars(cp));
      String example = "abc" + chars + "def";
      assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
      assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
    }
  }

  @Test
  void testProhibitionPrivateUse() {
    Profile profile = () -> EnumSet.of(Option.FORBID_PRIVATE_USE);
    IntStream unassigned = IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
        .filter(u -> Character.getType(u) == Character.PRIVATE_USE);

    for (int cp : unassigned.toArray()) {
      String chars = new String(Character.toChars(cp));
      String example = "abc" + chars + "def";
      assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
      assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
    }
  }

  @Test
  void testProhibitionControlCharacter() {
    Profile profile =
        () -> EnumSet.of(Option.FORBID_ASCII_CONTROL, Option.FORBID_NON_ASCII_CONTROL);
    IntStream unassigned = IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
        .filter(u -> Character.getType(u) == Character.CONTROL);

    for (int cp : unassigned.toArray()) {
      String chars = new String(Character.toChars(cp));
      String example = "abc" + chars + "def";
      assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
      assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
          () -> "Character: " + chars + ", CodePoint: " + cp);
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {0x0020, 0x00A0, 0x1680, 0x2000, 0x2001, 0x2002, 0x2003, 0x2004, 0x2005,
      0x2006, 0x2007, 0x2008, 0x2009, 0x200A, 0x200B, 0x202F, 0x205F, 0x3000})
  void testProhibitionSpaces(int cp) {
    Profile profile =
        () -> EnumSet.of(Option.FORBID_ASCII_SPACES, Option.FORBID_NON_ASCII_SPACES);

    String chars = new String(Character.toChars(cp));
    String example = "abc" + chars + "def";
    assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example),
        () -> "Character: " + chars + ", CodePoint: " + cp);
    assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
        () -> "Character: " + chars + ", CodePoint: " + cp);
  }

  @ParameterizedTest
  @ValueSource(ints = {0x0340, 0x0341, 0x200E, 0x200F, 0x202A, 0x202B, 0x202C, 0x202D, 0x202E,
      0x206A, 0x206B, 0x206C, 0x206D, 0x206E, 0x206F})
  void testCheckBidiChangeDisplayProperties(int cp) {
    Profile profile = () -> EnumSet.of(Option.CHECK_BIDI);

    String chars = new String(Character.toChars(cp));
    String example = "abc" + chars + "def";
    assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example),
        () -> "Character: " + chars + ", CodePoint: " + cp);
    assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
        () -> "Character: " + chars + ", CodePoint: " + cp);
  }

  @ParameterizedTest
  @ValueSource(ints = {0x0340, 0x0341, 0x200E, 0x200F, 0x202A, 0x202B, 0x202C, 0x202D, 0x202E,
      0x206A, 0x206B, 0x206C, 0x206D, 0x206E, 0x206F})
  void testProhibitionChangeDisplayProperties(int cp) {
    Profile profile = () -> EnumSet.of(Option.FORBID_CHANGE_DISPLAY_AND_DEPRECATED);

    String chars = new String(Character.toChars(cp));
    String example = "abc" + chars + "def";
    assertThrows(IllegalArgumentException.class, () -> profile.prepareQuery(example),
        () -> "Character: " + chars + ", CodePoint: " + cp);
    assertThrows(IllegalArgumentException.class, () -> profile.prepareStored(example),
        () -> "Character: " + chars + ", CodePoint: " + cp);
  }

}
