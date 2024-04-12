/*
 * Copyright (c) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.saslprep;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.EnumSet;

import com.ongres.saslprep.SASLprep;
import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.Stringprep;
import org.junit.jupiter.api.Test;

class SaslPrepTest {

  final SASLprep saslPrep = new SASLprep();

  @Test
  void service() {
    assertThrows(NullPointerException.class, () -> Stringprep.getProvider(null));
    Profile service = assertDoesNotThrow(() -> Stringprep.getProvider("SASLprep"));
    assertEquals(saslPrep.profile(), service.profile());
    assertEquals(EnumSet.of(
        Option.ADDITIONAL_MAPPING, // [StringPrep, C.1.2]
        Option.MAP_TO_NOTHING, // [StringPrep, B.1]
        Option.NORMALIZE_KC, // Normalization form KC
        Option.FORBID_NON_ASCII_SPACES, // [StringPrep, C.1.2]
        Option.FORBID_ASCII_CONTROL, // [StringPrep, C.2.1]
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
    assertEquals("IX", saslPrep.prepareStored(example1));
    String example2 = "user";
    assertEquals(example2, saslPrep.prepareStored(example2));
    String example3 = "USER";
    assertEquals(example3, saslPrep.prepareStored(example3));
    String example4 = "ª";
    assertEquals("a", saslPrep.prepareStored(example4));
    String example5 = "Ⅸ";
    assertEquals("IX", saslPrep.prepareStored(example5));
    String example6 = "\u0007";
    try {
      saslPrep.prepareStored(example6);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Prohibited ASCII control \"0x0007\"", e.getMessage());
    }
    String example7 = "ا1";
    try {
      saslPrep.prepareStored(example7);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("RandALCat character is not the first and the last character",
          e.getMessage());
    }
    String supplementary = "𠀀";
    assertEquals(supplementary, saslPrep.prepareStored(supplementary));

    String example8 = "\u2487\u017F\uFB03\u212A\u037E";
    assertEquals("(20)sffiK;", saslPrep.prepareStored(example8));
    String example9 = "¯\\_(⊙︿⊙)_/¯";
    assertEquals(" ̄\\_(⊙〈⊙)_/ ̄", saslPrep.prepareStored(example9));
    String example10 = "";
    assertEquals("", saslPrep.prepareStored(example10));
    String example11 = "I\u00ADX \u2168";
    assertEquals("IX IX", saslPrep.prepareStored(example11));

    assertThrows(NullPointerException.class, () -> saslPrep.prepareStored((String) null));

  }

  @Test
  void mappedToSpace() {
    assertEquals("a bcde", saslPrep.prepareStored("a\u00A0bcde"));
    assertEquals("ab cde", saslPrep.prepareStored("ab\u1680cde"));
    assertEquals("ABc de", saslPrep.prepareStored("ABc\u2000de"));
    assertEquals("a bcde ", saslPrep.prepareStored("a bcde\u2006"));
    assertEquals(" abcde", saslPrep.prepareStored("\u202Fabcde"));
    assertEquals("a bc d e", saslPrep.prepareStored("a\u202Fbc\u3000d\u205Fe"));
  }

  @Test
  void bidi2() {
    // RandALCat character first *and* last is OK
    assertEquals("\u0627\u0031\u0627", saslPrep.prepareStored("\u0627\u0031\u0627"));
    // Both RandALCat character and LCat is not allowed
    try {
      saslPrep.prepareStored("\u0627\u0041\u0627");
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("Prohibited string with RandALCat and LCat", e.getMessage());
    }
    // Both first and last RandALCat
    try {
      saslPrep.prepareStored("\u0627\u0031");
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "RandALCat character is not the first and the last character",
          e.getMessage());
    }
    try {
      saslPrep.prepareStored("\u0031\u0627");
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "RandALCat character is not the first and the last character",
          e.getMessage());
    }
    try {
      saslPrep.prepareStored("\u05BE\uFBA8a\u05BE\uFBA8"); // <right><right><left><right><right>
      fail("Should throw IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Prohibited string with RandALCat and LCat",
          e.getMessage());
    }
    try {
      saslPrep.prepareStored("a\u05BE\uFBA8abc\u05BE\uFBA8c"); // <right><right><left><right><right>
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
    assertEquals(withUnassignedChar, saslPrep.prepareQuery(withUnassignedChar));
    try {
      saslPrep.prepareStored(withUnassignedChar);
    } catch (IllegalArgumentException e) {
      assertEquals("Unassigned code point \"0x0588\"", e.getMessage());
    }
  }
}
