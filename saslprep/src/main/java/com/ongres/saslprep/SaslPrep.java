package com.ongres.saslprep;

import com.ongres.stringprep.StringPrep;
import java.io.IOException;
import java.nio.CharBuffer;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class SaslPrep {
    
  private static final int MAX_UTF = 65535;

  /**
 * SaslPrep profile of StringPrep algorithm.
 */
  public static String saslPrep(String value, boolean storedString) throws IOException {
    List<Integer> valueBuilder = new ArrayList<>();
    //Mapping
    //non-ASCII space characters
    List<Integer> codePoints = new ArrayList<>();
    for (int i = 0; i < value.length(); i++) {
      int codePoint = value.codePointAt(i);
      codePoints.add(codePoint);
      if (codePoint > MAX_UTF) {
        i++;
      }
      if (!StringPrep.prohibitionNonAsciiSpace(codePoint)) {
        valueBuilder.add(codePoint);
      }
    }
    //commonly mapped to nothing
    StringBuilder stringBuilder = new StringBuilder();
    
    for (int codePoint : codePoints) {
      if (!StringPrep.mapToNothing(codePoint)) {
        char[] characters = Character.toChars(codePoint);
        stringBuilder.append(characters);
      }
    }
    
    //Normalization
    String normalized = Normalizer.normalize(
            CharBuffer.wrap(stringBuilder.toString().toCharArray()), Normalizer.Form.NFKC);
    
    valueBuilder = new ArrayList<>();
    for (int i = 0; i < normalized.length(); i++) {
      int codePoint = normalized.codePointAt(i);
      codePoints.add(codePoint);
      if (codePoint > MAX_UTF) {
        i++;
      }
      if (!StringPrep.prohibitionNonAsciiSpace(codePoint)) {
        valueBuilder.add(codePoint);
      }
    }
    
    //Prohibited
    //Non-ASCII space characters
    //ASCII control characters
    //Non-ASCII control characters
    //Private Use characters
    //Non-character code points
    //Surrogate code points
    //Inappropriate for plain text characters
    //Inappropriate for canonical representation characters
    //Change display properties or deprecated characters
    //Tagging characters [StringPrep, C.9]
    for (int character : valueBuilder) {
      if (StringPrep.prohibitionNonAsciiSpace(character) 
              || StringPrep.prohibitionAsciiControl(character) 
              || StringPrep.prohibitionNonAsciiControl(character) 
              || StringPrep.prohibitionPrivateUse(character)
              || StringPrep.prohibitionNonCharacterCodePoints(character) 
              || StringPrep.prohibitionSurrogateCodes(character)
              || StringPrep.prohibitionInappropriatePlainText(character) 
              || StringPrep.prohibitionInappropriateCanonicalRepresentation(character)
              || StringPrep.prohibitionChangeDisplayProperties(character) 
              || StringPrep.prohibitionTaggingCharacters(character)) {
        throw new IllegalArgumentException("Prohibited character " 
              + String.valueOf(Character.toChars(character)));
      }
      //Unassigned Code Points
      if (storedString && StringPrep.unassignedCodePoints(character)) {
        throw new IllegalArgumentException("Prohibited character " 
      + String.valueOf(Character.toChars(character)));
      }
    }
    //Bidirectional
    StringPrep.bidirectional(valueBuilder);
    
    return normalized;
  }
}
