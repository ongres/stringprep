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
	private static final Pattern CODE_POINTS_PATTERN = Pattern.compile("[([^ ]*) ]*");
	
	public List<Character> parseMapToNothing() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/b1");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character> mapToNothing = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = LINE_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String mappedFrom = matcherLine.group(1).replaceAll("\\s","");
				int decimal = Integer.parseInt(mappedFrom, 16);
				char character =(char) decimal;
				mapToNothing.add(character);
			}
		}
		return mapToNothing;
	}
	
	public Map<Character, List<Character>> parseMapUsedWithNFKC() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/b2");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		Map<Character, List<Character>> mapUsedWithNFKC = new HashMap<>();
		while (null != (line = bufferedReader.readLine())) {
			List<Character> codePoints = new ArrayList<>();
			Matcher matcherLine = LINE_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String mappedFrom = matcherLine.group(1);
				String mappedTo = matcherLine.group(2);
				Matcher matcherCodePoints = CODE_POINTS_PATTERN.matcher(mappedTo);
				if (matcherCodePoints.matches()) {
					for(int i=1; i<=matcherCodePoints.groupCount(); i++) {
						String codePoint = matcherCodePoints.group(i).replaceAll("\\s", "");
						int decimal = Integer.parseInt(codePoint, 16);
						char character = (char) decimal;
						codePoints.add(character);
					}
					String mapped = mappedFrom.replaceAll("\\s", "");
					int decimal = Integer.parseInt(mapped, 16);
					char character = (char) decimal;
					mapUsedWithNFKC.put(character, codePoints);
				}
			}
		}
		return mapUsedWithNFKC;
	}
	
	public Map<Character, List<Character>> parseMapUsedWithNoNormalization() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/b3");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		Map<Character, List<Character>> mapWithNoNormalization = new HashMap<>();
		while (null != (line = bufferedReader.readLine())) {
			List<Character> codePoints = new ArrayList<>();
			Matcher matcherLine = LINE_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String mappedFrom = matcherLine.group(1);
				String mappedTo = matcherLine.group(2);
				Matcher matcherCodePoints = CODE_POINTS_PATTERN.matcher(mappedTo);
				if (matcherCodePoints.matches()) {
					for(int i=1; i<=matcherCodePoints.groupCount(); i++) {
						String codePoint = matcherCodePoints.group(i).replaceAll("\\s", "");
						int decimal = Integer.parseInt(codePoint, 16);
						char character = (char) decimal;
						codePoints.add(character);
					}
					String mapped = mappedFrom.replaceAll("\\s", "");
					int decimal = Integer.parseInt(mapped, 16);
					char character = (char) decimal;
					mapWithNoNormalization.put(character, codePoints);
				}
			}
		}
		return mapWithNoNormalization;
	}
}
