package com.ongres.string_prep.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ongres.string_prep.core.parsers.ParserBidirectionalTables;
import com.ongres.string_prep.core.parsers.ParserMappingTables;
import com.ongres.string_prep.core.parsers.ParserProhibitionTables;
import com.ongres.string_prep.core.parsers.ParserUnicodeRepertoires;

public class StringPrep {

    public boolean unassignedCodePoints(int value) throws IOException {
        List<int[]> unassignedCodePoints = new ParserUnicodeRepertoires().parseUnassignedCodePoints();
        for (int j=0; j<unassignedCodePoints.size(); j++) {
            if (value >= unassignedCodePoints.get(j)[0] && value <= unassignedCodePoints.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public List<Integer> mapToNothing(List<Integer> value) throws IOException {
        List<Integer> valueBuilder = new ArrayList<>(value);
        List<Integer> mapToNothing = new ParserMappingTables().parseMapToNothing();
        for (int i=0, j=0; i<value.size(); i++, j++) {
            for(int ch : mapToNothing) {
                if (value.get(i) == ch) {
                    valueBuilder.remove(j);
                    j--;
                    break;
                }
            }
        }
        return valueBuilder;
    }
    
    public List<Integer> mapUsedWithNFKC(List<Integer> value) throws IOException {
        List<Integer> valueBuilder = new ArrayList<>();
        Map<Integer, List<Integer>> usedWithNFKC = new ParserMappingTables().parseMapUsedWithNFKC();
        for (int i=0; i<value.size(); i++) {
            List<Integer> mapTo = usedWithNFKC.get(value.get(i));
            if (mapTo != null) {
                for (int j=0; j<mapTo.size(); j++) {
                    valueBuilder.add(mapTo.get(j));
                }
            } else {
                valueBuilder.add(value.get(i));
            }
        }
        return valueBuilder;
    }
    
    public List<Integer> mapUsedWithNoNormalization(List<Integer> value) throws IOException {
        List<Integer> valueBuilder = new ArrayList<>();
        Map<Integer, List<Integer>> usedWithNormalization = new ParserMappingTables().parseMapUsedWithNoNormalization();
        for (int i=0; i<value.size(); i++) {
            List<Integer> mapTo = usedWithNormalization.get(value.get(i));
            if (mapTo != null) {
                for (int j=0; j<mapTo.size(); j++) {
                    valueBuilder.add(mapTo.get(j));
                }
            } else {
                valueBuilder.add(value.get(i));
            }
        }
        return valueBuilder;
    }
    
    public boolean prohibitionAsciiSpace(int value) throws IOException {
        List<Integer> asciiSpace = new ParserProhibitionTables().parseAsciiSpace();
        for (Integer ch : asciiSpace) {
            if (value == ch) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionNonAsciiSpace(int value) throws IOException {
        List<Integer> nonAsciiSpace = new ParserProhibitionTables().parseNonAsciiSpace();
        for (Integer ch : nonAsciiSpace) {
            if (value == ch) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionAsciiControl(int value) throws IOException {
        List<int[]> asciiControl = new ParserProhibitionTables().parseAsciiControl();
        for (int j=0; j<asciiControl.size(); j++) {
            if (value >= asciiControl.get(j)[0] && value <= asciiControl.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionNonAsciiControl(int value) throws IOException {
        List<int[]> nonAsciiControl = new ParserProhibitionTables().parseNonAsciiControl();
        for (int j=0; j<nonAsciiControl.size(); j++) {
            if (value >= nonAsciiControl.get(j)[0] && value <= nonAsciiControl.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionPrivateUse(int value) throws IOException {
        List<int[]> privateUse = new ParserProhibitionTables().parsePrivateUse();
        for (int j=0; j<privateUse.size(); j++) {
            if ((int)value >= privateUse.get(j)[0] && value <= privateUse.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionNonCharacterCodePoints(int value) throws IOException {
        List<int[]> nonCharacterCodePoints = new ParserProhibitionTables().parseNonCharacterCodePoints();
        for (int j=0; j<nonCharacterCodePoints.size(); j++) {
            if (value >= nonCharacterCodePoints.get(j)[0] && value <= nonCharacterCodePoints.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionSurrogateCodes(int value) throws IOException {
        List<int[]> surrogateCodes = new ParserProhibitionTables().parseSurrogateCodes();
        for (int j=0; j<surrogateCodes.size(); j++) {
            if (value >= surrogateCodes.get(j)[0] && value <= surrogateCodes.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionInappropriatePlainText(int value) throws IOException {
        List<int[]> inappropriatePlainText = new ParserProhibitionTables().parseInappropriatePlainText();
        for (int j=0; j<inappropriatePlainText.size(); j++) {
            if (value >= inappropriatePlainText.get(j)[0] && value <= inappropriatePlainText.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionInappropriateCanonicalRepresentation(int value) throws IOException {
        List<int[]> inappropriateCanonicalRepresentation = new ParserProhibitionTables().parseInappropriateCanonicalRepresentation();
        for (int j=0; j<inappropriateCanonicalRepresentation.size(); j++) {
            if (value >= inappropriateCanonicalRepresentation.get(j)[0] && value <= inappropriateCanonicalRepresentation.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionChangeDisplayProperties(int value) throws IOException {
        List<int[]> changeDisplayProperties = new ParserProhibitionTables().parseChangeDisplayProperties();
        for (int j=0; j<changeDisplayProperties.size(); j++) {
            if (value >= changeDisplayProperties.get(j)[0] && value <= changeDisplayProperties.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionTaggingCharacters(int value) throws IOException {
        List<int[]> taggingCharacters = new ParserProhibitionTables().parseTaggingCharacters();
        for (int j=0; j<taggingCharacters.size(); j++) {
            if (value >= taggingCharacters.get(j)[0] && value <= taggingCharacters.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean bidirectionalPropertyRorAL(int value) throws IOException {
        List<int[]> propertyRorAL = new ParserBidirectionalTables().parseBidirectionalPropertyRorAL();
        for (int j=0; j<propertyRorAL.size(); j++) {
            if (value >= propertyRorAL.get(j)[0] && value <= propertyRorAL.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean bidirectionalPropertyL(int value) throws IOException {
        List<int[]> propertyL = new ParserBidirectionalTables().parseBidirectionalPropertyL();
        for (int j=0; j<propertyL.size(); j++) {
            if (value >= propertyL.get(j)[0] && value <= propertyL.get(j)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean bidirectional(List<Integer> value) throws IllegalArgumentException, IOException {
        boolean propertyRorAL = false;
        boolean firstCharacterPropertyRorAL = false;
        boolean lastCharacterPropertyRorAL = false;
        boolean propertyL = false;
        for (int i=0; i<value.size(); i++) {
            int character = value.get(i);
            //1) The characters in section 5.8 MUST be prohibited.
            if (this.prohibitionChangeDisplayProperties(character)) {
                throw new IllegalArgumentException("Prohibited codepoint " + character + " at position " + i 
                        + " (unicode name: " + Character.getName(character) + ")");
            }
            if (bidirectionalPropertyRorAL(character)) {
                propertyRorAL = true;
                if (i == 0) {
                    firstCharacterPropertyRorAL= true;
                } else if (i == value.size()-1) {
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
        }
        //3) If a string contains any RandALCat character, a RandALCat
        //character MUST be the first character of the string, and a
        //RandALCat character MUST be the last character of the string.
        if (propertyRorAL && !(firstCharacterPropertyRorAL && lastCharacterPropertyRorAL)) {
            throw new IllegalArgumentException("The string contains any RandALCat character "
                    + "but a RandALCat character is not the first and the last characters");
        }
        return true;
    }
}
