package com.ongres.string_prep.core.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtil {
    
    public List<Integer> parseToListInteger(String file, Pattern pattern) throws NumberFormatException, IOException {
        InputStream inputStream = getClass().getResourceAsStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<Integer> codePoints = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = pattern.matcher(line);
            if (matcherLine.matches()) {
                String mappedFrom = matcherLine.group(1).replaceAll("\\s","");
                codePoints.add(Integer.parseInt(mappedFrom, 16));
            }
        }
        return codePoints;
    }
    
    public Map<Integer, List<Integer>> parseToMapListInteger(String file, Pattern patternLine, Pattern mapTo) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        Map<Integer, List<Integer>> mapWithNoNormalization = new HashMap<>();
        while (null != (line = bufferedReader.readLine())) {
            List<Integer> codePoints = new ArrayList<>();
            Matcher matcherLine = patternLine.matcher(line);
            if (matcherLine.matches()) {
                String mappedFrom = matcherLine.group(1);
                String mappedTo = matcherLine.group(2);
                Matcher matcherCodePoints = mapTo.matcher(mappedTo);
                while(matcherCodePoints.find()) {
                    codePoints.add(Integer.parseInt(matcherCodePoints.group(1), 16));
                }
                    String mapped = mappedFrom.replaceAll("\\s", "");
                    mapWithNoNormalization.put(Integer.parseInt(mapped, 16), codePoints);
            }
        }
        return mapWithNoNormalization;
    }
    
    public List<int[]> parseToListArrayInt(String file) throws NumberFormatException, IOException {
        return parseToListArrayInt(file, null);
        }
    
    public List<int[]> parseToListArrayInt(String file, Pattern pattern) throws NumberFormatException, IOException {
        InputStream inputStream = getClass().getResourceAsStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> codePoints = new ArrayList<>();
        if(null != pattern) {
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = pattern.matcher(line);
            if (matcherLine.matches()) {
                fillList(codePoints, matcherLine.group(1).replaceAll("\\s", ""));
            }
        }
        } else {
            while (null != (line = bufferedReader.readLine())) {
                fillList(codePoints, line.replaceAll("\\s", ""));
                }
        }
        return codePoints;
    }
    
    private void fillList(List<int[]> codePoints,String value) {
        int[] characters = new int[2];
        if (value.contains("-")) {
            int separator = value.indexOf('-');
            characters[0] = Integer.parseInt(value.substring(0, separator), 16);
            characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
        } else {
            characters[0] = Integer.parseInt(value, 16);
            characters[1] = Integer.parseInt(value, 16);
        }
        codePoints.add(characters);
    }
    
    
}
