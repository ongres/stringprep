/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.saslprep;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EnumSet;

import com.ongres.saslprep.SASLprep;
import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.Stringprep;
import org.junit.jupiter.api.Test;

class SaslPrepTest {

  @Test
  void getProvider() {
    assertDoesNotThrow(() -> Stringprep.getProvider("SASLprep"));
    assertThrows(IllegalArgumentException.class, () -> Stringprep.getProvider("Nameprep"));
  }

  @Test
  void service() {
    Profile service = Stringprep.getProvider("SASLprep");
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
  void newInstance() {
    // Access the exported package
    SASLprep profile = new SASLprep();
    String example1 = "I\u00ADX \u2168";
    assertEquals("IX IX", profile.prepareStored(example1));
    assertEquals("IX IX", profile.prepareQuery(example1));
  }

  @Test
  void accessPublic() {
    assertEquals("com.ongres.stringprep", Stringprep.class.getModule().getName());
    assertEquals("com.ongres.saslprep", SASLprep.class.getModule().getName());
  }

}
