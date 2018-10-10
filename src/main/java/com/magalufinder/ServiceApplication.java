

package com.magalufinder;


import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class ServiceApplication extends SpringBootServletInitializer {

	private static Class<ServiceApplication> applicationClass =
			ServiceApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		return application.sources(applicationClass);
	}

}
