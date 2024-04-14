package wts.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/home*","/clientes*","/doctores*","/recepcionistas*","/newcitas*","/newcliente*","/newdoctor*","/newrecep*")
		.excludePathPatterns("/");
	}
	
	@Override
    public void customize(ConfigurableServletWebServerFactory container) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error");
        container.addErrorPages(error404Page);
    }
	
}
