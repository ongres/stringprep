/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.stringprep.profile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ongres.stringprep.Profile;
import com.ongres.stringprep.Stringprep;
import org.junit.jupiter.api.Test;

class DemoProfileTest {

  @Test
  void prohibited() {
    Profile profile = new CaseFoldNoAnnotation();
    assertThrows(IllegalArgumentException.class, () -> profile.prepareStored("@"));
  }

  @Test
  void lowercaseNoAnnotation() {
    Profile profile = new CaseFoldNoAnnotation();
    char[] prepareStored = profile.prepareStored("Admin-EXAMPLE.com:9999".toCharArray());
    for (char i : prepareStored) {
      assertFalse(Character.isUpperCase(i));
    }
  }

  @Test
  void lowercaseAnnotation() {
    Profile profile = new CaseFoldAnnotation();
    char[] prepareStored = profile.prepareStored("Admin-EXAMPLE.com:9999".toCharArray());
    for (char i : prepareStored) {
      assertFalse(Character.isUpperCase(i));
    }
  }

  @Test
  void getProfileNoAnnotation() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> Stringprep.getProvider("CaseFoldNoAnnotation"));
    assertEquals("No provider found for: CaseFoldNoAnnotation", ex.getMessage());
  }

  @Test
  void getProfileAnnotation() {
    Profile profile = assertDoesNotThrow(() -> Stringprep.getProvider("CaseFoldAnnotation"));
    assertNotNull(profile);
  }
}
