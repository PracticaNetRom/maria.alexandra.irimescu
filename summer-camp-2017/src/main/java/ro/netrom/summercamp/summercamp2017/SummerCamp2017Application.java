package ro.netrom.summercamp.summercamp2017;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ro.netrom.summercamp.summercamp2017.config"})
public class SummerCamp2017Application {

	public static void main(String[] args) {
		SpringApplication.run(SummerCamp2017Application.class, args);
	}
}
