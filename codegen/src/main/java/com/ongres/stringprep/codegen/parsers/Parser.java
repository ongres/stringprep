/*
 * Copyright (c) 2019 OnGres, Inc.
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
    return ParserUnicodeRepertoires.getUnassignedCodePoints();
  }

  public List<String> getMapToNothing() {
    return ParserMappingTables.getMapToNothing();
  }

  public Map<String, List<String>> getMapUsedWithNfkc() {
    return ParserMappingTables.getMapUsedWithNfkc();
  }

  public Map<String, List<String>> getMapUsedWithNoNormalization() {
    return ParserMappingTables.getMapUsedWithNoNormalization();
  }

  public List<String> getAsciiSpace() {
    return ParserProhibitionTables.getAsciiSpace();
  }

  public List<String> getNonAsciiSpace() {
    return ParserProhibitionTables.getNonAsciiSpace();
  }

  public List<List<String>> getAsciiControl() {
    return ParserProhibitionTables.getAsciiControl();
  }

  public List<List<String>> getNonAsciiControl() {
    return ParserProhibitionTables.getNonAsciiControl();
  }

  public List<List<String>> getPrivateUse() {
    return ParserProhibitionTables.getPrivateUse();
  }

  public List<List<String>> getNonCharacterCodePoints() {
    return ParserProhibitionTables.getNonCharacterCodePoints();
  }

  public List<List<String>> getSurrogateCodes() {
    return ParserProhibitionTables.getSurrogateCodes();
  }

  public List<List<String>> getInappropriatePlainText() {
    return ParserProhibitionTables.getInappropriatePlainText();
  }

  public List<List<String>> getInappropriateCanonicalRepresentation() {
    return ParserProhibitionTables.getInappropriateCanonicalRepresentation();
  }

  public List<List<String>> getChangeDisplayProperties() {
    return ParserProhibitionTables.getChangeDisplayProperties();
  }

  public List<List<String>> getTaggingCharacters() {
    return ParserProhibitionTables.getTaggingCharacters();
  }

  public List<List<String>> getPropertyRorAL() {
    return ParserBidirectionalTables.getBidirectionalPropertyRorAL();
  }

  public List<List<String>> getPropertyL() {
    return ParserBidirectionalTables.getBidirectionalPropertyL();
  }
}
