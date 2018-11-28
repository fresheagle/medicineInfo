/**
 * 
 */
package com.med.info.launch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author jialin.jiang
 *
 */
@ComponentScan(basePackages = {"com.med.info"})
@MapperScan(value= {"com.med.info.mapper"})
@ServletComponentScan(value= {"com.med.info"})
@ImportResource(locations= {"classpath:userPrivilegeBean.xml"})
@SpringBootApplication
public class MedecineInfoLaunch {

	
	public static void main(String[] args) {
		SpringApplication.run(MedecineInfoLaunch.class, args);
	}
}
