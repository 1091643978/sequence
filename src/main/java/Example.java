import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


public class Example {
    List<Item> items() {
        return Arrays.asList(
                new Item("Item 1", "$19.99", Arrays.asList(new Feature("New!"), new Feature("Awesome!"))),
                new Item("Item 2", "$29.99", Arrays.asList(new Feature("Old."), new Feature("Ugly.")))
        );
    }

    static class Item {
        Item(String name, String price, List<Feature> features) {
            this.name = name;
            this.price = price;
            this.features = features;
        }

        String name, price;
        List<Feature> features;
    }

    static class Feature {
        Feature(String description) {
            this.description = description;
        }

        String description;
    }

    public static void main(String[] args) throws IOException {
        ImportParams params = new ImportParams();
//        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<Message> messages = ExcelImportUtil.importExcel(
                new File( Example.class.getResource("/msg.xlsx").getFile() ),  Message.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(messages.size());
        System.out.println(ReflectionToStringBuilder.toString(messages.get(0)));

//        MustacheFactory mf = new DefaultMustacheFactory();
//        Mustache mustache = mf.compile("template.mustache");
//        mustache.execute(new PrintWriter(System.out), new Example()).flush();
//        Writer writer = new OutputStreamWriter(System.out);
//        MustacheFactory mf = new DefaultMustacheFactory();
//        Mustache mustache = mf.compile("msg.mustache");
//        mustache.execute(writer,messages).flush(); ;


        HashMap<String, List<Message>> scopes = new HashMap<String, List<Message>>();
        scopes.put("messages",messages);

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("msg.mustache");
        mustache.execute(writer, scopes);
        writer.flush();


    }
}
