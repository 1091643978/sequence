import com.abc.template.pojo.Car;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {

    @Test
    public void freemarkderTest() throws IOException {
        Configuration cfg = new Configuration(new Version("2.3.30"));
        cfg.setClassForTemplateLoading(FreemarkerTest.class, "/freemarker");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("test.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("msg", "Today is a beautiful day");

        try (StringWriter out = new StringWriter()) {

            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());

            out.flush();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void carTest() throws IOException, TemplateException {

        Configuration cfg = new Configuration(new Version("2.3.30"));

        cfg.setClassForTemplateLoading(FreemarkerTest.class, "/freemarker/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("car.ftl");

        Map<String, Object> templateData = new HashMap<>();

        Car c1 = new Car("Audi", 52642);
        Car c2 = new Car("Volvo", 29000);
        Car c3 = new Car("Skoda", 9000);

        List<Car> cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        templateData.put("cars", cars);

        StringWriter out = new StringWriter();

        template.process(templateData, out);
        System.out.println(out.getBuffer().toString());

        out.flush();

    }
}
