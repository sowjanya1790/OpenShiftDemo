package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SampleApplication {
	org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    private static final String template = "Sample, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sample-world",method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	logger.info("This is info log");
    	logger.debug("This is debug log");
    	logger.debug("This is trace log");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
