package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookApplication {

    @RequestMapping(value = "/book", method = RequestMethod.GET, produces = "application/json")
    public String book() {
        return "Hello book";
    }

    @RequestMapping(value = "/foo", method = RequestMethod.GET, produces = "application/json")
    public String foo(@RequestParam String p) {
        return "Hello foo" + p;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
