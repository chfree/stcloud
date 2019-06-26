package ch.feign.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {
    @Autowired
    HelloClient helloClient;

    @GetMapping("hello")
    public String hello(){
        return helloClient.hello();
    }
}
