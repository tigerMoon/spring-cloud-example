package org.tiger.test.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tiger on 16-11-30.
 */
@SpringBootApplication
@RestController
public class Application {

//    @Value("${info.description}")
    @Value("${config.name}")
    String name = "World";

    @RequestMapping(value = "/app",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<String> application() {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);

    }

    @RequestMapping(value = "/foo",method = RequestMethod.GET,produces = "application/json")
    public String foo() {
        return "Hello " + name;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
