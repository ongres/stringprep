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
 */
  public static void main(String[] args) throws IOException {

    VelocityEngine velocityEngine = new VelocityEngine();
        
    velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
    velocityEngine.setProperty("class.resource.loader.class", 
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
        
    velocityEngine.init();
    Template template = velocityEngine.getTemplate("templates/ParserUtil.vm");
    VelocityContext ctx = new VelocityContext();
    Parser parser = new Parser();
    ctx.put("parser", parser);
    String path = "../core/src/main/java/com/ongres/stringprep/core/StringPrep.java";
    //Writer writer = new FileWriter(new File(args[0]));
    Writer writer = new FileWriter(new File(path));
    template.merge(ctx, writer);
    writer.close();
  }
}
