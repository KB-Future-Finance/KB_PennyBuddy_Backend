package com.kb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:5173")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
  }
  // 정적 리소스 문제 해결
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/static/", "file:src/main/webapp/static/")
        .setCachePeriod(3600)
        .resourceChain(true);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/{spring:[a-zA-Z\\-_]+}").setViewName("forward:/index.html");
//    registry.addViewController("/**/{spring:[a-zA-Z\\-_]+}").setViewName("forward:/index.html");
//    registry.addViewController("/{spring:[a-zA-Z\\-_]+}/**{spring:?!(\\.js|\\.css)$}").setViewName("forward:/index.html");
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public MessageCodesResolver getMessageCodesResolver() {
    return null;
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addFormatters(org.springframework.format.FormatterRegistry registry) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }




  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    // 필요한 경우 여기에 설정을 추가할 수 있습니다.
  }

  @Override
  public Validator getValidator() {
    return null; // 필요한 경우 Validator 구현체를 반환할 수 있습니다.
  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    // 필요한 경우 비동기 지원 설정을 여기에 추가할 수 있습니다.
  }
}

