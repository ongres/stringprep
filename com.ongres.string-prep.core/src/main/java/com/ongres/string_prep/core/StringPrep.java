package com.ongres.string_prep.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ongres.string_prep.core.parsers.ParserBidirectionalTables;
import com.ongres.string_prep.core.parsers.ParserMappingTables;
import com.ongres.string_prep.core.parsers.ParserProhibitionTables;
import com.ongres.string_prep.core.parsers.ParserUnicodeRepertoires;

public class StringPrep {

	public boolean unassignedCodePoints(String value) throws IOException {
		Character[][] unassignedCodePoints = ParserUnicodeRepertoires.parseUnassignedCodePoints();
		char[] valueChar = value.toCharArray();
		for (int i=0; i<valueChar.length; i++) {
			for (int j=0; j<unassignedCodePoints.length; j++) {
				if (valueChar[i] >= unassignedCodePoints[j][0] && valueChar[i] <= unassignedCodePoints[i][1]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String mapToNothing(String value) throws IOException {
		StringBuilder valueBuilder = new StringBuilder(value);
		List<Character> mapToNothing = ParserMappingTables.parseMapToNothing();
		char[] valueChar = value.toCharArray();
		for (int i=0; i<value.length(); i++) {
			for(Character ch : mapToNothing) {
				if (valueChar[i] == ch.charValue()) {
					valueBuilder.deleteCharAt(i);
				}
			}
		}
		return valueBuilder.toString();
	}
	
	public String mapUsedWithNFKC(String value) throws IOException {
		StringBuilder valueBuilder = new StringBuilder();
		Map<Character, List<Character>> usedWithNFKC = ParserMappingTables.parseMapUsedWithNFKC();
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
		Map<Character, List<Character>> usedWithNormalization = ParserMappingTables.parseMapUsedWithNoNormalization();
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
		List<Character> asciiSpace = ParserProhibitionTables.parseAsciiSpace();
		for (Character ch : asciiSpace) {
			if (value == ch.charValue()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionNonAsciiSpace(char value) throws IOException {
		List<Character> nonAsciiSpace = ParserProhibitionTables.parseNonAsciiSpace();
		for (Character ch : nonAsciiSpace) {
			if (value == ch.charValue()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionAsciiControl(char value) throws IOException {
		Character[][] asciiControl = ParserProhibitionTables.parseAsciiControl();
		for (int j=0; j<asciiControl.length; j++) {
			if (value >= asciiControl[j][0] && value <= asciiControl[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionNonAsciiControl(char value) throws IOException {
		Character[][] nonAsciiControl = ParserProhibitionTables.parseNonAsciiControl();
		for (int j=0; j<nonAsciiControl.length; j++) {
			if (value >= nonAsciiControl[j][0] && value <= nonAsciiControl[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionPrivateUse(char value) throws IOException {
		Character[][] privateUse = ParserProhibitionTables.parsePrivateUse();
		for (int j=0; j<privateUse.length; j++) {
			if (value >= privateUse[j][0] && value <= privateUse[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionNonCharacterCodePoints(char value) throws IOException {
		Character[][] nonCharacterCodePoints = ParserProhibitionTables.parseNonCharacterCodePoints();
		for (int j=0; j<nonCharacterCodePoints.length; j++) {
			if (value >= nonCharacterCodePoints[j][0] && value <= nonCharacterCodePoints[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionSurrogateCodes(char value) throws IOException {
		Character[][] surrogateCodes = ParserProhibitionTables.parseSurrogateCodes();
		for (int j=0; j<surrogateCodes.length; j++) {
			if (value >= surrogateCodes[j][0] && value <= surrogateCodes[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionInappropriatePlainText(char value) throws IOException {
		Character[][] inappropriatePlainText = ParserProhibitionTables.parseInappropriatePlainText();
		for (int j=0; j<inappropriatePlainText.length; j++) {
			if (value >= inappropriatePlainText[j][0] && value <= inappropriatePlainText[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionInappropriateCanonicalRepresentation(char value) throws IOException {
		Character[][] inappropriateCanonicalRepresentation = ParserProhibitionTables.parseInappropriateCanonicalRepresentation();
		for (int j=0; j<inappropriateCanonicalRepresentation.length; j++) {
			if (value >= inappropriateCanonicalRepresentation[j][0] && value <= inappropriateCanonicalRepresentation[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionChangeDisplayProperties(char value) throws IOException {
		Character[][] changeDisplayProperties = ParserProhibitionTables.parseChangeDisplayProperties();
		for (int j=0; j<changeDisplayProperties.length; j++) {
			if (value >= changeDisplayProperties[j][0] && value <= changeDisplayProperties[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean prohibitionTaggingCharacters(char value) throws IOException {
		Character[][] taggingCharacters = ParserProhibitionTables.parseTaggingCharacters();
		for (int j=0; j<taggingCharacters.length; j++) {
			if (value >= taggingCharacters[j][0] && value <= taggingCharacters[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bidirectionalPropertyRorAL(char value) throws IOException {
		Character[][] propertyRorAL = ParserBidirectionalTables.parseBidirectionalPropertyRorAL();
		for (int j=0; j<propertyRorAL.length; j++) {
			if (value >= propertyRorAL[j][0] && value <= propertyRorAL[j][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bidirectionalPropertyL(char value) throws IOException {
		Character[][] propertyL = ParserBidirectionalTables.parseBidirectionalPropertyL();
		for (int j=0; j<propertyL.length; j++) {
			if (value >= propertyL[j][0] && value <= propertyL[j][1]) {
				return true;
			}
		}
		return false;
	}
}
