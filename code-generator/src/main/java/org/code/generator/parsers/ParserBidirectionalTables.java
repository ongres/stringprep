package org.code.generator.parsers;

import java.io.IOException;
import java.util.List;

public class ParserBidirectionalTables {
    
    private ParserBidirectionalTables() {
    }
    
    public static List<List<Integer>> parseBidirectionalPropertyRorAL() throws IOException {
        return new ParserUtil().parseToListArrayInt("/rfcs/d1");
    }
    
    public static List<List<Integer>> parseBidirectionalPropertyL() throws IOException {
        return new ParserUtil().parseToListArrayInt("/rfcs/d2");
    }
}
