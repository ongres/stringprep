/*
 * Copyright (c) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;
import java.util.regex.Pattern;

final class ParserProhibitionTables {

  private static final Pattern PROHIBITION_PATTERN = Pattern.compile("([^;]*);[^;]*");

  private ParserProhibitionTables() {
    throw new AssertionError();
  }

  public static List<String> getAsciiSpace() {
    return ParserUtil.parseToListInteger("/rfcs/c1.1.txt", PROHIBITION_PATTERN);
  }

  public static List<String> getNonAsciiSpace() {
    return ParserUtil.parseToListInteger("/rfcs/c1.2.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getAsciiControl() {
    return ParserUtil.parseToListArrayInt("/rfcs/c2.1.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getNonAsciiControl() {
    return ParserUtil.parseToListArrayInt("/rfcs/c2.2.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getPrivateUse() {
    return ParserUtil.parseToListArrayInt("/rfcs/c3.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getNonCharacterCodePoints() {
    return ParserUtil.parseToListArrayInt("/rfcs/c4.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getSurrogateCodes() {
    return ParserUtil.parseToListArrayInt("/rfcs/c5.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getInappropriatePlainText() {
    return ParserUtil.parseToListArrayInt("/rfcs/c6.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getInappropriateCanonicalRepresentation() {
    return ParserUtil.parseToListArrayInt("/rfcs/c7.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getChangeDisplayProperties() {
    return ParserUtil.parseToListArrayInt("/rfcs/c8.txt", PROHIBITION_PATTERN);
  }

  public static List<List<String>> getTaggingCharacters() {
    return ParserUtil.parseToListArrayInt("/rfcs/c9.txt", PROHIBITION_PATTERN);
  }

}
