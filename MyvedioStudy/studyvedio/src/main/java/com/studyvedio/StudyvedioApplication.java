package com.studyvedio;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * fastjson 使用的时候需要让启动类集成 WebMvcConfigurerAdapter
 *
 */
/*@SpringBootApplication
public class StudyvedioApplication extends WebMvcConfigurerAdapter{

	*//**
	 * 1.需要先定义个convert转消息的对象
	 * 2.添加fastjson的配置信息，比如是否要格式化返回的json数据
	 * 3.在convert中添加配置信息
	 * 4.将convert添加到converters中
	 *
	 *//*
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		//1需要先定义个convert转消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat
		);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//4.将convert添加到converters中
		converters.add(fastConverter);
	}*/

/**
 * 第二种fastjson解析的方法 注入bean
 */
@SpringBootApplication
public class StudyvedioApplication{
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverter() {
		//1需要先定义个convert转消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat
		);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		//4.将convert添加到converters中
		return new HttpMessageConverters(converter);
	}


	public static void main(String[] args) {
		SpringApplication.run(StudyvedioApplication.class, args);
	}
}
