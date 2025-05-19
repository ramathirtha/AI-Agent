package com.prosper.ai.utilities.configuration;

import com.prosper.ai.utilities.AiUtilitiesApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AiUtilitiesApplication.class);
	}

}
