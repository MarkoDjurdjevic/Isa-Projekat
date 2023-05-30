package isa.projekat.projektniZadatak;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjektniZadatakApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektniZadatakApplication.class, args);
	}
}
