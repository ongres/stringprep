package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserBidirectionalTables {
	
	private ParserBidirectionalTables() {
	}
	
	public static Character[][] parseBidirectionalPropertyRorAL() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("d1"), Charset.defaultCharset());
		Character[][] bidirectionalPropertyRorAL = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			if(line.contains("-")) {
				int separator = line.indexOf('-');
				bidirectionalPropertyRorAL[i][0] = line.substring(0, separator).toCharArray()[0];
				bidirectionalPropertyRorAL[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				bidirectionalPropertyRorAL[i][0] = line.toCharArray()[0];
				bidirectionalPropertyRorAL[i][1] = line.toCharArray()[0];
			}
		}
		return bidirectionalPropertyRorAL;
	}
	
	public static Character[][] parseBidirectionalPropertyL() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("d2"), Charset.defaultCharset());
		Character[][] bidirectionalPropertyL = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			if(line.contains("-")) {
				int separator = line.indexOf('-');
				bidirectionalPropertyL[i][0] = line.substring(0, separator).toCharArray()[0];
				bidirectionalPropertyL[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				bidirectionalPropertyL[i][0] = line.toCharArray()[0];
				bidirectionalPropertyL[i][1] = line.toCharArray()[0];
			}
		}
		return bidirectionalPropertyL;
	}
}
