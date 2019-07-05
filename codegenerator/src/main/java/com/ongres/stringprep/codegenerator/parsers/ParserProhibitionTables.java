/*
 * Copyright 2019, OnGres.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.ongres.stringprep.codegenerator.parsers;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class ParserProhibitionTables {
    
  private ParserProhibitionTables() {
  }

  private static final Pattern PROHIBITION_PATTERN = Pattern.compile("([^;]*);[^;]*");
    
  public static List<Integer> parseAsciiSpace() throws IOException {
    return new ParserUtil().parseToListInteger("/rfcs/c1.1", PROHIBITION_PATTERN);
  }
    
  public static List<Integer> parseNonAsciiSpace() throws IOException {
    return new ParserUtil().parseToListInteger("/rfcs/c1.2", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseAsciiControl() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c2.1", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseNonAsciiControl() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c2.2", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parsePrivateUse() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c3", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseNonCharacterCodePoints() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c4", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseSurrogateCodes() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c5", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseInappropriatePlainText() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c6", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseInappropriateCanonicalRepresentation() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c7", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseChangeDisplayProperties() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c8", PROHIBITION_PATTERN);
  }
    
  public static List<List<Integer>> parseTaggingCharacters() throws IOException {
    return new ParserUtil().parseToListArrayInt("/rfcs/c9", PROHIBITION_PATTERN);
  }
}
