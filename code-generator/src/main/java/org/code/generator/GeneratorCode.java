package org.code.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
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

    public void generateCode() {
        VelocityEngine velocityEngine = new VelocityEngine();
        //velocityEngine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "../../../src/main/resources/");
        velocityEngine.init();
        Template t = velocityEngine.getTemplate("templates/ParserUtil.vm");
        VelocityContext ctx = new VelocityContext();
        Writer writer = new StringWriter();
        t.merge(ctx, writer);
    }

    public static void main( String[] args ) throws IOException {

        StringPrep stringPrep = new StringPrep();
        VelocityEngine velocityEngine = new VelocityEngine();
        
        velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
        
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("templates/ParserUtil.vm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("stringPrep", stringPrep);
        try {
            Writer writer = new FileWriter(new File(args[0]));
            //Writer writer = new StringWriter();
            template.merge(ctx, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
