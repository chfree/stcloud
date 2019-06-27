package ch.hystrix.ribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerApi {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "hystrix-hello",method = {RequestMethod.GET})
    public String helloConsumer(){
        return helloService.helloConsumer();
    }
}
