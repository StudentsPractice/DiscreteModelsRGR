package edu.lpnu.discretemodels.rgr.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		String rootPath = System.getProperty("catalina.home") + "/discretemodels/rgr";
		String absolutePath = rootPath + "/tmp/uploads";
		
		new File(absolutePath).mkdirs();
		new File(rootPath + "/files").mkdirs();
		MultipartConfigElement multipartConfig = 
				new MultipartConfigElement(absolutePath, 10_000_000, 25_000_000, 0);
		registration.setMultipartConfig(multipartConfig);
	}

	
}
