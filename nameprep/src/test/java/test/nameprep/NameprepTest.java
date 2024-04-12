/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.nameprep;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.EnumSet;

import com.ongres.nameprep.Nameprep;
import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.Stringprep;
import org.junit.jupiter.api.Test;

class NameprepTest {

  final Nameprep nameprep = new Nameprep();

  @Test
  void service() {
    Profile service = assertDoesNotThrow(() -> Stringprep.getProvider("Nameprep"));
    assertEquals(EnumSet.of(
        Option.MAP_TO_NOTHING, // [StringPrep, B.1]
        Option.CASE_FOLD_NFKC, // [StringPrep, B.2]
        Option.NORMALIZE_KC, // Normalization form KC
        Option.FORBID_NON_ASCII_SPACES, // [StringPrep, C.1.2]
        Option.FORBID_NON_ASCII_CONTROL, // [StringPrep, C.2.2]
        Option.FORBID_PRIVATE_USE, // [StringPrep, C.3]
        Option.FORBID_NON_CHARACTER, // [StringPrep, C.4]
        Option.FORBID_SURROGATE, // [StringPrep, C.5]
        Option.FORBID_INAPPROPRIATE_FOR_PLAIN_TEXT, // [StringPrep, C.6]
        Option.FORBID_INAPPROPRIATE_FOR_CANON_REP, // [StringPrep, C.7]
        Option.FORBID_CHANGE_DISPLAY_AND_DEPRECATED, // [StringPrep, C.8]
        Option.FORBID_TAGGING, // [StringPrep, C.9]
        Option.CHECK_BIDI), // Bidirectional Characters
        service.profile());
    String withUnassignedChar = "\u0380";
    assertDoesNotThrow(() -> service.prepareQuery(withUnassignedChar));
    assertThrows(IllegalArgumentException.class,
        () -> service.prepareStored(withUnassignedChar));
  }

  @Test
  void examplesRtf() throws IOException {
    String example1 = "I\u00ADX";
    assertEquals("ix", nameprep.prepareStored(example1));
    String example2 = "user";
    assertEquals(example2, nameprep.prepareStored(example2));
    String example3 = "USER";
    assertEquals("user", nameprep.prepareStored(example3));
    String example4 = "ª";
    assertEquals("a", nameprep.prepareStored(example4));
    String example5 = "Ⅸ";
    assertEquals("ix", nameprep.prepareStored(example5));
    String example6 = "\u0007";
    assertEquals("\u0007", nameprep.prepareStored(example6));
    String example7 = "ا1";
    try {
      nameprep.prepareStored(example7);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("RandALCat character is not the first and the last character",
          e.getMessage());
    }
    String supplementary = "𠀀";
    assertEquals(supplementary, nameprep.prepareStored(supplementary));

    String example8 = "\u2487\u017F\uFB03\u212A\u037E";
    assertEquals("(20)sffik;", nameprep.prepareStored(example8));
    String example9 = "¯\\_(⊙︿⊙)_/¯";
    assertEquals(" ̄\\_(⊙〈⊙)_/ ̄", nameprep.prepareStored(example9));
    String example10 = "中文字符串¯\\_(⊙︿⊙)_/¯";
    assertEquals("中文字符串 ̄\\_(⊙〈⊙)_/ ̄", nameprep.prepareStored(example10));
  }

  @Test
  void prohibitedSpace() {
    IllegalArgumentException storedIllegal =
        assertThrows(IllegalArgumentException.class, () -> nameprep.prepareStored("ab\u1680cde"));
    assertEquals("Prohibited non-ASCII space \"0x1680\"", storedIllegal.getMessage());
  }

  @Test
  void bidi2() {
    // RandALCat character first *and* last is OK
    assertEquals("\u0627\u0031\u0627", nameprep.prepareStored("\u0627\u0031\u0627"));
    // Both RandALCat character and LCat is not allowed
    try {
      nameprep.prepareStored("\u0627\u0041\u0627");
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Prohibited string with RandALCat and LCat", e.getMessage());
    }
    // Both first and last RandALCat
    try {
      nameprep.prepareStored("\u0627\u0031");
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "RandALCat character is not the first and the last character",
          e.getMessage());
    }
    try {
      nameprep.prepareStored("\u0031\u0627");
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "RandALCat character is not the first and the last character",
          e.getMessage());
    }
    try {
      nameprep.prepareStored("\u05BE\uFBA8a\u05BE\uFBA8"); // <right><right><left><right><right>
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Prohibited string with RandALCat and LCat",
          e.getMessage());
    }
    try {
      nameprep.prepareStored("a\u05BE\uFBA8abc\u05BE\uFBA8c"); // <right><right><left><right><right>
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Prohibited string with RandALCat and LCat",
          e.getMessage());
    }
  }

  @Test
  void unassigned() {
    String withUnassignedChar = "a\u0588\u0380b";
    assertEquals(withUnassignedChar, nameprep.prepareQuery(withUnassignedChar));
    try {
      nameprep.prepareStored(withUnassignedChar);
    } catch (IllegalArgumentException e) {
      assertEquals("Unassigned code point \"0x0588\"", e.getMessage());
    }
  }
}
