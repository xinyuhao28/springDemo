package hxy.hbao.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInInterceptor())
                .addPathPatterns("/**")//拦截所有的路径
                .excludePathPatterns("/LoginController/login");
        registry.addInterceptor(new Test1Interceptor())
                .addPathPatterns("/hello/**")//拦截所有的路径
                .excludePathPatterns("/LoginController/login");
    }
}
