/*
 * Copyright (c) 2021 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

open module test.stringprep {
    requires com.ongres.stringprep;

    requires transitive org.junit.jupiter.engine;
    requires transitive org.junit.jupiter.api;
    requires transitive org.junit.jupiter.params;
}