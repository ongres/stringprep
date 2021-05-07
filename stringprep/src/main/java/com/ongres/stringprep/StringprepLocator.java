/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.util.Optional;
import java.util.ServiceLoader;

final class StringprepLocator {

  private StringprepLocator() {
    throw new IllegalStateException("Utility class");
  }

  static Optional<Profile> getProfile(String profileName) {
    for (Profile profile : ServiceLoader.load(Profile.class)) {
      final ProfileName annotation = profile.getClass().getDeclaredAnnotation(ProfileName.class);
      if (annotation != null && annotation.value().equals(profileName)) {
        return Optional.of(profile);
      }
    }
    return Optional.empty();
  }

}
