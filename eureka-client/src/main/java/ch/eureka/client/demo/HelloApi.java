package ch.eureka.client.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class HelloApi {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="hello",method = {RequestMethod.GET})
    public String index() throws InterruptedException {
        int sleepTime = RandomUtils.nextInt(3000);
        log.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);
        discoveryClient.getServices().forEach(serviceId->{
            System.out.println("serviceId:" + serviceId);
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            instances.forEach(instance->{
                System.out.println(instance.getUri());
            });
        });
        log.info("请求到达hello-index");
        return "Hello World";
    }

    @PostMapping("postHello")
    public String postIndex(String name){
        return name+";hehe";
    }

    @PostMapping("postHello1")
    public String postIndex1(@Valid TestModel testModel){
        return "hehe";
    }
}


