package com.ongres.string_prep.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ongres.string_prep.core.parsers.ParserBidirectionalTables;
import com.ongres.string_prep.core.parsers.ParserMappingTables;
import com.ongres.string_prep.core.parsers.ParserProhibitionTables;
import com.ongres.string_prep.core.parsers.ParserUnicodeRepertoires;

public class StringPrep {

	public boolean unassignedCodePoints(char value) throws IOException {
		List<Character[]> unassignedCodePoints = new ParserUnicodeRepertoires().parseUnassignedCodePoints();
		for (int j=0; j<unassignedCodePoints.size(); j++) {
			if (value >= unassignedCodePoints.get(j)[0] && value <= unassignedCodePoints.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public String mapToNothing(String value) throws IOException {
		StringBuilder valueBuilder = new StringBuilder(value);
		List<Character> mapToNothing = new ParserMappingTables().parseMapToNothing();
		char[] valueChar = value.toCharArray();
		for (int i=0; i<value.length(); i++) {
			for(Character ch : mapToNothing) {
				if (valueChar[i] == ch.charValue()) {
					valueBuilder.deleteCharAt(i);
					break;
				}
			}
		}
		return valueBuilder.toString();
	}
	
	public String mapUsedWithNFKC(String value) throws IOException {
		StringBuilder valueBuilder = new StringBuilder();
		Map<Character, List<Character>> usedWithNFKC = new ParserMappingTables().parseMapUsedWithNFKC();
		char[] valueChar = value.toCharArray();
		for (int i=0; i<valueChar.length; i++) {
			List<Character> mapTo = usedWithNFKC.get(valueChar[i]);
			if (mapTo != null) {
				valueBuilder.deleteCharAt(i);
				for (int j=0; j<mapTo.size(); j++) {
					valueBuilder.insert(i+j, mapTo.get(j));
				}
			}
		}
		return valueBuilder.toString();
	}
	
	public String mapUsedWithNoNormalization(String value) throws IOException {
		StringBuilder valueBuilder = new StringBuilder();
		Map<Character, List<Character>> usedWithNormalization = new ParserMappingTables().parseMapUsedWithNoNormalization();
		char[] valueChar = value.toCharArray();
		for (int i=0; i<valueChar.length; i++) {
			List<Character> mapTo = usedWithNormalization.get(valueChar[i]);
			if (mapTo != null) {
				valueBuilder.deleteCharAt(i);
				for (int j=0; j<mapTo.size(); j++) {
					valueBuilder.insert(i+j, mapTo.get(j));
				}
			}
		}
		return valueBuilder.toString();
	}
	
	public boolean prohibitionAsciiSpace(char value) throws IOException {
		List<Character> asciiSpace = new ParserProhibitionTables().parseAsciiSpace();
		for (Character ch : asciiSpace) {
			if (value == ch.charValue()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionNonAsciiSpace(char value) throws IOException {
		List<Character> nonAsciiSpace = new ParserProhibitionTables().parseNonAsciiSpace();
		for (Character ch : nonAsciiSpace) {
			if (value == ch.charValue()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionAsciiControl(char value) throws IOException {
		List<Character[]> asciiControl = new ParserProhibitionTables().parseAsciiControl();
		for (int j=0; j<asciiControl.size(); j++) {
			if (value >= asciiControl.get(j)[0] && value <= asciiControl.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionNonAsciiControl(char value) throws IOException {
		List<Character[]> nonAsciiControl = new ParserProhibitionTables().parseNonAsciiControl();
		for (int j=0; j<nonAsciiControl.size(); j++) {
			if (value >= nonAsciiControl.get(j)[0] && value <= nonAsciiControl.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionPrivateUse(char value) throws IOException {
		List<int[]> privateUse = new ParserProhibitionTables().parsePrivateUse();
		for (int j=0; j<privateUse.size(); j++) {
			if ((int)value >= privateUse.get(j)[0] && value <= privateUse.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionNonCharacterCodePoints(char value) throws IOException {
		List<Character[]> nonCharacterCodePoints = new ParserProhibitionTables().parseNonCharacterCodePoints();
		for (int j=0; j<nonCharacterCodePoints.size(); j++) {
			if (value >= nonCharacterCodePoints.get(j)[0] && value <= nonCharacterCodePoints.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionSurrogateCodes(char value) throws IOException {
		List<Character[]> surrogateCodes = new ParserProhibitionTables().parseSurrogateCodes();
		for (int j=0; j<surrogateCodes.size(); j++) {
			if (value >= surrogateCodes.get(j)[0] && value <= surrogateCodes.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionInappropriatePlainText(char value) throws IOException {
		List<Character[]> inappropriatePlainText = new ParserProhibitionTables().parseInappropriatePlainText();
		for (int j=0; j<inappropriatePlainText.size(); j++) {
			if (value >= inappropriatePlainText.get(j)[0] && value <= inappropriatePlainText.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionInappropriateCanonicalRepresentation(char value) throws IOException {
		List<Character[]> inappropriateCanonicalRepresentation = new ParserProhibitionTables().parseInappropriateCanonicalRepresentation();
		for (int j=0; j<inappropriateCanonicalRepresentation.size(); j++) {
			if (value >= inappropriateCanonicalRepresentation.get(j)[0] && value <= inappropriateCanonicalRepresentation.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionChangeDisplayProperties(char value) throws IOException {
		List<Character[]> changeDisplayProperties = new ParserProhibitionTables().parseChangeDisplayProperties();
		for (int j=0; j<changeDisplayProperties.size(); j++) {
			if (value >= changeDisplayProperties.get(j)[0] && value <= changeDisplayProperties.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionTaggingCharacters(char value) throws IOException {
		List<int[]> taggingCharacters = new ParserProhibitionTables().parseTaggingCharacters();
		for (int j=0; j<taggingCharacters.size(); j++) {
			if (value >= taggingCharacters.get(j)[0] && value <= taggingCharacters.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bidirectionalPropertyRorAL(char value) throws IOException {
		List<Character[]> propertyRorAL = new ParserBidirectionalTables().parseBidirectionalPropertyRorAL();
		for (int j=0; j<propertyRorAL.size(); j++) {
			if (value >= propertyRorAL.get(j)[0] && value <= propertyRorAL.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bidirectionalPropertyL(char value) throws IOException {
		List<Character[]> propertyL = new ParserBidirectionalTables().parseBidirectionalPropertyL();
		for (int j=0; j<propertyL.size(); j++) {
			if (value >= propertyL.get(j)[0] && value <= propertyL.get(j)[1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bidirectional(boolean checkChangeDisplayProperties, String value) throws IllegalArgumentException, IOException {
		char[] characters = value.toCharArray();
		boolean propertyRorAL = false;
		boolean firstCharacterPropertyRorAL = false;
		boolean lastCharacterPropertyRorAL = false;
		boolean propertyL = false;
		for (int i=0; i<characters.length; i++) {
			char character = characters[i];
			//1) The characters in section 5.8 MUST be prohibited.
			if (checkChangeDisplayProperties) {
				if (this.prohibitionChangeDisplayProperties(character)) {
					throw new IllegalArgumentException("Prohibited character '"+character);
					//return false;
				}
			}
			if (bidirectionalPropertyRorAL(character)) {
				propertyRorAL = true;
				if (i == 0) {
					firstCharacterPropertyRorAL= true;
				} else if (i == characters.length-1) {
					lastCharacterPropertyRorAL = true;
				}
			}
			if (bidirectionalPropertyL(character)) {
				propertyL = true;
			}
		}
		//2) If a string contains any RandALCat character, 
		//the string MUST NOT contain any LCat character.
		if (propertyRorAL && propertyL) {
			throw new IllegalArgumentException("Prohibited string with RandALCat and LCat");
			//return false;
		}
		//3) If a string contains any RandALCat character, a RandALCat
	    //character MUST be the first character of the string, and a
	    //RandALCat character MUST be the last character of the string.
		if (propertyRorAL && !(firstCharacterPropertyRorAL && lastCharacterPropertyRorAL)) {
			throw new IllegalArgumentException("The string contains any RandALCat character "
					+ "but a RandALCat character is not the first and the last characters");
			//return false;
		}
		return true;
	}
}
