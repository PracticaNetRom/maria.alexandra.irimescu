package ro.netrom.summercamp.summercamp2017;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
@ComponentScan(basePackages = { "ro.netrom.summercamp.summercamp2017.config" })
public class SummerCamp2017Application {
	

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SummerCamp2017Application.class, args);
		
	}
}