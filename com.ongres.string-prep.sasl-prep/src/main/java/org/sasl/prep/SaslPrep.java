package org.sasl.prep;

import java.io.IOException;
import java.nio.CharBuffer;
import java.text.Normalizer;

import com.ongres.string_prep.core.StringPrep;

public class SaslPrep {
	
	public String saslPrep(String value, boolean storedString) throws IOException {
		StringPrep stringPrep = new StringPrep();
		StringBuilder valueBuilder = new StringBuilder();
		//Mapping
		//non-ASCII space characters
		for (int i=0; i<value.length(); i++) {
			char[] characters = value.toCharArray();
			if (!stringPrep.prohibitionNonAsciiSpace(characters[i])) {
				valueBuilder.append(characters[i]);
			}
		}
		//commonly mapped to nothing
		String mapped = stringPrep.mapToNothing(valueBuilder.toString());
		
		//Normalization
		String normalized = Normalizer.normalize(CharBuffer.wrap(mapped.toCharArray()), Normalizer.Form.NFKC);
		
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
		char[] characters = normalized.toCharArray();
		for (char character : characters) {
			if (stringPrep.prohibitionNonAsciiSpace(character) || stringPrep.prohibitionAsciiControl(character) 
					|| stringPrep.prohibitionNonAsciiControl(character) || stringPrep.prohibitionPrivateUse(character)
					|| stringPrep.prohibitionNonCharacterCodePoints(character) || stringPrep.prohibitionSurrogateCodes(character)
					|| stringPrep.prohibitionInappropriatePlainText(character) 
					|| stringPrep.prohibitionInappropriateCanonicalRepresentation(character)
					|| stringPrep.prohibitionChangeDisplayProperties(character) ||	stringPrep.prohibitionTaggingCharacters(character)) {
                throw new IllegalArgumentException("Prohibited character "+character);
                }
			//Unassigned Code Points
			if(storedString && stringPrep.unassignedCodePoints(character)) {
				throw new IllegalArgumentException("Prohibited character "+character);
				}
		}
		//Bidirectional
		stringPrep.bidirectional(false, normalized);
		
		return normalized;
		}
	}
