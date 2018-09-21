package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.OrderedHealthAggregator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaHealthCheckHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class BookApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/book", method = RequestMethod.GET, produces = "application/json")
    public String book() {
        return "Hello book";
    }

    @RequestMapping(value = "/book/people", method = RequestMethod.GET, produces = "application/json")
    public String foo(@RequestParam String p) {
        return "Hello foo" + p;
    }

    @Bean
    public EurekaHealthCheckHandler getHandler(){
        return new EurekaHealthCheckHandler(new OrderedHealthAggregator());
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
