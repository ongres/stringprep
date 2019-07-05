/*
 * Copyright 2019, OnGres.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.ongres.stringprep.codegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

@SupportedAnnotationTypes("org.code.generator.Generator")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class GeneratorCode {

  /**
 * Generate StringPrep class dynamically.
 * @param args with the path used to generate StringPrep class
 * @throws IOException if a RFC file can't be read
 */
  public static void main(String[] args) throws IOException {

    VelocityEngine velocityEngine = new VelocityEngine();
        
    velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
    velocityEngine.setProperty("class.resource.loader.class", 
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
        
    velocityEngine.init();
    Template template = velocityEngine.getTemplate("templates/StringPrep.vm");
    VelocityContext ctx = new VelocityContext();
    Parser parser = new Parser();
    ctx.put("parser", parser);
    String path = args[0] + "/com/ongres/stringprep/StringPrep.java";
    File file = new File(path);
    file.getParentFile().mkdirs();
    Writer writer = new FileWriter(file);
    template.merge(ctx, writer);
    writer.close();
  }
}
