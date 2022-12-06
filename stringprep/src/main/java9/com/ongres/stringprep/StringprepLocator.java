/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import java.util.ServiceLoader;

final class StringprepLocator {

  private StringprepLocator() {
    throw new IllegalStateException("Utility class");
  }

  static Profile getProfile(String profileName) {
    return ServiceLoader.load(Profile.class).stream()
        .filter(profile -> filterProfile(profileName, profile))
        .findFirst()
        .map(ServiceLoader.Provider::get)
        .orElse(null);
  }

  private static boolean filterProfile(String profileName,
      ServiceLoader.Provider<Profile> profile) {
    ProfileName annotation = profile.type().getDeclaredAnnotation(ProfileName.class);
    return annotation != null && annotation.value().equals(profileName);
  }

}
