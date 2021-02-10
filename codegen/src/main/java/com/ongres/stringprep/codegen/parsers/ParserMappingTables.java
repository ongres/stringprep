/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class ParserMappingTables {

  private static final Pattern LINE_PATTERN = Pattern.compile("([^;]*);([^;]*);[^;]*");
  private static final Pattern CODE_POINTS_PATTERN = Pattern.compile("\\s*([0-9A-F]+)");

  private ParserMappingTables() {
    throw new AssertionError();
  }

  public static List<String> parseMapToNothing()  {
    return new ParserUtil().parseToListInteger("/rfcs/b1.txt", LINE_PATTERN);
  }

  public static Map<String, List<String>> parseMapUsedWithNfkc()  {
    return new ParserUtil().parseToMapListInteger("/rfcs/b2.txt", LINE_PATTERN, CODE_POINTS_PATTERN);
  }

  public static Map<String, List<String>> parseMapUsedWithNoNormalization()  {
    return new ParserUtil().parseToMapListInteger("/rfcs/b3.txt", LINE_PATTERN, CODE_POINTS_PATTERN);
  }
}
