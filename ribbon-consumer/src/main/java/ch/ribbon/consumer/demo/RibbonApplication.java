package ch.ribbon.consumer.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {

    @Bean
    @Qualifier("eurekaRestTemplate")
    RestTemplate eurekaRestTemplate(LoadBalancerInterceptor loadBalancerInterceptor){
        RestTemplate eurekaRestTemplate = new RestTemplate();
        eurekaRestTemplate.setInterceptors(Arrays.asList(loadBalancerInterceptor));

        return eurekaRestTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }
}
