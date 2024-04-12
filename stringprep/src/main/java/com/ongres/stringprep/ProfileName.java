/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The value of this annotation is used by the ServiceLoader lookup.
 *
 * <p>A profile with {@code @ProfileName("SASLprep")} can can be obtained by calling
 * {@code Stringprep.getProvider("SASLprep")}.
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ProfileName {

  /**
   * Define the Stringprep profile name as defined by the RFC.
   *
   * @return profile name
   */
  String value();
}
