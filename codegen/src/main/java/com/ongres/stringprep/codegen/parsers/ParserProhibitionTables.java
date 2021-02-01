/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;
import java.util.regex.Pattern;

class ParserProhibitionTables {

  private static final Pattern PROHIBITION_PATTERN = Pattern.compile("([^;]*);[^;]*");

  private ParserProhibitionTables() {
    throw new AssertionError();
  }

  public static List<String> parseAsciiSpace() {
    return new ParserUtil().parseToListInteger("/rfcs/c1.1", PROHIBITION_PATTERN);
  }

  public static List<String> parseNonAsciiSpace() {
    return new ParserUtil().parseToListInteger("/rfcs/c1.2", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseAsciiControl() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c2.1", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseNonAsciiControl() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c2.2", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parsePrivateUse() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c3", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseNonCharacterCodePoints() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c4", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseSurrogateCodes() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c5", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseInappropriatePlainText() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c6", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseInappropriateCanonicalRepresentation() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c7", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseChangeDisplayProperties() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c8", PROHIBITION_PATTERN);
  }

  public static List<List<String>> parseTaggingCharacters() {
    return new ParserUtil().parseToListArrayInt("/rfcs/c9", PROHIBITION_PATTERN);
  }

}
