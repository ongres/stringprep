/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package test.stringprep;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ongres.stringprep.Stringprep;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullSource;

class StringprepTest {

  @ParameterizedTest
  @NullSource
  void nullProvider(String provider) {
    assertThrows(NullPointerException.class, () -> Stringprep.getProvider(provider));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "SASLprep", "Nameprep", "Resourceprep"})
  void providerNotFound(String provider) {
    assertThrows(IllegalArgumentException.class, () -> Stringprep.getProvider(provider));
  }

}
