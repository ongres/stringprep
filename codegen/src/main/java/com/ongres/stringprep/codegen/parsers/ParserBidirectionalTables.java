/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;

final class ParserBidirectionalTables {

  private ParserBidirectionalTables() {
    throw new AssertionError();
  }

  public static List<List<String>> getBidirectionalPropertyRorAL() {
    return ParserUtil.parseToListArrayInt("/rfcs/d1.txt");
  }

  public static List<List<String>> getBidirectionalPropertyL() {
    return ParserUtil.parseToListArrayInt("/rfcs/d2.txt");
  }
}
