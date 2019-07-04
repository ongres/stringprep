package org.sasl.prep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.ongres.stringprep.saslprep.SaslPrep;
import java.io.IOException;
import org.junit.Test;

public class SaslPrepTest {
  @Test
  public void examplesRtf() throws IOException {
    SaslPrep saslPrep = new SaslPrep();
    String example1 = "I\u00ADX";
    assertEquals("IX", saslPrep.saslPrep(example1, false));
    String example2 = "user";
    assertEquals(example2, saslPrep.saslPrep(example2, false));
    String example3 = "USER";
    assertEquals(example3, saslPrep.saslPrep(example3, false));
    String example4 = "ª";
    assertEquals("a", saslPrep.saslPrep(example4, false));
    String example5 = "Ⅸ";
    assertEquals("IX", saslPrep.saslPrep(example5, false));
    String example6 = "\u0007";
    try {
      saslPrep.saslPrep(example6, false);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Prohibited character \u0007", e.getMessage());
    }
    String example7 = "ا1";
    try {
      saslPrep.saslPrep(example7, false);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("The string contains any RandALCat character but a RandALCat character "
              + "is not the first and the last characters", e.getMessage());
    }
    String supplementary = "𠀀";
    assertEquals(supplementary, saslPrep.saslPrep(supplementary, false));
  }
}
