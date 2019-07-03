package org.code.generator.parsers;

import java.io.IOException;
import java.util.List;

public class ParserUnicodeRepertoires {
    
    private ParserUnicodeRepertoires() {
    }
    
    public static List<List<Integer>> parseUnassignedCodePoints() throws IOException {
        return new ParserUtil().parseToListArrayInt("/rfcs/a1");
    }
}
