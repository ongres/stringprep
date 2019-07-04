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
