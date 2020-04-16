package cn.wzblog.web.config;

import cn.wzblog.web.interceptor.PrintParamInterceptor;
import cn.wzblog.web.interceptor.UniteResultInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zheng.wei
 * @Description web应用配置类
 * @create 2020-04-16 4:02 下午
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public UniteResultInterceptor uniteResultInterceptor() {
        return new UniteResultInterceptor();
    }

    @Bean
    public PrintParamInterceptor printParamInterceptor() {
        return new PrintParamInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(uniteResultInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(printParamInterceptor()).addPathPatterns("/**");
    }
}
