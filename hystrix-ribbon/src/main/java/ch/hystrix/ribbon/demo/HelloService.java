package ch.hystrix.ribbon.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKey")
    public String helloConsumer(){
        long startTime = System.currentTimeMillis();
        String httpUrl="http://HELLO-SERVER/hello";
        String result = restTemplate.getForEntity(httpUrl,String.class).getBody();
        long endTime = System.currentTimeMillis();
        log.info("spend time:"+(startTime-endTime));
        return result;
    }

    public String helloFallback(){
        return "hello error";
    }

    public String helloKey(){
        return "hello key";
    }
}
