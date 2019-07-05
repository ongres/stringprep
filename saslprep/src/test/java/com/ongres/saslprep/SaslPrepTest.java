/*
 * Copyright 2019, OnGres.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

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
