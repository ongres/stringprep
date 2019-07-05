/*
 * Copyright 2019, OnGres.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.ongres.stringprep.codegenerator.parsers;

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
    
  /**
 * Parse a file with hexadecimal to a list of integers.
 * @param file with the RFC file to parse
 * @param pattern of the lines
 * @return list of integers
 * @throws IOException if a RFC file can't be read
 */
  public List<Integer> parseToListInteger(
          String file, Pattern pattern) throws NumberFormatException, IOException {
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

  /**
 * Parse a file with mappings to a map of list of integers.
 * @param file with THE RFC file to parse
 * @param patternLine pattern of the lines
 * @param mapTo pattern of the conversion
 * @return map of list of integers
 * @throws IOException if a RFC file can't be read
 */
  public Map<Integer, List<Integer>> parseToMapListInteger(
          String file, Pattern patternLine, Pattern mapTo) throws IOException {
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
        while (matcherCodePoints.find()) {
          codePoints.add(Integer.parseInt(matcherCodePoints.group(1), 16));
        }
        String mapped = mappedFrom.replaceAll("\\s", "");
        mapWithNoNormalization.put(Integer.parseInt(mapped, 16), codePoints);
      }
    }
    return mapWithNoNormalization;
  }

  /**
 * Parse a file with ranges of hexadecimal to a list of list of integers.
 * @param file with the RFC file to parse
 * @return list of list of integers
 * @throws IOException if a RFC file can't be read
 */
  public List<List<Integer>> parseToListArrayInt(
        String file) throws NumberFormatException, IOException {
    return parseToListArrayInt(file, null);
  }

  /**
 * Parse a file with ranges of hexadecimal to a list of list of integers.
 * @param file with the RFC file to parse
 * @param pattern of the lines
 * @return list of list of integers
 * @throws IOException if a RFC file can't be read
 */
  public List<List<Integer>> parseToListArrayInt(
        String file, Pattern pattern) throws NumberFormatException, IOException {
    InputStream inputStream = getClass().getResourceAsStream(file);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String line = null;
    List<List<Integer>> codePoints = new ArrayList<>();
    if (null != pattern) {
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

  private void fillList(List<List<Integer>> codePoints,String value) {
    List<Integer> characters = new ArrayList<>();
    if (value.contains("-")) {
      int separator = value.indexOf('-');
      characters.add(Integer.parseInt(value.substring(0, separator), 16));
      characters.add(Integer.parseInt(value.substring(separator + 1), 16));
    } else {
      characters.add(Integer.parseInt(value, 16));
      characters.add(Integer.parseInt(value, 16));
    }
    codePoints.add(characters);
  }
    
}
