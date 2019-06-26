package com.ongres.string_prep.core.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserUnicodeRepertoires {
	
	public ParserUnicodeRepertoires() {
	}
	
	public List<Character[]> parseUnassignedCodePoints() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("a1");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> unassignedCodePoints = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			Character[] characters = new Character[2];
			line = line.replaceAll("\\s", "");
			if(line.contains("-")) {
				int separator = line.indexOf('-');
				int decimalStart = Integer.parseInt(line.substring(0, separator), 16);
				char characterStart = (char) decimalStart;
				int decimalEnd = Integer.parseInt(line.substring(separator), 16);
				char characterEnd = (char) decimalEnd;
				characters[0] = characterStart;
				characters[1] = characterEnd;
			} else {
				int decimalStart = Integer.parseInt(line, 16);
				char characterStart = (char) decimalStart;
				characters[0] = characterStart;
				characters[1] = characterStart;
			}
			unassignedCodePoints.add(characters);
		}
		return unassignedCodePoints;
	}
}
