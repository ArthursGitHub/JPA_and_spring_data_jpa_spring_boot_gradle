package org.learn.bookpub;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages="org.learn.bookpub")
@SpringBootApplication
public class BookPubApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(new Object[]{BookPubApplication.class, "META-INF\\spring\\application-context.xml"}, args);
	}
	
	
	
//	  @Bean
//	  public Filter etagFilter() {
//	    return new ShallowEtagHeaderFilter();
//	  }
}
