/*
 * Copyright (c) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ParserUtil {

  private static final Pattern SPACE_PATTERN = Pattern.compile("\\s");

  private ParserUtil() {
    throw new AssertionError();
  }

  /**
   * Parse a file with hexadecimal to a list of integers.
   *
   * @param file with the RFC file to parse
   * @param pattern of the lines
   * @return list of integers
   */
  public static List<String> parseToListInteger(String file, Pattern pattern) {
    InputStream inputStream = ParserUtil.class.getResourceAsStream(file);
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      String line = null;
      List<String> codePoints = new ArrayList<>();
      while (null != (line = bufferedReader.readLine())) {
        Matcher matcherLine = pattern.matcher(line);
        if (matcherLine.matches()) {
          String mappedFrom = SPACE_PATTERN.matcher(matcherLine.group(1)).replaceAll("");
          codePoints.add("0x" + mappedFrom);
        }
      }
      return Collections.unmodifiableList(codePoints);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  /**
   * Parse a file with mappings to a map of list of integers.
   *
   * @param file with THE RFC file to parse
   * @param patternLine pattern of the lines
   * @param mapTo pattern of the conversion
   * @return map of list of integers
   */
  public static Map<String, List<String>> parseToMapListInteger(String file, Pattern patternLine,
      Pattern mapTo) {
    InputStream inputStream = ParserUtil.class.getResourceAsStream(file);
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      String line = null;
      Map<String, List<String>> mapWithNoNormalization = new HashMap<>();
      while (null != (line = bufferedReader.readLine())) {
        Matcher matcherLine = patternLine.matcher(line);
        if (matcherLine.matches()) {
          List<String> codePoints = new ArrayList<>();
          String mappedFrom = matcherLine.group(1);
          String mappedTo = matcherLine.group(2);
          Matcher matcherCodePoints = mapTo.matcher(mappedTo);
          while (matcherCodePoints.find()) {
            codePoints.add("0x" + matcherCodePoints.group(1));
          }
          String mapped = SPACE_PATTERN.matcher(mappedFrom).replaceAll("");
          mapWithNoNormalization.put("0x" + mapped, codePoints);
        }
      }
      return Collections.unmodifiableMap(mapWithNoNormalization);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  /**
   * Parse a file with ranges of hexadecimal to a list of list of integers.
   *
   * @param file with the RFC file to parse
   * @return list of list of integers
   */
  public static List<List<String>> parseToListArrayInt(String file) {
    return parseToListArrayInt(file, null);
  }

  /**
   * Parse a file with ranges of hexadecimal to a list of list of integers.
   *
   * @param file with the RFC file to parse
   * @param pattern of the lines
   * @return list of list of integers
   */
  public static List<List<String>> parseToListArrayInt(String file, Pattern pattern) {
    InputStream inputStream = ParserUtil.class.getResourceAsStream(file);
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      String line = null;
      List<List<String>> codePoints = new ArrayList<>();
      if (null != pattern) {
        while (null != (line = bufferedReader.readLine())) {
          Matcher matcherLine = pattern.matcher(line);
          if (matcherLine.matches()) {
            fillList(codePoints, SPACE_PATTERN.matcher(matcherLine.group(1)).replaceAll(""));
          }
        }
      } else {
        while (null != (line = bufferedReader.readLine())) {
          fillList(codePoints, SPACE_PATTERN.matcher(line).replaceAll(""));
        }
      }
      return Collections.unmodifiableList(codePoints);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static void fillList(List<List<String>> codePoints, String value) {
    List<String> characters = new ArrayList<>();
    if (value.contains("-")) {
      int separator = value.indexOf('-');
      characters.add("0x" + value.substring(0, separator));
      characters.add("0x" + value.substring(separator + 1));
    } else {
      characters.add("0x" + value);
      characters.add("0x" + value);
    }
    codePoints.add(characters);
  }

}
