package br.molinaro.hitss.mobileclaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MobileclaroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileclaroApplication.class, args);
	}

}
