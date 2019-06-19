package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserMappingTables {
	
	private ParserMappingTables() {
	}
	
	private static final Pattern LINE_PATTERN = Pattern.compile("([^;]*);([^;]*);([^;]*);");
	private static final Pattern CODE_POINTS_PATTERN = Pattern.compile("[([^ ]*) ]*");
	
	public static List<Character> parseMapToNothing() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("b1"), Charset.defaultCharset());
		List<Character> mapToNothing = new ArrayList<>();
		for (String line : allLines) {
			Matcher matcherLine = LINE_PATTERN.matcher(line);
			String mappedFrom = matcherLine.group(1);
			String mappedTo = matcherLine.group(2);
			String reason = matcherLine.group(3);
			mapToNothing.add(mappedFrom.toCharArray()[0]);
		}
		return mapToNothing;
	}
	
	public static Map<Character, List<Character>> parseMapUsedWithNFKC() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("b2"), Charset.defaultCharset());
		Map<Character, List<Character>> mapUsedWithNFKC = new HashMap<>();
		for (String line : allLines) {
			List<Character> codePoints = new ArrayList<>();
			Matcher matcherLine = LINE_PATTERN.matcher(line);
			String mappedFrom = matcherLine.group(1);
			String mappedTo = matcherLine.group(2);
			Matcher matcherCodePoints = CODE_POINTS_PATTERN.matcher(mappedTo);
			for(int i=1; i<=matcherCodePoints.groupCount(); i++) {
				codePoints.add(matcherCodePoints.group(i).toCharArray()[0]);
			}
			String reason = matcherLine.group(3);
			mapUsedWithNFKC.put(mappedFrom.toCharArray()[0], codePoints);
		}
		return mapUsedWithNFKC;
	}
	
	public static Map<Character, List<Character>> parseMapUsedWithNoNormalization() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("b2"), Charset.defaultCharset());
		Map<Character, List<Character>> mapWithNoNormalization = new HashMap<>();
		for (String line : allLines) {
			List<Character> codePoints = new ArrayList<>();
			Matcher matcherLine = LINE_PATTERN.matcher(line);
			String mappedFrom = matcherLine.group(1);
			String mappedTo = matcherLine.group(2);
			Matcher matcherCodePoints = CODE_POINTS_PATTERN.matcher(mappedTo);
			for(int i=1; i<=matcherCodePoints.groupCount(); i++) {
				codePoints.add(matcherCodePoints.group(i).toCharArray()[0]);
			}
			String reason = matcherLine.group(3);
			mapWithNoNormalization.put(mappedFrom.toCharArray()[0], codePoints);
		}
		return mapWithNoNormalization;
	}
}
