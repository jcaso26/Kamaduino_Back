package com.kamaduino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KamaduinoApplication {
//	@Autowired
//	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(KamaduinoApplication.class, args);
	}

//	@PostConstruct
//	public void newUser(){
//		userService.newUser();
//	}
}



//@SpringBootApplication
//public class WebApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(WebApplication.class);
//	}
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(WebApplication.class, args);
//	}
//}
