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
