package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserUnicodeRepertoires {
	
	private ParserUnicodeRepertoires() {
	}
	
	public static Character[][] parseUnassignedCodePoints() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("a1"), Charset.defaultCharset());
		Character[][] unassignedCodePoints = new Character[allLines.size()][2];
		for (int i=0; i<allLines.size(); i++) {
			String line = allLines.get(i);
			if(line.contains("-")) {
				int separator = line.indexOf('-');
				unassignedCodePoints[i][0] = line.substring(0, separator).toCharArray()[0];
				unassignedCodePoints[i][1] = line.substring(separator).toCharArray()[0];
			} else {
				unassignedCodePoints[i][0] = line.toCharArray()[0];
				unassignedCodePoints[i][1] = line.toCharArray()[0];
			}
		}
		return unassignedCodePoints;
	}
}
