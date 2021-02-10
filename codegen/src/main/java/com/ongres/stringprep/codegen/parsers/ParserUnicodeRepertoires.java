/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;

class ParserUnicodeRepertoires {

  private ParserUnicodeRepertoires() {
    throw new AssertionError();
  }

  public static List<List<String>> parseUnassignedCodePoints() {
    return new ParserUtil().parseToListArrayInt("/rfcs/a1.txt");
  }
}
