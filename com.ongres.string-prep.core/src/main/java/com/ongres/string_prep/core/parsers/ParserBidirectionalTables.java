package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.util.List;

public class ParserBidirectionalTables {
    
    private ParserBidirectionalTables() {
    }
    
    public static List<int[]> parseBidirectionalPropertyRorAL() throws IOException {
        return new ParserUtil().parseToListArrayInt("/d1");
    }
    
    public static List<int[]> parseBidirectionalPropertyL() throws IOException {
        return new ParserUtil().parseToListArrayInt("/d2");
    }
}
