/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.util.List;
import java.util.Map;

/**
 * List of the tables parsed to the generator engine.
 */
public class Parser {

  public List<List<String>> getUnassignedCodePoints() {
    return ParserUnicodeRepertoires.parseUnassignedCodePoints();
  }

  public List<String> getMapToNothing() {
    return ParserMappingTables.parseMapToNothing();
  }

  public Map<String, List<String>> getMapUsedWithNfkc() {
    return ParserMappingTables.parseMapUsedWithNfkc();
  }

  public Map<String, List<String>> getMapUsedWithNoNormalization() {
    return ParserMappingTables.parseMapUsedWithNoNormalization();
  }

  public List<String> getAsciiSpace() {
    return ParserProhibitionTables.parseAsciiSpace();
  }

  public List<String> getNonAsciiSpace() {
    return ParserProhibitionTables.parseNonAsciiSpace();
  }

  public List<List<String>> getAsciiControl() {
    return ParserProhibitionTables.parseAsciiControl();
  }

  public List<List<String>> getNonAsciiControl() {
    return ParserProhibitionTables.parseNonAsciiControl();
  }

  public List<List<String>> getPrivateUse() {
    return ParserProhibitionTables.parsePrivateUse();
  }

  public List<List<String>> getNonCharacterCodePoints() {
    return ParserProhibitionTables.parseNonCharacterCodePoints();
  }

  public List<List<String>> getSurrogateCodes() {
    return ParserProhibitionTables.parseSurrogateCodes();
  }

  public List<List<String>> getInappropriatePlainText() {
    return ParserProhibitionTables.parseInappropriatePlainText();
  }

  public List<List<String>> getInappropriateCanonicalRepresentation() {
    return ParserProhibitionTables.parseInappropriateCanonicalRepresentation();
  }

  public List<List<String>> getChangeDisplayProperties() {
    return ParserProhibitionTables.parseChangeDisplayProperties();
  }

  public List<List<String>> getTaggingCharacters() {
    return ParserProhibitionTables.parseTaggingCharacters();
  }

  public List<List<String>> getPropertyRorAL() {
    return ParserBidirectionalTables.parseBidirectionalPropertyRorAL();
  }

  public List<List<String>> getPropertyL() {
    return ParserBidirectionalTables.parseBidirectionalPropertyL();
  }
}
