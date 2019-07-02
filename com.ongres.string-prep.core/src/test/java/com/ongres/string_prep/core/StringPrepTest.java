package com.ongres.string_prep.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringPrepTest {

    @Test
    public void testBidirectionalTables() throws Exception {
        StringPrep stringPrep = new StringPrep();
        //Property R or AL
        assertTrue(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("061B", 16)));
        assertTrue(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("FE76", 16)));
        assertTrue(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("FEFC", 16)));
        assertTrue(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("FE71", 16)));
        assertFalse(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("066C", 16)));
        assertFalse(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("06D6", 16)));
        assertFalse(stringPrep.bidirectionalPropertyRorAL(Integer.parseInt("0041", 16)));
        
        //Property L
        assertTrue(stringPrep.bidirectionalPropertyL(Integer.parseInt("1D4A2", 16)));
        assertTrue(stringPrep.bidirectionalPropertyL(Integer.parseInt("20000", 16)));
        assertTrue(stringPrep.bidirectionalPropertyL(Integer.parseInt("2A6D6", 16)));
        assertTrue(stringPrep.bidirectionalPropertyL(Integer.parseInt("10FFFC", 16)));
        assertFalse(stringPrep.bidirectionalPropertyL(Integer.parseInt("0040", 16)));
        assertFalse(stringPrep.bidirectionalPropertyL(Integer.parseInt("005B", 16)));
        assertFalse(stringPrep.bidirectionalPropertyL(Integer.parseInt("037B", 16)));
        
        //Properties R or AL and L
        try {
            stringPrep.bidirectional(Arrays.asList(Integer.parseInt("200E", 16)));
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().startsWith("Prohibited codepoint 8206 at position 0"));
        }
        try {
            stringPrep.bidirectional(Arrays.asList(Integer.parseInt("061B", 16), Integer.parseInt("1D4A2", 16)));
        } catch (IllegalArgumentException e) {
            assertEquals("Prohibited string with RandALCat and LCat", e.getMessage());
        }
        try {
            stringPrep.bidirectional(Arrays.asList(Integer.parseInt("061B", 16), Integer.parseInt("0000", 16)));
        } catch (IllegalArgumentException e) {
            assertEquals("The string contains any RandALCat character but a RandALCat character is not the first and the last characters", 
                    e.getMessage());
        }
    }
    
    @Test
    public void testMappingTables() throws Exception {
        StringPrep stringPrep = new StringPrep();
        //Map to nothing
        List<Integer> result = stringPrep.mapToNothing(Arrays.asList(Integer.parseInt("00AD", 16), 
                Integer.parseInt("0100", 16), Integer.parseInt("FE0F", 16)));
        assertEquals(1, result.size());
        assertEquals(Integer.parseInt("0100", 16), result.get(0).intValue());
        
        //Map NFKC
        result = stringPrep.mapUsedWithNFKC(Arrays.asList(Integer.parseInt("00DF", 16),
                Integer.parseInt("33C6", 16), Integer.parseInt("03B0", 16), Integer.parseInt("1D7BB", 16),
                Integer.parseInt("1D7BC", 16)));
        assertEquals(11, result.size());
        assertTrue(Integer.parseInt("0073", 16) == result.get(0));
        assertTrue(Integer.parseInt("0073", 16) == result.get(1));
        assertTrue(Integer.parseInt("0063", 16) == result.get(2));
        assertTrue(Integer.parseInt("2215", 16) == result.get(3));
        assertTrue(Integer.parseInt("006B", 16) == result.get(4));
        assertTrue(Integer.parseInt("0067", 16) == result.get(5));
        assertTrue(Integer.parseInt("03C5", 16) == result.get(6));
        assertTrue(Integer.parseInt("0308", 16) == result.get(7));
        assertTrue(Integer.parseInt("0301", 16) == result.get(8));
        assertTrue(Integer.parseInt("03C3", 16) == result.get(9));
        assertTrue(Integer.parseInt("1D7BC", 16) == result.get(10));
        
        //Map NoNormalization
        result = stringPrep.mapUsedWithNoNormalization(Arrays.asList(Integer.parseInt("10425", 16),
                Integer.parseInt("0130", 16), Integer.parseInt("0390", 16), Integer.parseInt("10426", 16)));
        assertEquals(7, result.size());
        assertTrue(Integer.parseInt("1044D", 16) == result.get(0));
        assertTrue(Integer.parseInt("0069", 16) == result.get(1));
        assertTrue(Integer.parseInt("0307", 16) == result.get(2));
        assertTrue(Integer.parseInt("03B9", 16) == result.get(3));
        assertTrue(Integer.parseInt("0308", 16) == result.get(4));
        assertTrue(Integer.parseInt("0301", 16) == result.get(5));
        assertTrue(Integer.parseInt("10426", 16) == result.get(6));
    }
    
    @Test
    public void testProhibitionTables() throws NumberFormatException, IOException {
        StringPrep stringPrep = new StringPrep();
        //AsciiSpace
        assertFalse(stringPrep.prohibitionAsciiSpace(Integer.parseInt("00A0", 16)));
        assertTrue(stringPrep.prohibitionAsciiSpace(Integer.parseInt("0020", 16)));
        //NonAsciiSpace
        assertTrue(stringPrep.prohibitionNonAsciiSpace(Integer.parseInt("00A0", 16)));
        assertFalse(stringPrep.prohibitionNonAsciiSpace(Integer.parseInt("0020", 16)));
        //AsciiControl
        assertTrue(stringPrep.prohibitionAsciiControl(Integer.parseInt("0000", 16)));
        assertTrue(stringPrep.prohibitionAsciiControl(Integer.parseInt("0001", 16)));
        assertTrue(stringPrep.prohibitionAsciiControl(Integer.parseInt("001F", 16)));
        assertTrue(stringPrep.prohibitionAsciiControl(Integer.parseInt("007F", 16)));
        assertFalse(stringPrep.prohibitionAsciiControl(Integer.parseInt("0020", 16)));
        //NonAsciiControl
        assertTrue(stringPrep.prohibitionNonAsciiControl(Integer.parseInt("1D173", 16)));
        assertTrue(stringPrep.prohibitionNonAsciiControl(Integer.parseInt("1D17A", 16)));
        assertTrue(stringPrep.prohibitionNonAsciiControl(Integer.parseInt("1D175", 16)));
        assertTrue(stringPrep.prohibitionNonAsciiControl(Integer.parseInt("2028", 16)));
        assertFalse(stringPrep.prohibitionNonAsciiControl(Integer.parseInt("0000", 16)));
        //PrivateUse
        assertTrue(stringPrep.prohibitionPrivateUse(Integer.parseInt("100000", 16)));
        assertTrue(stringPrep.prohibitionPrivateUse(Integer.parseInt("10000A", 16)));
        assertTrue(stringPrep.prohibitionPrivateUse(Integer.parseInt("10FFFD", 16)));
        assertFalse(stringPrep.prohibitionPrivateUse(Integer.parseInt("FFFF", 16)));
        //NonCharacterCodePoints
        assertTrue(stringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("10FFFE", 16)));
        assertTrue(stringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("10FFFF", 16)));
        assertTrue(stringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("FDEE", 16)));
        assertFalse(stringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("10FFFD", 16)));
        //SurrogateCodes
        assertTrue(stringPrep.prohibitionSurrogateCodes(Integer.parseInt("D800", 16)));
        assertTrue(stringPrep.prohibitionSurrogateCodes(Integer.parseInt("D805", 16)));
        assertTrue(stringPrep.prohibitionSurrogateCodes(Integer.parseInt("DFFF", 16)));
        assertFalse(stringPrep.prohibitionSurrogateCodes(Integer.parseInt("10FFFD", 16)));
        //InappropiatePlainText
        assertTrue(stringPrep.prohibitionInappropriatePlainText(Integer.parseInt("FFF9", 16)));
        assertFalse(stringPrep.prohibitionInappropriatePlainText(Integer.parseInt("100000", 16)));
        //InappropriateCanonicalRepresentation
        assertTrue(stringPrep.prohibitionInappropriateCanonicalRepresentation(Integer.parseInt("2FF0", 16)));
        assertTrue(stringPrep.prohibitionInappropriateCanonicalRepresentation(Integer.parseInt("2FFB", 16)));
        assertTrue(stringPrep.prohibitionInappropriateCanonicalRepresentation(Integer.parseInt("2FF3", 16)));
        assertFalse(stringPrep.prohibitionInappropriateCanonicalRepresentation(Integer.parseInt("100000", 16)));
        //ChangeDisplayProperties
        assertTrue(stringPrep.prohibitionChangeDisplayProperties(Integer.parseInt("200E", 16)));
        assertFalse(stringPrep.prohibitionChangeDisplayProperties(Integer.parseInt("2FF0", 16)));
        //TaggingCharacters
        assertTrue(stringPrep.prohibitionTaggingCharacters(Integer.parseInt("E0001", 16)));
        assertTrue(stringPrep.prohibitionTaggingCharacters(Integer.parseInt("E0020", 16)));
        assertTrue(stringPrep.prohibitionTaggingCharacters(Integer.parseInt("E002F", 16)));
        assertTrue(stringPrep.prohibitionTaggingCharacters(Integer.parseInt("E007F", 16)));
        assertFalse(stringPrep.prohibitionTaggingCharacters(Integer.parseInt("D800", 16)));
    }
    
    @Test
    public void testUnicodeRepertoires() throws NumberFormatException, IOException {
        StringPrep stringPrep = new StringPrep();
        assertTrue(stringPrep.unassignedCodePoints(Integer.parseInt("1D49D", 16)));
        assertTrue(stringPrep.unassignedCodePoints(Integer.parseInt("E0080", 16)));
        assertTrue(stringPrep.unassignedCodePoints(Integer.parseInt("E2FFD", 16)));
        assertTrue(stringPrep.unassignedCodePoints(Integer.parseInt("EFFFD", 16)));
        assertFalse(stringPrep.unassignedCodePoints(Integer.parseInt("E0001", 16)));
    }
}
