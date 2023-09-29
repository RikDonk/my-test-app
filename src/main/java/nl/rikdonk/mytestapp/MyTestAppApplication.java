package nl.rikdonk.mytestapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class MyTestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTestAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return  runner -> {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			System.out.println("MyTestApp (re)started: " + myDateObj.format(myFormatObj));
		};
	}

}
