package ch.feign.consumer.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="HELLO-SERVER")
public interface HelloClient {
    @GetMapping("/hello")
    String hello();
}
