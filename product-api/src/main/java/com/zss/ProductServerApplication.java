package com.zss;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.zss.product.constants.ProductConstants;

/**
 * 用户服务启动类
 * @author zhushanshan
 * 2017年11月1日 下午5:51:41
 */
@ServletComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
//@ComponentScan(basePackages={"com.zss.product.repository"}) 因为repository里有加@Repository所以这个注解可以不用，反之亦然
public class ProductServerApplication {

    public static void main(String[] args) {
    	//String envPath = System.getenv(UserConstants.ENV_CONF_PATH.toUpperCase());
    	String envPath = "E:\\github-zss\\config\\product-server\\";
		if (StringUtils.isEmpty(envPath)) {
			throw new IllegalStateException(ProductConstants.ENV_CONF_PATH.toUpperCase() + " is blank");
		}
		if (!envPath.endsWith(File.separator))
			envPath = envPath + File.separator;
		String configPath = envPath + "config" + File.separator;
		String logPath = envPath + "log" + File.separator;
		System.setProperty("spring.config.location", configPath);
		System.setProperty("log.base", logPath);
		System.setProperty("log.path", configPath);
        SpringApplication.run(ProductServerApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
