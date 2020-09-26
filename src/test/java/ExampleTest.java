import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ExampleTest {
//    Writer writer;
//    MustacheFactory mf;
//    Mustache mustache;
//
//    @Before
//    public void setup() {
//          writer = new OutputStreamWriter(System.out);
//          mf = new DefaultMustacheFactory();
//          mustache = mf.compile("msg.mustache");
//    }

    @Test
    public void mustacheTest() throws IOException {
        //read excel
        ImportParams params = new ImportParams();
        params.setHeadRows(1);

        URL resource = ExampleIf04.class.getResource("/deregister.xlsx");
        String file = resource.getFile();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File(file), Message.class, params);

        //put the excel data in map
        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages", messages);

        //use mustache to generate code
        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("msg.mustache");
        mustache.execute(writer, scopes);
        writer.flush();

    }

    @Test
    public void error_unit_up001() throws IOException {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        long start = System.currentTimeMillis();
        URL resource = ExampleIf03.class.getResource("/up001.xlsx");
        String file = resource.getFile();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File(file), Message.class, params);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(messages.size());
        System.out.println(ReflectionToStringBuilder.toString(messages.get(0)));


        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages", messages);

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("error_unit.mustache");
        mustache.execute(writer, scopes);
        writer.flush();


    }



    @Test
    public void error_unit_up002() throws IOException {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        long start = System.currentTimeMillis();
        URL resource = ExampleIf03.class.getResource("/vinfo.xlsx");
        String file = resource.getFile();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File(file), Message.class, params);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(messages.size());
        System.out.println(ReflectionToStringBuilder.toString(messages.get(0)));


        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages", messages);

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("error_unit.mustache");
        mustache.execute(writer, scopes);
        writer.flush();


    }


    @Test
    public void error_unit_up003() throws IOException {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        long start = System.currentTimeMillis();
        URL resource = ExampleIf03.class.getResource("/register_status.xlsx");
        String file = resource.getFile();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File(file), Message.class, params);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(messages.size());
        System.out.println(ReflectionToStringBuilder.toString(messages.get(0)));


        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages", messages);

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("error_unit.mustache");
        mustache.execute(writer, scopes);
        writer.flush();


    }



    @Test
    public void error_unit_up005() throws IOException {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        long start = System.currentTimeMillis();
        URL resource = ExampleIf03.class.getResource("/delete.xlsx");
        String file = resource.getFile();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File(file), Message.class, params);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(messages.size());
        System.out.println(ReflectionToStringBuilder.toString(messages.get(0)));


        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages", messages);

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("error_unit.mustache");
        mustache.execute(writer, scopes);
        writer.flush();


    }
}
