package com.firok.backend;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ConfigureJSFContextParameters implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		context.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		context.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
		context.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		context.setInitParameter("facelets.DEVELOPMENT", "true");
		context.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		context.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		context.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	}

}
