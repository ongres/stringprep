package com.ongres.stringprep.stringprep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class StringPrepTest {

  @Test
    public void testBidirectionalTables() throws Exception {
    //Property R or AL
    assertTrue(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("061B", 16)));
    assertTrue(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("FE76", 16)));
    assertTrue(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("FEFC", 16)));
    assertTrue(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("FE71", 16)));
    assertFalse(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("066C", 16)));
    assertFalse(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("06D6", 16)));
    assertFalse(StringPrep.bidirectionalPropertyRorAL(Integer.parseInt("0041", 16)));
    
    //Property L
    assertTrue(StringPrep.bidirectionalPropertyL(Integer.parseInt("1D4A2", 16)));
    assertTrue(StringPrep.bidirectionalPropertyL(Integer.parseInt("20000", 16)));
    assertTrue(StringPrep.bidirectionalPropertyL(Integer.parseInt("2A6D6", 16)));
    assertTrue(StringPrep.bidirectionalPropertyL(Integer.parseInt("10FFFC", 16)));
    assertFalse(StringPrep.bidirectionalPropertyL(Integer.parseInt("0040", 16)));
    assertFalse(StringPrep.bidirectionalPropertyL(Integer.parseInt("005B", 16)));
    assertFalse(StringPrep.bidirectionalPropertyL(Integer.parseInt("037B", 16)));
    
    //Properties R or AL and L
    try {
      StringPrep.bidirectional(Arrays.asList(Integer.parseInt("200E", 16)));
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().startsWith("Prohibited codepoint 8206 at position 0"));
    }
    try {
      StringPrep.bidirectional(Arrays.asList(Integer.parseInt("061B", 16), 
              Integer.parseInt("1D4A2", 16)));
    } catch (IllegalArgumentException e) {
      assertEquals("Prohibited string with RandALCat and LCat", e.getMessage());
    }
    try {
      StringPrep.bidirectional(Arrays.asList(Integer.parseInt("061B", 16), 
              Integer.parseInt("0000", 16)));
    } catch (IllegalArgumentException e) {
      assertEquals(
              "The string contains any RandALCat character but a RandALCat character "
              + "is not the first and the last characters", 
                e.getMessage());
    }
  }
    
  @Test
    public void testMappingTables() throws Exception {
    //Map to nothing
    assertTrue(StringPrep.mapToNothing(Integer.parseInt("00AD", 16)));
    assertFalse(StringPrep.mapToNothing(Integer.parseInt("0100", 16)));
    assertTrue(StringPrep.mapToNothing(Integer.parseInt("FE0F", 16)));
    
    //Map NFKC
    int[] result = StringPrep.mapUsedWithNfkc(Integer.parseInt("00DF", 16));
    assertEquals(2, result.length);
    assertEquals(Integer.parseInt("0073", 16), result[0]);
    assertEquals(Integer.parseInt("0073", 16), result[1]);
    result = StringPrep.mapUsedWithNfkc(Integer.parseInt("33C6", 16));
    assertEquals(4, result.length);
    assertEquals(Integer.parseInt("0063", 16), result[0]);
    assertEquals(Integer.parseInt("2215", 16), result[1]);
    assertEquals(Integer.parseInt("006B", 16), result[2]);
    assertEquals(Integer.parseInt("0067", 16), result[3]);
    result = StringPrep.mapUsedWithNfkc(Integer.parseInt("03B0", 16));
    assertEquals(3, result.length);
    assertEquals(Integer.parseInt("03C5", 16), result[0]);
    assertEquals(Integer.parseInt("0308", 16), result[1]);
    assertEquals(Integer.parseInt("0301", 16), result[2]);
    result = StringPrep.mapUsedWithNfkc(Integer.parseInt("1D7BB", 16));
    assertEquals(1, result.length);
    assertEquals(Integer.parseInt("03C3", 16), result[0]);
    result = StringPrep.mapUsedWithNfkc(Integer.parseInt("1D7BC", 16));
    assertEquals(1, result.length);
    assertEquals(Integer.parseInt("1D7BC", 16), result[0]);
    
    //Map NoNormalization
    result = StringPrep.mapUsedWithNoNormalization(Integer.parseInt("10425", 16));
    assertEquals(1, result.length);
    assertEquals(Integer.parseInt("1044D", 16), result[0]);
    result = StringPrep.mapUsedWithNoNormalization(Integer.parseInt("0130", 16));
    assertEquals(2, result.length);
    assertEquals(Integer.parseInt("0069", 16), result[0]);
    assertEquals(Integer.parseInt("0307", 16), result[1]);
    result = StringPrep.mapUsedWithNoNormalization(Integer.parseInt("0390", 16));
    assertEquals(3, result.length);
    assertEquals(Integer.parseInt("03B9", 16), result[0]);
    assertEquals(Integer.parseInt("0308", 16), result[1]);
    assertEquals(Integer.parseInt("0301", 16), result[2]);
    result = StringPrep.mapUsedWithNoNormalization(Integer.parseInt("10426", 16));
    assertEquals(1, result.length);
    assertEquals(Integer.parseInt("10426", 16), result[0]);
  }
    
  @Test
    public void testProhibitionTables() throws NumberFormatException, IOException {
    //AsciiSpace
    assertFalse(StringPrep.prohibitionAsciiSpace(Integer.parseInt("00A0", 16)));
    assertTrue(StringPrep.prohibitionAsciiSpace(Integer.parseInt("0020", 16)));
    //NonAsciiSpace
    assertTrue(StringPrep.prohibitionNonAsciiSpace(Integer.parseInt("00A0", 16)));
    assertFalse(StringPrep.prohibitionNonAsciiSpace(Integer.parseInt("0020", 16)));
    //AsciiControl
    assertTrue(StringPrep.prohibitionAsciiControl(Integer.parseInt("0000", 16)));
    assertTrue(StringPrep.prohibitionAsciiControl(Integer.parseInt("0001", 16)));
    assertTrue(StringPrep.prohibitionAsciiControl(Integer.parseInt("001F", 16)));
    assertTrue(StringPrep.prohibitionAsciiControl(Integer.parseInt("007F", 16)));
    assertFalse(StringPrep.prohibitionAsciiControl(Integer.parseInt("0020", 16)));
    //NonAsciiControl
    assertTrue(StringPrep.prohibitionNonAsciiControl(Integer.parseInt("1D173", 16)));
    assertTrue(StringPrep.prohibitionNonAsciiControl(Integer.parseInt("1D17A", 16)));
    assertTrue(StringPrep.prohibitionNonAsciiControl(Integer.parseInt("1D175", 16)));
    assertTrue(StringPrep.prohibitionNonAsciiControl(Integer.parseInt("2028", 16)));
    assertFalse(StringPrep.prohibitionNonAsciiControl(Integer.parseInt("0000", 16)));
    //PrivateUse
    assertTrue(StringPrep.prohibitionPrivateUse(Integer.parseInt("100000", 16)));
    assertTrue(StringPrep.prohibitionPrivateUse(Integer.parseInt("10000A", 16)));
    assertTrue(StringPrep.prohibitionPrivateUse(Integer.parseInt("10FFFD", 16)));
    assertFalse(StringPrep.prohibitionPrivateUse(Integer.parseInt("FFFF", 16)));
    //NonCharacterCodePoints
    assertTrue(StringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("10FFFE", 16)));
    assertTrue(StringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("10FFFF", 16)));
    assertTrue(StringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("FDEE", 16)));
    assertFalse(StringPrep.prohibitionNonCharacterCodePoints(Integer.parseInt("10FFFD", 16)));
    //SurrogateCodes
    assertTrue(StringPrep.prohibitionSurrogateCodes(Integer.parseInt("D800", 16)));
    assertTrue(StringPrep.prohibitionSurrogateCodes(Integer.parseInt("D805", 16)));
    assertTrue(StringPrep.prohibitionSurrogateCodes(Integer.parseInt("DFFF", 16)));
    assertFalse(StringPrep.prohibitionSurrogateCodes(Integer.parseInt("10FFFD", 16)));
    //InappropiatePlainText
    assertTrue(StringPrep.prohibitionInappropriatePlainText(Integer.parseInt("FFF9", 16)));
    assertFalse(StringPrep.prohibitionInappropriatePlainText(Integer.parseInt("100000", 16)));
    //InappropriateCanonicalRepresentation
    assertTrue(StringPrep.prohibitionInappropriateCanonicalRepresentation(
            Integer.parseInt("2FF0", 16)));
    assertTrue(StringPrep.prohibitionInappropriateCanonicalRepresentation(
            Integer.parseInt("2FFB", 16)));
    assertTrue(StringPrep.prohibitionInappropriateCanonicalRepresentation(
            Integer.parseInt("2FF3", 16)));
    assertFalse(StringPrep.prohibitionInappropriateCanonicalRepresentation(
            Integer.parseInt("100000", 16)));
    //ChangeDisplayProperties
    assertTrue(StringPrep.prohibitionChangeDisplayProperties(Integer.parseInt("200E", 16)));
    assertFalse(StringPrep.prohibitionChangeDisplayProperties(Integer.parseInt("2FF0", 16)));
    //TaggingCharacters
    assertTrue(StringPrep.prohibitionTaggingCharacters(Integer.parseInt("E0001", 16)));
    assertTrue(StringPrep.prohibitionTaggingCharacters(Integer.parseInt("E0020", 16)));
    assertTrue(StringPrep.prohibitionTaggingCharacters(Integer.parseInt("E002F", 16)));
    assertTrue(StringPrep.prohibitionTaggingCharacters(Integer.parseInt("E007F", 16)));
    assertFalse(StringPrep.prohibitionTaggingCharacters(Integer.parseInt("D800", 16)));
  }
    
  @Test
    public void testUnicodeRepertoires() throws NumberFormatException, IOException {
    assertTrue(StringPrep.unassignedCodePoints(Integer.parseInt("1D49D", 16)));
    assertTrue(StringPrep.unassignedCodePoints(Integer.parseInt("E0080", 16)));
    assertTrue(StringPrep.unassignedCodePoints(Integer.parseInt("E2FFD", 16)));
    assertTrue(StringPrep.unassignedCodePoints(Integer.parseInt("EFFFD", 16)));
    assertFalse(StringPrep.unassignedCodePoints(Integer.parseInt("E0001", 16)));
  }
}
