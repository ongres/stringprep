package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class ParserProhibitionTables {
    
    private ParserProhibitionTables() {
    }

    private static final Pattern PROHIBITION_PATTERN = Pattern.compile("([^;]*);[^;]*");
    
    public static List<Integer> parseAsciiSpace() throws IOException {
        return new ParserUtil().parseToListInteger("/c1.1", PROHIBITION_PATTERN);
    }
    
    public static List<Integer> parseNonAsciiSpace() throws IOException {
        return new ParserUtil().parseToListInteger("/c1.2", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseAsciiControl() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c2.1", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseNonAsciiControl() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c2.2", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parsePrivateUse() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c3", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseNonCharacterCodePoints() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c4", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseSurrogateCodes() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c5", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseInappropriatePlainText() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c6", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseInappropriateCanonicalRepresentation() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c7", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseChangeDisplayProperties() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c8", PROHIBITION_PATTERN);
    }
    
    public static List<int[]> parseTaggingCharacters() throws IOException {
        return new ParserUtil().parseToListArrayInt("/c9", PROHIBITION_PATTERN);
    }
}
