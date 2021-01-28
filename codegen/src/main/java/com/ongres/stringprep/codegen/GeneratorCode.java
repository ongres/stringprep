/*
 * Copyright (C) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep.codegen;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ongres.stringprep.codegen.parsers.Parser;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 * Stringprep tables class generator.
 */
public final class GeneratorCode {

  private GeneratorCode() {
    // ignore
  }

  /**
   * Generate StringPrep class dynamically.
   *
   * @param args with the path used to generate StringPrep class
   * @throws IOException if a RFC file can't be read
   */
  public static void main(String[] args) throws IOException {
    VelocityEngine velocityEngine = new VelocityEngine();
    velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS,
        RuntimeConstants.RESOURCE_LOADER_CLASS);
    velocityEngine.setProperty("resource.loader.class.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init();

    Template template = velocityEngine.getTemplate("templates/StringPrepTables.vm");
    VelocityContext ctx = new VelocityContext();
    ctx.put("parser", new Parser());

    Path path = Paths.get(args[0], "/com/ongres/stringprep/Tables.java");
    Files.deleteIfExists(path);
    try (Writer writer = new OutputStreamWriter(
        Files.newOutputStream(path), StandardCharsets.UTF_8)) {
      template.merge(ctx, writer);
    }
  }

}
