package com.studybook.viewController;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	 @Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	 	//下面三个全部在websocke中用到
	       registry.addViewController("/ws").setViewName("/ws");
	       registry.addViewController("/login").setViewName("/login");
	       registry.addViewController("/chat").setViewName("/chat");
	   }

}
