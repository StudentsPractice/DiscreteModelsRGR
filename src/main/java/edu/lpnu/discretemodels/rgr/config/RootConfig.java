package edu.lpnu.discretemodels.rgr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "edu.lpnu.discretemodels.rgr" },
		excludeFilters =  {
				@Filter(type = FilterType.ANNOTATION, classes = EnableWebMvc.class)
		})
public class RootConfig {
	
}
