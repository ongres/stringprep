/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;

class ParserBidirectionalTables {

  private ParserBidirectionalTables() {
    throw new AssertionError();
  }

  public static List<List<String>> parseBidirectionalPropertyRorAL() {
    return new ParserUtil().parseToListArrayInt("/rfcs/d1");
  }

  public static List<List<String>> parseBidirectionalPropertyL() {
    return new ParserUtil().parseToListArrayInt("/rfcs/d2");
  }
}
