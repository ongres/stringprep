/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.nameprep;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EnumSet;

import com.ongres.nameprep.Nameprep;
import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.Stringprep;
import org.junit.jupiter.api.Test;

class NameprepTest {

  @Test
  void getProvider() {
    assertDoesNotThrow(() -> Stringprep.getProvider("Nameprep"));
    assertThrows(IllegalArgumentException.class, () -> Stringprep.getProvider("SASLprep"));
  }

  @Test
  void service() {
    Profile service = Stringprep.getProvider("Nameprep");
    assertEquals(EnumSet.of(Option.MAP_TO_NOTHING, // [StringPrep, B.1]
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
    assertThrows(IllegalArgumentException.class, () -> service.prepareStored(withUnassignedChar));
  }

  @Test
  void newInstance() {
    // Access the exported package
    Nameprep profile = new Nameprep();
    String example1 = "I\u00ADX \u2168";
    assertEquals("ix ix", profile.prepareStored(example1));
    assertEquals("ix ix", profile.prepareQuery(example1));
  }

}
