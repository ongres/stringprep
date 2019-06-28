package com.ongres.string_prep.core.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserBidirectionalTables {
    
    public ParserBidirectionalTables() {
    }
    
    public List<int[]> parseBidirectionalPropertyRorAL() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/d1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> bidirectionalPropertyRorAL = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            line = line.replaceAll("\\s", "");
            int[] characters = new int[2];
            if(line.contains("-")) {
                int separator = line.indexOf('-');
                characters[0] = Integer.parseInt(line.substring(0, separator), 16);
                characters[1] = Integer.parseInt(line.substring(separator + 1), 16);
            } else {
                characters[0] = Integer.parseInt(line, 16);
                characters[1] = Integer.parseInt(line, 16);
            }
            bidirectionalPropertyRorAL.add(characters);
        }
        return bidirectionalPropertyRorAL;
    }
    
    public List<int[]> parseBidirectionalPropertyL() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/d2");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> bidirectionalPropertyL = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            line = line.replaceAll("\\s", "");
            int[] characters = new int[2];
            if(line.contains("-")) {
                int separator = line.indexOf('-');
                characters[0] = Integer.parseInt(line.substring(0, separator), 16);
                characters[1] = Integer.parseInt(line.substring(separator + 1), 16);
            } else {
                characters[0] = Integer.parseInt(line, 16);
                characters[1] = Integer.parseInt(line, 16);
            }
            bidirectionalPropertyL.add(characters);
        }
        return bidirectionalPropertyL;
    }
}
