package ch.ribbon.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerApi {

    @Autowired
    @Qualifier("eurekaRestTemplate")
    RestTemplate restTemplate;

    @RequestMapping(value = "ribbon-hello",method = {RequestMethod.GET})
    public String helloConsumer(){
        String httpUrl="http://HELLO-SERVER/hello";
        return restTemplate.getForEntity(httpUrl,String.class).getBody();
    }
}
