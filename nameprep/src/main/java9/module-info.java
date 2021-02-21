/*
 * Copyright (C) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

module com.ongres.nameprep {
  exports com.ongres.nameprep;
  requires transitive com.ongres.stringprep;
  provides com.ongres.stringprep.Profile with com.ongres.nameprep.Nameprep;
}
