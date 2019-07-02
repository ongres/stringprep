package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.util.List;

public class ParserUnicodeRepertoires {
    
    private ParserUnicodeRepertoires() {
    }
    
    public static List<int[]> parseUnassignedCodePoints() throws IOException {
        return new ParserUtil().parseToListArrayInt("/a1");
    }
}
