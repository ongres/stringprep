/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

module com.ongres.saslprep {
  exports com.ongres.saslprep;
  requires transitive com.ongres.stringprep;
  provides com.ongres.stringprep.Profile with com.ongres.saslprep.SASLprep;
}
