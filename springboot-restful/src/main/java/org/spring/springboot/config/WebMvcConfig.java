package org.spring.springboot.config;

/**
 * Created by kerryf on 2017/6/13.
 */

import org.spring.springboot.interceptor.AccessTokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *  * MVC 设置
 *  *
 *  
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	/**
	 * 将拦截器配置成Bean
	 */
	public AccessTokenVerifyInterceptor tokenVerifyInterceptor() {
		return new AccessTokenVerifyInterceptor();
	}


	@Override
	/**
	 * 拦截器注册注入该拦截器，并配置拦截的URL
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns("/*");
		super.addInterceptors(registry);
	}
}