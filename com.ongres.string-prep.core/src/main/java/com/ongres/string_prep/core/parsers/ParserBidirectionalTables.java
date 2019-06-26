package com.ongres.string_prep.core.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserBidirectionalTables {
	
	public ParserBidirectionalTables() {
	}
	
	public List<Character[]> parseBidirectionalPropertyRorAL() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/d1");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> bidirectionalPropertyRorAL = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			line = line.replaceAll("\\s", "");
			Character[] characters = new Character[2];
			if(line.contains("-")) {
				int separator = line.indexOf('-');
				int decimalStart = Integer.parseInt(line.substring(0, separator), 16);
				char characterStart = (char) decimalStart;
				int decimalEnd = Integer.parseInt(line.substring(separator+1), 16);
				char characterEnd = (char) decimalEnd;
				characters[0] = characterStart;
				characters[1] = characterEnd;
			} else {
				int decimalStart = Integer.parseInt(line, 16);
				char characterStart = (char) decimalStart;
				characters[0] = characterStart;
				characters[1] = characterStart;
			}
			bidirectionalPropertyRorAL.add(characters);
		}
		return bidirectionalPropertyRorAL;
	}
	
	public List<Character[]> parseBidirectionalPropertyL() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/d2");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		List<Character[]> bidirectionalPropertyL = new ArrayList<>();
		while (null != (line = bufferedReader.readLine())) {
			line = line.replaceAll("\\s", "");
			Character[] characters = new Character[2];
			if(line.contains("-")) {
				int separator = line.indexOf('-');
				int decimalStart = Integer.parseInt(line.substring(0, separator), 16);
				char characterStart = (char) decimalStart;
				int decimalEnd = Integer.parseInt(line.substring(separator+1), 16);
				char characterEnd = (char) decimalEnd;
				characters[0] = characterStart;
				characters[1] = characterEnd;
			} else {
				int decimalStart = Integer.parseInt(line, 16);
				char characterStart = (char) decimalStart;
				characters[0] = characterStart;
				characters[1] = characterStart;
			}
			bidirectionalPropertyL.add(characters);
		}
		return bidirectionalPropertyL;
	}
}
