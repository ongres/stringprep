package com.ongres.string_prep.core.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserUnicodeRepertoires {
    
    public ParserUnicodeRepertoires() {
    }
    
    public List<int[]> parseUnassignedCodePoints() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/a1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> unassignedCodePoints = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            int[] characters = new int[2];
            line = line.replaceAll("\\s", "");
            if(line.contains("-")) {
                int separator = line.indexOf('-');
                characters[0] = Integer.parseInt(line.substring(0, separator), 16);
                characters[1] = Integer.parseInt(line.substring(separator + 1), 16);
            } else {
                characters[0] = Integer.parseInt(line, 16);
                characters[1] = Integer.parseInt(line, 16);
            }
            unassignedCodePoints.add(characters);
        }
        return unassignedCodePoints;
    }
}
