package org.sasl.prep;

import java.io.IOException;
import java.nio.CharBuffer;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import com.ongres.string_prep.core.StringPrep;

public class SaslPrep {
    
    private static final int MAX_UTF = 65535;

    public String saslPrep(String value, boolean storedString) throws IOException {
        StringPrep stringPrep = new StringPrep();
        List<Integer> valueBuilder = new ArrayList<>();
        //Mapping
        //non-ASCII space characters
        List<Integer> codePoints = new ArrayList<>();
        for (int i=0; i<value.length(); i++) {
            int codePoint = value.codePointAt(i);
            codePoints.add(codePoint);
            if (codePoint > MAX_UTF) {
                i++;
            }
            if (!stringPrep.prohibitionNonAsciiSpace(codePoint)) {
                valueBuilder.add(codePoint);
            }
        }
        //commonly mapped to nothing
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> mapped = stringPrep.mapToNothing(codePoints);
        for (int i=0; i<mapped.size(); i++) {
            char[] characters = Character.toChars(mapped.get(i));
            stringBuilder.append(characters);
        }
        
        //Normalization
        String normalized = Normalizer.normalize(CharBuffer.wrap(stringBuilder.toString().toCharArray()), Normalizer.Form.NFKC);
        
        valueBuilder = new ArrayList<>();
        for (int i=0; i<normalized.length(); i++) {
            int codePoint = normalized.codePointAt(i);
            codePoints.add(codePoint);
            if (codePoint > MAX_UTF) {
                i++;
            }
            if (!stringPrep.prohibitionNonAsciiSpace(codePoint)) {
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
            if (stringPrep.prohibitionNonAsciiSpace(character) || stringPrep.prohibitionAsciiControl(character) 
                    || stringPrep.prohibitionNonAsciiControl(character) || stringPrep.prohibitionPrivateUse(character)
                    || stringPrep.prohibitionNonCharacterCodePoints(character) || stringPrep.prohibitionSurrogateCodes(character)
                    || stringPrep.prohibitionInappropriatePlainText(character) 
                    || stringPrep.prohibitionInappropriateCanonicalRepresentation(character)
                    || stringPrep.prohibitionChangeDisplayProperties(character) ||    stringPrep.prohibitionTaggingCharacters(character)) {
                throw new IllegalArgumentException("Prohibited character " + String.valueOf(Character.toChars(character)));
                }
            //Unassigned Code Points
            if(storedString && stringPrep.unassignedCodePoints(character)) {
                throw new IllegalArgumentException("Prohibited character " + String.valueOf(Character.toChars(character)));
                }
        }
        //Bidirectional
        stringPrep.bidirectional(valueBuilder);
        
        return normalized;
        }
    }
