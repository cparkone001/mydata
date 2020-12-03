package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import com.example.demo.config.FileUploadProperties;


//@SpringBootApplication
//public class SpringBootDemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootDemoApplication.class, args);
//	}
//
//}

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
//@EnableConfigurationProperties({
//    FileUploadProperties.class
//})
public class SpringBootDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemoApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}

