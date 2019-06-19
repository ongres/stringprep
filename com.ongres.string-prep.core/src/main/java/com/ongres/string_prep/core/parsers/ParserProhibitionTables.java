package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserProhibitionTables {
	
	private ParserProhibitionTables() {
	}

	private static final Pattern PROHIBITION_PATTERN = Pattern.compile("([^;-]*)[-([^;])]?;[^;]*");
	
	public static List<Character> parseAsciiSpace() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c1.1"), Charset.defaultCharset());
		List<Character> asciiSpace = new ArrayList<>();
		for (String line : allLines) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			String comment = matcherLine.group(2);
			asciiSpace.add(value.toCharArray()[0]);
		}
		return asciiSpace;
	}
	
	public static List<Character> parseNonAsciiSpace() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c1.2"), Charset.defaultCharset());
		List<Character> nonAsciiSpace = new ArrayList<>();
		for (String line : allLines) {
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			String comment = matcherLine.group(2);
			nonAsciiSpace.add(value.toCharArray()[0]);
		}
		return nonAsciiSpace;
	}
	
	public static Character[][] parseAsciiControl() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c2.1"), Charset.defaultCharset());
		Character[][] asciiControl = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				asciiControl[i][0] = line.substring(0, separator).toCharArray()[0];
				asciiControl[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				asciiControl[i][0] = line.toCharArray()[0];
				asciiControl[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return asciiControl;
	}
	
	public static Character[][] parseNonAsciiControl() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c2.2"), Charset.defaultCharset());
		Character[][] nonAsciiControl = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				nonAsciiControl[i][0] = line.substring(0, separator).toCharArray()[0];
				nonAsciiControl[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				nonAsciiControl[i][0] = line.toCharArray()[0];
				nonAsciiControl[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return nonAsciiControl;
	}
	
	public static Character[][] parsePrivateUse() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c3"), Charset.defaultCharset());
		Character[][] privateUse = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				privateUse[i][0] = line.substring(0, separator).toCharArray()[0];
				privateUse[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				privateUse[i][0] = line.toCharArray()[0];
				privateUse[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return privateUse;
	}
	
	public static Character[][] parseNonCharacterCodePoints() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c4"), Charset.defaultCharset());
		Character[][] nonCharacterCodePoints = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				nonCharacterCodePoints[i][0] = line.substring(0, separator).toCharArray()[0];
				nonCharacterCodePoints[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				nonCharacterCodePoints[i][0] = line.toCharArray()[0];
				nonCharacterCodePoints[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return nonCharacterCodePoints;
	}
	
	public static Character[][] parseSurrogateCodes() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c5"), Charset.defaultCharset());
		Character[][] surrogateCodes = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				surrogateCodes[i][0] = line.substring(0, separator).toCharArray()[0];
				surrogateCodes[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				surrogateCodes[i][0] = line.toCharArray()[0];
				surrogateCodes[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return surrogateCodes;
	}
	
	public static Character[][] parseInappropriatePlainText() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c6"), Charset.defaultCharset());
		Character[][] inappropiatePlainText = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				inappropiatePlainText[i][0] = line.substring(0, separator).toCharArray()[0];
				inappropiatePlainText[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				inappropiatePlainText[i][0] = line.toCharArray()[0];
				inappropiatePlainText[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return inappropiatePlainText;
	}
	
	public static Character[][] parseInappropriateCanonicalRepresentation() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c7"), Charset.defaultCharset());
		Character[][] inappropiateCanonicalRepresentation = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				inappropiateCanonicalRepresentation[i][0] = line.substring(0, separator).toCharArray()[0];
				inappropiateCanonicalRepresentation[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				inappropiateCanonicalRepresentation[i][0] = line.toCharArray()[0];
				inappropiateCanonicalRepresentation[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return inappropiateCanonicalRepresentation;
	}
	
	public static Character[][] parseChangeDisplayProperties() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c8"), Charset.defaultCharset());
		Character[][] changeDisplayProperties = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				changeDisplayProperties[i][0] = line.substring(0, separator).toCharArray()[0];
				changeDisplayProperties[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				changeDisplayProperties[i][0] = line.toCharArray()[0];
				changeDisplayProperties[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return changeDisplayProperties;
	}
	
	public static Character[][] parseTaggingCharacters() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("c9"), Charset.defaultCharset());
		Character[][] taggingCharacters = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			Matcher matcherLine = PROHIBITION_PATTERN.matcher(line);
			String value = matcherLine.group(1);
			if(value.contains("-")) {
				int separator = line.indexOf('-');
				taggingCharacters[i][0] = line.substring(0, separator).toCharArray()[0];
				taggingCharacters[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				taggingCharacters[i][0] = line.toCharArray()[0];
				taggingCharacters[i][1] = line.toCharArray()[0];
			}
			String comment = matcherLine.group(2);
		}
		return taggingCharacters;
	}
}
