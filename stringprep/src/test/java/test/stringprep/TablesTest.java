/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.stringprep;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import com.ongres.stringprep.Tables;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TablesTest {

  @Test
  void testBidirectionalTables() {
    // Property R or AL
    assertTrue(Tables.bidirectionalPropertyRorAL(0x061B));
    assertTrue(Tables.bidirectionalPropertyRorAL(0xFE76));
    assertTrue(Tables.bidirectionalPropertyRorAL(0xFEFC));
    assertTrue(Tables.bidirectionalPropertyRorAL(0xFE71));
    assertFalse(Tables.bidirectionalPropertyRorAL(0x066C));
    assertFalse(Tables.bidirectionalPropertyRorAL(0x06D6));
    assertFalse(Tables.bidirectionalPropertyRorAL(0x0041));

    // Property L
    assertTrue(Tables.bidirectionalPropertyL(0x1D4A2));
    assertTrue(Tables.bidirectionalPropertyL(0x20000));
    assertTrue(Tables.bidirectionalPropertyL(0x2A6D6));
    assertTrue(Tables.bidirectionalPropertyL(0x10FFFC));
    assertFalse(Tables.bidirectionalPropertyL(0x0040));
    assertFalse(Tables.bidirectionalPropertyL(0x005B));
    assertFalse(Tables.bidirectionalPropertyL(0x037B));
  }

  @Test
  void testMappingTables() {
    // Map to nothing
    assertTrue(Tables.mapToNothing(0x00AD));
    assertFalse(Tables.mapToNothing(0x0100));
    assertTrue(Tables.mapToNothing(0xFE0F));
  }

  @Test
  void testAsciiSpace() {
    // AsciiSpace
    assertFalse(Tables.prohibitionAsciiSpace(0x00A0));
    assertTrue(Tables.prohibitionAsciiSpace(0x0020));
  }

  @Test
  void testNonAsciiSpace() {
    // NonAsciiSpace
    assertTrue(Tables.prohibitionNonAsciiSpace(0x00A0));
    assertFalse(Tables.prohibitionNonAsciiSpace(0x0020));
  }

  @ParameterizedTest
  @ValueSource(ints = {0x00A0, 0x1680, 0x2000, 0x2001, 0x2002, 0x2003, 0x2004, 0x2005, 0x2006,
      0x2007, 0x2008, 0x2009, 0x200A, 0x200B, 0x202F, 0x205F, 0x3000})
  void testNonAsciiSpace(int cp) {
    assertTrue(Tables.prohibitionNonAsciiSpace(cp));
  }

  @Test
  void testAsciiControl() {
    // AsciiControl
    assertTrue(Tables.prohibitionAsciiControl(0x0000));
    assertTrue(Tables.prohibitionAsciiControl(0x0001));
    assertTrue(Tables.prohibitionAsciiControl(0x001F));
    assertTrue(Tables.prohibitionAsciiControl(0x007F));
    assertFalse(Tables.prohibitionAsciiControl(0x0020));
  }

  @Test
  void testNonAsciiControl() {
    // NonAsciiControl
    assertTrue(Tables.prohibitionNonAsciiControl(0x1D173));
    assertTrue(Tables.prohibitionNonAsciiControl(0x1D17A));
    assertTrue(Tables.prohibitionNonAsciiControl(0x1D175));
    assertTrue(Tables.prohibitionNonAsciiControl(0x2028));
    assertFalse(Tables.prohibitionNonAsciiControl(0x0000));
  }

  @Test
  void testNonCharacterCodePoints() {
    // NonCharacterCodePoints
    assertTrue(Tables.prohibitionNonCharacterCodePoints(0x10FFFE));
    assertTrue(Tables.prohibitionNonCharacterCodePoints(0x10FFFF));
    assertTrue(Tables.prohibitionNonCharacterCodePoints(0xFDEE));
    assertFalse(Tables.prohibitionNonCharacterCodePoints(0x10FFFD));
  }

  @Test
  void testSurrogateCodes() {
    // SurrogateCodes
    assertTrue(Tables.prohibitionSurrogateCodes(0xD800));
    assertTrue(Tables.prohibitionSurrogateCodes(0xD805));
    assertTrue(Tables.prohibitionSurrogateCodes(0xDFFF));
    assertFalse(Tables.prohibitionSurrogateCodes(0x10FFFD));
  }

  @Test
  void testInappropiatePlainText() {
    // InappropiatePlainText
    assertTrue(Tables.prohibitionInappropriatePlainText(0xFFF9));
    assertFalse(Tables.prohibitionInappropriatePlainText(0x100000));
  }

  @Test
  void testInappropriateCanonicalRepresentation() {
    // InappropriateCanonicalRepresentation
    assertTrue(Tables.prohibitionInappropriateCanonicalRepresentation(
        0x2FF0));
    assertTrue(Tables.prohibitionInappropriateCanonicalRepresentation(
        0x2FFB));
    assertTrue(Tables.prohibitionInappropriateCanonicalRepresentation(
        0x2FF3));
    assertFalse(Tables.prohibitionInappropriateCanonicalRepresentation(
        0x100000));
  }

  @Test
  void testChangeDisplayProperties() {
    // ChangeDisplayProperties
    assertTrue(Tables.prohibitionChangeDisplayProperties(0x200E));
    assertFalse(Tables.prohibitionChangeDisplayProperties(0x2FF0));
  }

  @Test
  void testTaggingCharacters() {
    // TaggingCharacters
    assertTrue(Tables.prohibitionTaggingCharacters(0xE0001));
    assertTrue(Tables.prohibitionTaggingCharacters(0xE0020));
    assertTrue(Tables.prohibitionTaggingCharacters(0xE002F));
    assertTrue(Tables.prohibitionTaggingCharacters(0xE007F));
    assertFalse(Tables.prohibitionTaggingCharacters(0xD800));
  }

  @Test
  void testProhibitionSurrogate() {
    IntStream surrogate = IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
        .filter(u -> Character.getType(u) == Character.SURROGATE);

    for (int cp : surrogate.toArray()) {
      assertTrue(Tables.prohibitionSurrogateCodes(cp),
          () -> "Character: " + String.valueOf(Character.toChars(cp)) + ", CodePoint: " + cp);
    }
  }

  @Test
  void testProhibitionPrivateUse() {
    IntStream privateUse = IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
        .filter(u -> Character.getType(u) == Character.PRIVATE_USE);

    for (int cp : privateUse.toArray()) {
      assertTrue(Tables.prohibitionPrivateUse(cp),
          () -> "Character: " + String.valueOf(Character.toChars(cp)) + ", CodePoint: " + cp);
    }
  }

}
