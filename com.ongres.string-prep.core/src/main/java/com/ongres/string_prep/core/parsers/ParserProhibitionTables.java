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
	
	public List<Character> parseAsciiSpace() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c1.1");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character> asciiSpace = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				int decimal = Integer.parseInt(value, 16);
				char character = (char) decimal;
				asciiSpace.add(character);
			}
		}
		return asciiSpace;
	}
	
	public List<Character> parseNonAsciiSpace() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c1.2");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character> nonAsciiSpace = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				int decimal = Integer.parseInt(value, 16);
				char character = (char) decimal;
				nonAsciiSpace.add(character);
			}
		}
		return nonAsciiSpace;
	}
	
	public List<Character[]> parseAsciiControl() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c2.1");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> asciiControl = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				asciiControl.add(characters);
			}
		}
		return asciiControl;
	}
	
	public List<Character[]> parseNonAsciiControl() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c2.2");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> nonAsciiControl = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
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
				int[] codePoints = new int[2];
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					codePoints[0] = decimalStart;
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					codePoints[1] = decimalEnd;
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					codePoints[0] = decimalStart;
					codePoints[1] = decimalStart;
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				privateUse.add(codePoints);
			}
		}
		return privateUse;
	}
	
	public List<Character[]> parseNonCharacterCodePoints() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c4");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> nonCharacterCodePoints = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				nonCharacterCodePoints.add(characters);
			}
		}
		return nonCharacterCodePoints;
	}
	
	public List<Character[]> parseSurrogateCodes() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c5");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> surrogateCodes = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				surrogateCodes.add(characters);
			}
		}
		return surrogateCodes;
	}
	
	public List<Character[]> parseInappropriatePlainText() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c6");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> inappropiatePlainText = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				inappropiatePlainText.add(characters);
			}
		}
		return inappropiatePlainText;
	}
	
	public List<Character[]> parseInappropriateCanonicalRepresentation() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c7");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> inappropiateCanonicalRepresentation = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				inappropiateCanonicalRepresentation.add(characters);
			}
		}
		return inappropiateCanonicalRepresentation;
	}
	
	public List<Character[]> parseChangeDisplayProperties() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/c8");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> changeDisplayProperties = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			if (matcherLine.matches()) {
				String value = matcherLine.group(1).replaceAll("\\s", "");
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
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
				int[] codePoints = new int[2];
				Character[] characters = new Character[2];
				if (value.contains("-")) {
					int separator = value.indexOf('-');
					int decimalStart = Integer.parseInt(value.substring(0, separator), 16);
					codePoints[0] = decimalStart;
					char characterStart = (char) decimalStart;
					int decimalEnd = Integer.parseInt(value.substring(separator+1), 16);
					codePoints[1] = decimalEnd;
					char characterEnd = (char) decimalEnd;
					characters[0] = characterStart;
					characters[1] = characterEnd;
				} else {
					int decimalStart = Integer.parseInt(value, 16);
					codePoints[0] = decimalStart;
					codePoints[1] = decimalStart;
					char characterStart = (char) decimalStart;
					characters[0] = characterStart;
					characters[1] = characterStart;
				}
				taggingCharacters.add(codePoints);
			}
		}
		return taggingCharacters;
	}
}
