import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class VelocityTest {


    @Test
    public void velocityTemplateTest()     {

        VelocityEngine velocityEngine = new VelocityEngine();

        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template t = velocityEngine.getTemplate("index.vm");

        VelocityContext context = new VelocityContext();
        context.put("name", "World");

        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        System.out.println(writer.getBuffer().toString());

        writer.flush();

    }
}