package com.ongres.saslprep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.ongres.saslprep.SaslPrep;
import java.io.IOException;
import org.junit.Test;

public class SaslPrepTest {
  @Test
  public void examplesRtf() throws IOException {
    String example1 = "I\u00ADX";
    assertEquals("IX", SaslPrep.saslPrep(example1, true));
    String example2 = "user";
    assertEquals(example2, SaslPrep.saslPrep(example2, true));
    String example3 = "USER";
    assertEquals(example3, SaslPrep.saslPrep(example3, true));
    String example4 = "ª";
    assertEquals("a", SaslPrep.saslPrep(example4, true));
    String example5 = "Ⅸ";
    assertEquals("IX", SaslPrep.saslPrep(example5, true));
    String example6 = "\u0007";
    try {
      SaslPrep.saslPrep(example6, true);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Prohibited character \u0007", e.getMessage());
    }
    String example7 = "ا1";
    try {
      SaslPrep.saslPrep(example7, true);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("The string contains any RandALCat character but a RandALCat character "
              + "is not the first and the last characters", e.getMessage());
    }
    String supplementary = "𠀀";
    assertEquals(supplementary, SaslPrep.saslPrep(supplementary, true));
  }
}
