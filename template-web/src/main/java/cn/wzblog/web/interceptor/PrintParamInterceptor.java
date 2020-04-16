package cn.wzblog.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zheng.wei
 * @Description 请求参数打印拦截器
 * @create 2020-04-16 4:37 下午
 */
@Slf4j
public class PrintParamInterceptor implements HandlerInterceptor {

    /**
     * 敏感词汇
     */
    private static final Map<String, Object> SENSITIVE_WORD;

    static {
        SENSITIVE_WORD = new HashMap<>();
        SENSITIVE_WORD.put("pwd", null);
        SENSITIVE_WORD.put("password", null);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        return true;
    }

    /**
     * 过滤参数中的敏感词汇
     */
    private void filterSensitiveWords() {

    }
}
