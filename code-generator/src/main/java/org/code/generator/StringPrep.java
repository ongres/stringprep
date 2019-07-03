package org.code.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.code.generator.parsers.ParserBidirectionalTables;
import org.code.generator.parsers.ParserMappingTables;
import org.code.generator.parsers.ParserProhibitionTables;
import org.code.generator.parsers.ParserUnicodeRepertoires;

public class StringPrep {
    
    private final List<List<Integer>> unassignedCodePoints;
    private final List<Integer> mapToNothing;
    private final Map<Integer, List<Integer>> mapUsedWithNFKC;
    private final Map<Integer, List<Integer>> mapUsedWithNoNormalization;
    private final List<Integer> asciiSpace;
    private final List<Integer> nonAsciiSpace;
    private final List<List<Integer>> asciiControl;
    private final List<List<Integer>> nonAsciiControl;
    private final List<List<Integer>> privateUse;
    private final List<List<Integer>> nonCharacterCodePoints;
    private final List<List<Integer>> surrogateCodes;
    private final List<List<Integer>> inappropriatePlainText;
    private final List<List<Integer>> inappropriateCanonicalRepresentation;
    private final List<List<Integer>> changeDisplayProperties;
    private final List<List<Integer>> taggingCharacters;
    private final List<List<Integer>> propertyRorAL;
    private final List<List<Integer>> propertyL;
    
    public StringPrep() throws IOException {
            unassignedCodePoints = ParserUnicodeRepertoires.parseUnassignedCodePoints();
            mapToNothing = ParserMappingTables.parseMapToNothing();
            mapUsedWithNFKC = ParserMappingTables.parseMapUsedWithNFKC();
            mapUsedWithNoNormalization = ParserMappingTables.parseMapUsedWithNoNormalization();
            asciiSpace = ParserProhibitionTables.parseAsciiSpace();
            nonAsciiSpace = ParserProhibitionTables.parseNonAsciiSpace();
            asciiControl = ParserProhibitionTables.parseAsciiControl();
            nonAsciiControl = ParserProhibitionTables.parseNonAsciiControl();
            privateUse = ParserProhibitionTables.parsePrivateUse();
            nonCharacterCodePoints = ParserProhibitionTables.parseNonCharacterCodePoints();
            surrogateCodes = ParserProhibitionTables.parseSurrogateCodes();
            inappropriatePlainText = ParserProhibitionTables.parseInappropriatePlainText();
            inappropriateCanonicalRepresentation = ParserProhibitionTables.parseInappropriateCanonicalRepresentation();
            changeDisplayProperties = ParserProhibitionTables.parseChangeDisplayProperties();
            taggingCharacters = ParserProhibitionTables.parseTaggingCharacters();
            propertyRorAL = ParserBidirectionalTables.parseBidirectionalPropertyRorAL();
            propertyL = ParserBidirectionalTables.parseBidirectionalPropertyL();
    }

    public List<List<Integer>> getUnassignedCodePoints() {
        return unassignedCodePoints;
    }

    public List<Integer> getMapToNothing() {
        return mapToNothing;
    }

    public Map<Integer, List<Integer>> getMapUsedWithNFKC() {
        return mapUsedWithNFKC;
    }

    public Map<Integer, List<Integer>> getMapUsedWithNoNormalization() {
        return mapUsedWithNoNormalization;
    }

    public List<Integer> getAsciiSpace() {
        return asciiSpace;
    }

    public List<Integer> getNonAsciiSpace() {
        return nonAsciiSpace;
    }

    public List<List<Integer>> getAsciiControl() {
        return asciiControl;
    }

    public List<List<Integer>> getNonAsciiControl() {
        return nonAsciiControl;
    }

    public List<List<Integer>> getPrivateUse() {
        return privateUse;
    }

    public List<List<Integer>> getNonCharacterCodePoints() {
        return nonCharacterCodePoints;
    }

    public List<List<Integer>> getSurrogateCodes() {
        return surrogateCodes;
    }

    public List<List<Integer>> getInappropriatePlainText() {
        return inappropriatePlainText;
    }

    public List<List<Integer>> getInappropriateCanonicalRepresentation() {
        return inappropriateCanonicalRepresentation;
    }

    public List<List<Integer>> getChangeDisplayProperties() {
        return changeDisplayProperties;
    }

    public List<List<Integer>> getTaggingCharacters() {
        return taggingCharacters;
    }

    public List<List<Integer>> getPropertyRorAL() {
        return propertyRorAL;
    }

    public List<List<Integer>> getPropertyL() {
        return propertyL;
    }

    public boolean unassignedCodePoints(int value) throws IOException {
        for (int j=0; j<unassignedCodePoints.size(); j++) {
            if (value >= unassignedCodePoints.get(j).get(0) && value <= unassignedCodePoints.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public List<Integer> mapToNothing(List<Integer> value) throws IOException {
        List<Integer> valueBuilder = new ArrayList<>(value);
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
        for (int i=0; i<value.size(); i++) {
            List<Integer> mapTo = mapUsedWithNFKC.get(value.get(i));
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
        for (int i=0; i<value.size(); i++) {
            List<Integer> mapTo = mapUsedWithNoNormalization.get(value.get(i));
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
        for (Integer ch : asciiSpace) {
            if (value == ch) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionNonAsciiSpace(int value) throws IOException {
        for (Integer ch : nonAsciiSpace) {
            if (value == ch) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionAsciiControl(int value) throws IOException {
        for (int j=0; j<asciiControl.size(); j++) {
            if (value >= asciiControl.get(j).get(0) && value <= asciiControl.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionNonAsciiControl(int value) throws IOException {
        for (int j=0; j<nonAsciiControl.size(); j++) {
            if (value >= nonAsciiControl.get(j).get(0) && value <= nonAsciiControl.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionPrivateUse(int value) throws IOException {
        for (int j=0; j<privateUse.size(); j++) {
            if (value >= privateUse.get(j).get(0) && value <= privateUse.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionNonCharacterCodePoints(int value) throws IOException {
        for (int j=0; j<nonCharacterCodePoints.size(); j++) {
            if (value >= nonCharacterCodePoints.get(j).get(0) && value <= nonCharacterCodePoints.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionSurrogateCodes(int value) throws IOException {
        for (int j=0; j<surrogateCodes.size(); j++) {
            if (value >= surrogateCodes.get(j).get(0) && value <= surrogateCodes.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionInappropriatePlainText(int value) throws IOException {
        for (int j=0; j<inappropriatePlainText.size(); j++) {
            if (value >= inappropriatePlainText.get(j).get(0) && value <= inappropriatePlainText.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionInappropriateCanonicalRepresentation(int value) throws IOException {
        for (int j=0; j<inappropriateCanonicalRepresentation.size(); j++) {
            if (value >= inappropriateCanonicalRepresentation.get(j).get(0) && value <= inappropriateCanonicalRepresentation.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionChangeDisplayProperties(int value) throws IOException {
        for (int j=0; j<changeDisplayProperties.size(); j++) {
            if (value >= changeDisplayProperties.get(j).get(0) && value <= changeDisplayProperties.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean prohibitionTaggingCharacters(int value) throws IOException {
        for (int j=0; j<taggingCharacters.size(); j++) {
            if (value >= taggingCharacters.get(j).get(0) && value <= taggingCharacters.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean bidirectionalPropertyRorAL(int value) throws IOException {
        for (int j=0; j<propertyRorAL.size(); j++) {
            if (value >= propertyRorAL.get(j).get(0) && value <= propertyRorAL.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean bidirectionalPropertyL(int value) throws IOException {
        for (int j=0; j<propertyL.size(); j++) {
            if (value >= propertyL.get(j).get(0) && value <= propertyL.get(j).get(1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean bidirectional(List<Integer> value) throws IllegalArgumentException, IOException {
        boolean containPropertyRorAL = false;
        boolean firstCharacterPropertyRorAL = false;
        boolean lastCharacterPropertyRorAL = false;
        boolean containPropertyL = false;
        for (int i=0; i<value.size(); i++) {
            int character = value.get(i);
            //1) The characters in section 5.8 MUST be prohibited.
            if (this.prohibitionChangeDisplayProperties(character)) {
                throw new IllegalArgumentException("Prohibited codepoint " + character + " at position " + i 
                        + " (unicode name: " + Character.getName(character) + ")");
            }
            if (bidirectionalPropertyRorAL(character)) {
                containPropertyRorAL = true;
                if (i == 0) {
                    firstCharacterPropertyRorAL= true;
                } else if (i == value.size()-1) {
                    lastCharacterPropertyRorAL = true;
                }
            }
            if (bidirectionalPropertyL(character)) {
                containPropertyL = true;
            }
        }
        //2) If a string contains any RandALCat character, 
        //the string MUST NOT contain any LCat character.
        if (containPropertyRorAL && containPropertyL) {
            throw new IllegalArgumentException("Prohibited string with RandALCat and LCat");
        }
        //3) If a string contains any RandALCat character, a RandALCat
        //character MUST be the first character of the string, and a
        //RandALCat character MUST be the last character of the string.
        if (containPropertyRorAL && !(firstCharacterPropertyRorAL && lastCharacterPropertyRorAL)) {
            throw new IllegalArgumentException("The string contains any RandALCat character "
                    + "but a RandALCat character is not the first and the last characters");
        }
        return true;
    }
}
