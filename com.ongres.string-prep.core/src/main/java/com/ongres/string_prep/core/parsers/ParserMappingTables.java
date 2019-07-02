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

public class ParserMappingTables {
    
    public ParserMappingTables() {
    }
    
    private static final Pattern LINE_PATTERN = Pattern.compile("([^;]*);([^;]*);[^;]*");
    private static final Pattern CODE_POINTS_PATTERN = Pattern.compile("\\s*([0-9A-F]+)");
    
    public List<Integer> parseMapToNothing() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/b1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<Integer> mapToNothing = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = LINE_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String mappedFrom = matcherLine.group(1).replaceAll("\\s","");
                mapToNothing.add(Integer.parseInt(mappedFrom, 16));
            }
        }
        return mapToNothing;
    }
    
    public Map<Integer, List<Integer>> parseMapUsedWithNFKC() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/b2");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        Map<Integer, List<Integer>> mapUsedWithNFKC = new HashMap<>();
        while (null != (line = bufferedReader.readLine())) {
            List<Integer> codePoints = new ArrayList<>();
            Matcher matcherLine = LINE_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String mappedFrom = matcherLine.group(1);
                String mappedTo = matcherLine.group(2);
                Matcher matcherCodePoints = CODE_POINTS_PATTERN.matcher(mappedTo);
                while(matcherCodePoints.find()) {
                    codePoints.add(Integer.parseInt(matcherCodePoints.group(1), 16));
                }
                    String mapped = mappedFrom.replaceAll("\\s", "");
                    mapUsedWithNFKC.put(Integer.parseInt(mapped, 16), codePoints);
            }
        }
        return mapUsedWithNFKC;
    }
    
    public Map<Integer, List<Integer>> parseMapUsedWithNoNormalization() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/b3");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        Map<Integer, List<Integer>> mapWithNoNormalization = new HashMap<>();
        while (null != (line = bufferedReader.readLine())) {
            List<Integer> codePoints = new ArrayList<>();
            Matcher matcherLine = LINE_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String mappedFrom = matcherLine.group(1);
                String mappedTo = matcherLine.group(2);
                Matcher matcherCodePoints = CODE_POINTS_PATTERN.matcher(mappedTo);
                while(matcherCodePoints.find()) {
                    codePoints.add(Integer.parseInt(matcherCodePoints.group(1), 16));
                }
                    String mapped = mappedFrom.replaceAll("\\s", "");
                    mapWithNoNormalization.put(Integer.parseInt(mapped, 16), codePoints);
            }
        }
        return mapWithNoNormalization;
    }
}
