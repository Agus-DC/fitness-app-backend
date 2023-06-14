package com.fitnessapp;

import java.io.IOException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FitnessApplication {
	//TODO: Poner en clase configuracion
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		try {
			// Execute the command or process
			Process process = Runtime.getRuntime().exec("your-command");

			// Wait for the process to finish
			int exitCode = process.waitFor();

			// Log the exit status
			System.out.println("Exit status: " + exitCode);
		} catch (IOException | InterruptedException e) {
			// Handle any exceptions
			e.printStackTrace();
		}
		SpringApplication.run(FitnessApplication.class, args);
	}

}
