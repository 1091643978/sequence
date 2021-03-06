import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class ExampleIf202 {


    public static void main(String[] args) throws IOException {
        ImportParams params = new ImportParams();
//        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        URL resource = ExampleIf202.class.getResource("/vinfo.xlsx");
        String file = resource.getFile();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File(file),  Message.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(messages.size());
        System.out.println(ReflectionToStringBuilder.toString(messages.get(0)));



        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages",messages);

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("msg.mustache");
        mustache.execute(writer, scopes);
        writer.flush();


    }
}
