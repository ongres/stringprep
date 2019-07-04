package com.ongres.stringprep.codegenerator.parsers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ParserMappingTables {
    
  private ParserMappingTables() {
  }
    
  private static final Pattern LINE_PATTERN = Pattern.compile("([^;]*);([^;]*);[^;]*");
  private static final Pattern CODE_POINTS_PATTERN = Pattern.compile("\\s*([0-9A-F]+)");
    
  public static List<Integer> parseMapToNothing() throws IOException {
    return new ParserUtil().parseToListInteger("/rfcs/b1", LINE_PATTERN);
  }
    
  public static Map<Integer, List<Integer>> parseMapUsedWithNfkc() throws IOException {
    return new ParserUtil().parseToMapListInteger("/rfcs/b2", LINE_PATTERN, CODE_POINTS_PATTERN);
  }
    
  public static Map<Integer, List<Integer>> parseMapUsedWithNoNormalization() throws IOException {
    return new ParserUtil().parseToMapListInteger("/rfcs/b3", LINE_PATTERN, CODE_POINTS_PATTERN);
  }
}
