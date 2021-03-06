package com.honest.sdms.basedata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置允许跨域请求
 * @author beisi
 *
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 设置允许跨域的路径
	    registry.addMapping("/**")
	        // 设置允许跨域请求的域名
	        .allowedOrigins("http://localhost:8088")
	        // 是否允许证书 不再默认开启
	        .allowCredentials(true)
	        // 设置允许的方法
	        .allowedMethods("*")
	        .allowedHeaders("*")
	        // 跨域允许时间
	        .maxAge(3600);
	}
}
