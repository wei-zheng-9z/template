package cn.wzblog.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zheng.wei
 * @Description
 * @create 2020-04-16 3:56 下午
 */
public class UniteResultInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 若存在异常跳过本次操作
        if (ex != null) {
            return;
        }
        System.out.println("this is uniteResultInterceptor");
    }
}
