package com.ongres.string_prep.core.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserProhibitionTables {
    
    public ParserProhibitionTables() {
    }

    private static final Pattern PROHIBITION_PATTERN = Pattern.compile("([^;]*);[^;]*");
    
    public List<Integer> parseAsciiSpace() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c1.1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<Integer> asciiSpace = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                asciiSpace.add(Integer.parseInt(value, 16));
            }
        }
        return asciiSpace;
    }
    
    public List<Integer> parseNonAsciiSpace() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c1.2");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<Integer> nonAsciiSpace = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                nonAsciiSpace.add(Integer.parseInt(value, 16));
            }
        }
        return nonAsciiSpace;
    }
    
    public List<int[]> parseAsciiControl() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c2.1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> asciiControl = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                asciiControl.add(characters);
            }
        }
        return asciiControl;
    }
    
    public List<int[]> parseNonAsciiControl() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c2.2");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> nonAsciiControl = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                nonAsciiControl.add(characters);
            }
        }
        return nonAsciiControl;
    }
    
    public List<int[]> parsePrivateUse() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c3");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> privateUse = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                privateUse.add(characters);
            }
        }
        return privateUse;
    }
    
    public List<int[]> parseNonCharacterCodePoints() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c4");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> nonCharacterCodePoints = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                nonCharacterCodePoints.add(characters);
            }
        }
        return nonCharacterCodePoints;
    }
    
    public List<int[]> parseSurrogateCodes() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c5");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> surrogateCodes = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                surrogateCodes.add(characters);
            }
        }
        return surrogateCodes;
    }
    
    public List<int[]> parseInappropriatePlainText() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c6");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> inappropiatePlainText = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                inappropiatePlainText.add(characters);
            }
        }
        return inappropiatePlainText;
    }
    
    public List<int[]> parseInappropriateCanonicalRepresentation() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c7");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> inappropiateCanonicalRepresentation = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                inappropiateCanonicalRepresentation.add(characters);
            }
        }
        return inappropiateCanonicalRepresentation;
    }
    
    public List<int[]> parseChangeDisplayProperties() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c8");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> changeDisplayProperties = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                changeDisplayProperties.add(characters);
            }
        }
        return changeDisplayProperties;
    }
    
    public List<int[]> parseTaggingCharacters() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/c9");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        List<int[]> taggingCharacters = new ArrayList<>();
        while (null != (line = bufferedReader.readLine())) {
            Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
            if (matcherLine.matches()) {
                String value = matcherLine.group(1).replaceAll("\\s", "");
                int[] characters = new int[2];
                if (value.contains("-")) {
                    int separator = value.indexOf('-');
                    characters[0] = Integer.parseInt(value.substring(0, separator), 16);
                    characters[1] = Integer.parseInt(value.substring(separator + 1), 16);
                } else {
                    characters[0] = Integer.parseInt(value, 16);
                    characters[1] = Integer.parseInt(value, 16);
                }
                taggingCharacters.add(characters);
            }
        }
        return taggingCharacters;
    }
}
