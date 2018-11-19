package medicineInfo_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.jiang.learn.springboot.start.config.SpringConfigure;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.jiang.learn.springboot.neo4j.service")
@Import(SpringConfigure.class)
public class SpringBootStartServiceApp {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartServiceApp.class, args);
	}
}
