/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

/**
 * Options to define a StringPrep profile.
 *
 * @since 2.0
 */
public enum Option {

  /**
   * B.1 Commonly mapped to nothing
   */
  MAP_TO_NOTHING,
  /**
   * Any additional mapping tables specific to the profile.
   */
  ADDITIONAL_MAPPING,
  /**
   * B.2 Mapping for case-folding used with NFKC.
   */
  CASE_FOLD_NFKC,
  /**
   * B.3 Mapping for case-folding used with no normalization.
   */
  CASE_FOLD_NO_NORMALIZATION,
  /**
   * Unicode normalization with form KC.
   */
  NORMALIZE_KC,
  /**
   * Bidirectional tables.
   */
  CHECK_BIDI,
  /**
   * Any additional characters that are prohibited as output specific to the profile.
   */
  FORBID_ADDITIONAL_CHARACTERS,
  /**
   * C.1.1 ASCII space characters
   */
  FORBID_ASCII_SPACES,
  /**
   * C.1.2 Non-ASCII space characters
   */
  FORBID_NON_ASCII_SPACES,
  /**
   * C.2.1 ASCII control characters
   */
  FORBID_ASCII_CONTROL,
  /**
   * C.2.2 Non-ASCII control characters
   */
  FORBID_NON_ASCII_CONTROL,
  /**
   * C.3 Private use
   */
  FORBID_PRIVATE_USE,
  /**
   * C.4 Non-character code points.
   */
  FORBID_NON_CHARACTER,
  /**
   * C.5 Surrogate codes.
   */
  FORBID_SURROGATE,
  /**
   * C.6 Inappropriate for plain text.
   */
  FORBID_INAPPROPRIATE_FOR_PLAIN_TEXT,
  /**
   * C.7 Inappropriate for canonical representation
   */
  FORBID_INAPPROPRIATE_FOR_CANON_REP,
  /**
   * C.8 Change display properties or are deprecated
   */
  FORBID_CHANGE_DISPLAY_AND_DEPRECATED,
  /**
   * C.9 Tagging characters
   */
  FORBID_TAGGING;

}
