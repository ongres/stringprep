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
    for (Profile profile : ServiceLoader.load(Profile.class)) {
      ProfileName annotation = profile.getClass().getDeclaredAnnotation(ProfileName.class);
      if (annotation != null && annotation.value().equals(profileName) ||
          profile.getClass().getSimpleName().equals(profileName)) {
        return profile;
      }
    }
    return null;
  }

}
