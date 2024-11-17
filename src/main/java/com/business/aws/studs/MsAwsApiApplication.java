package com.business.aws.studs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class MsAwsApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new SpringApplicationBuilder(MsAwsApiApplication.class).run();
		Environment env = app.getEnvironment();
		String profileActive = env.getProperty("spring.profiles.active");
		String contextStr = env.getProperty("server.servlet.context-path");
		String applicationName = env.getProperty("spring.application.name");
		String applicationPort = env.getProperty("server.port");
		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running!\n\t"
						+ "Access URL: http://localhost:{}{}/swagger-ui.html"
						+ "\n----------------------------------------------------------"
						+"\n\tPerfil: {}"
						+ "\n----------------------------------------------------------",
				applicationName, applicationPort , contextStr, profileActive
		);
	}

}
