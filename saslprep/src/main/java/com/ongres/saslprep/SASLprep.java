/*
 * Copyright (c) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.saslprep;

import java.util.EnumSet;
import java.util.Set;

import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.ProfileName;
import com.ongres.stringprep.Tables;

/**
 * SASLprep: Stringprep Profile for User Names and Passwords.
 *
 * <p>The use of simple user names and passwords in authentication and authorization is pervasive on
 * the Internet. To increase the likelihood that user name and password input and comparison work in
 * ways that make sense for typical users throughout the world, this document defines rules for
 * preparing internationalized user names and passwords for comparison. For simplicity and
 * implementation ease, a single algorithm is defined for both user names and passwords.
 */
@ProfileName("SASLprep")
public final class SASLprep implements Profile {

  private final Set<Option> saslprepProfile;

  /**
   * Construct an instance of the {@code SASLprep} profile.
   */
  public SASLprep() {
    this.saslprepProfile = EnumSet.of(
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
        Option.CHECK_BIDI); // Bidirectional Characters
  }

  @Override
  public Set<Option> profile() {
    return saslprepProfile;
  }

  /**
   * Non-ASCII space characters that can be mapped to SPACE (U+0020).
   */
  @Override
  public int[] additionalMappingTable(int codePoint) {
    // - non-ASCII space characters [StringPrep, C.1.2] that can be
    // mapped to SPACE (U+0020)
    return Tables.prohibitionNonAsciiSpace(codePoint)
        ? new int[] {0x0020}
        : new int[] {codePoint};
  }

}
