package ch.eureka.client.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloApi {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="hello",method = {RequestMethod.GET})
    public String index(){
        log.info("请求到达hello-index");
        return "Hello World";
    }
}
