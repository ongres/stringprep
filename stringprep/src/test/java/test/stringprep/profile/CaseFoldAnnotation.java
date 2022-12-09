/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.stringprep.profile;

import java.util.EnumSet;
import java.util.Set;

import com.ongres.stringprep.Option;
import com.ongres.stringprep.Profile;
import com.ongres.stringprep.ProfileName;

/**
 * A demo profile to test the getProvider with annotation.
 */
@ProfileName("CaseFoldAnnotation")
public class CaseFoldAnnotation implements Profile {
  @Override
  public Set<Option> profile() {
    return EnumSet.of(
        Option.ADDITIONAL_MAPPING,
        Option.FORBID_ADDITIONAL_CHARACTERS, // Prohibited ASCII characters
        Option.MAP_TO_NOTHING, // [StringPrep, B.1]
        Option.CASE_FOLD_NO_NORMALIZATION, // [StringPrep, B.3]
        Option.FORBID_ASCII_SPACES, // [StringPrep, C.1.1]
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
        Option.CHECK_BIDI); // Bidirectional Characters;
  }

  @Override
  public int[] additionalMappingTable(int codePoint) {
    return Character.isUpperCase(codePoint)
        ? new int[] {Character.toLowerCase(codePoint)}
        : new int[] {codePoint};
  }

  @Override
  public boolean prohibitedAdditionalCharacters(int codePoint) {
    return (codePoint >= 0x0000 && codePoint <= 0x002C)
        || codePoint == 0x002F
        || (codePoint >= 0x003B && codePoint <= 0x0040)
        || (codePoint >= 0x005B && codePoint <= 0x0060)
        || (codePoint >= 0x007B && codePoint <= 0x007F);
  }
}
