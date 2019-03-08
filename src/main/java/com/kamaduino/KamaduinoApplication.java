package com.kamaduino;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kamaduino.listener.ArduinoReadDataListener;
import com.panamahitek.PanamaHitek_Arduino;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KamaduinoApplication {

	@Value("${arduino.port}")
	private String arduinoPort;

	@Value("${arduino.dataRate}")
	private int dataRate;

	@Value("${arduino.data.path}")
	private String arduinoDataFilePath;

	@Value("${flag.arduino.thread}")
	private boolean flagThread;

	public static void main(String[] args) {
		SpringApplication.run(KamaduinoApplication.class, args);
	}

	@Bean
	public TaskExecutor taskExecutor() {
		if(flagThread) {
			return new SimpleAsyncTaskExecutor();
		}
		return null;
	}

	@Bean
	public CommandLineRunner schedulingRunner(TaskExecutor executor) {
		if(flagThread) {
			return new CommandLineRunner() {
				public void run(String... args) throws Exception {
					PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
					executor.execute(new ArduinoReadDataListener(arduino, arduinoPort, dataRate, arduinoDataFilePath));
				}
			};
		}
		return null;
	}

	@Bean
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
		System.out.println("Config is starting.");
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return objectMapper;
	}

//	@PostConstruct
//	public void newUser(){
//		userService.newUser();
//	}
}