package com.kamaduino;

import com.kamaduino.dto.UserDTO;
import com.kamaduino.entity.User;
import com.kamaduino.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
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
