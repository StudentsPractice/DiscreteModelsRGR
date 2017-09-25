package edu.lpnu.discretemodels.rgr.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "edu.lpnu.discretemodels.rgr.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);

		return resolver;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/files/**")
	    	.addResourceLocations("file:" + System.getProperty("catalina.home") + "/discretemodels/rgr/files/");
	    registry.addResourceHandler("/common/**").addResourceLocations("/resources/common/");
	    registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
	    registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
	    registry.addResourceHandler("/bootstrap/**").addResourceLocations("/resources/bootstrap/");
	}

}
