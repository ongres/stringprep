/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.nameprep;

import java.util.EnumSet;
import java.util.Set;

import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.ProfileName;

/**
 * Nameprep: A Stringprep Profile for Internationalized Domain Names (IDN).
 *
 * <p>This document specifies processing rules that will allow users to enter internationalized
 * domain names (IDNs) into applications and have the highest chance of getting the content of the
 * strings correct. It is a profile of stringprep. These processing rules are only intended for
 * internationalized domain names, not for arbitrary text.
 */
@ProfileName("Nameprep")
public final class Nameprep implements Profile {

  private final Set<Option> nameprepProfile;

  /**
   * Construct an instance of the {@code Nameprep} profile.
   */
  public Nameprep() {
    this.nameprepProfile = EnumSet.of(
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
        Option.CHECK_BIDI); // Bidirectional Characters
  }

  @Override
  public Set<Option> profile() {
    return nameprepProfile;
  }

}
