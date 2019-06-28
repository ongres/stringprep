package org.sasl.prep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

public class SaslPrepTest {
    @Test
    public void examplesRTF() throws IOException {
        SaslPrep saslPrep = new SaslPrep();
        String example1 = "I\u00ADX";
        assertEquals("IX", saslPrep.saslPrep(example1, false));
        String example2 = "user";
        assertEquals(example2, saslPrep.saslPrep(example2, false));
        String example3 = "USER";
        assertEquals(example3, saslPrep.saslPrep(example3, false));
        String example4 = "\u00AA";
        assertEquals("a", saslPrep.saslPrep(example4, false));
        String example5 = "\u2168";
        assertEquals("IX", saslPrep.saslPrep(example5, false));
        String example6 = "\u0007";
        try {
            saslPrep.saslPrep(example6, false);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Prohibited character \u0007", e.getMessage());
        }
        String example7 = "\u0627\u0031";
        try {
            saslPrep.saslPrep(example7, false);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("The string contains any RandALCat character but a RandALCat character is not the first and the last characters", e.getMessage());
        }
        String supplementary = "\uD840\uDC00";
        assertEquals(supplementary, saslPrep.saslPrep(supplementary, false));
    }
}
