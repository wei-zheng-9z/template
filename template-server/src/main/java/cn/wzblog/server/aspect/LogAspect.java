package cn.wzblog.server.aspect;

import cn.wzblog.server.annotation.Log;
import cn.wzblog.server.enums.LogEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author zheng.wei
 * @Description 日志切面类
 * @create 2020-04-15 10:22 上午
 */
@Aspect
public class LogAspect {

    /**
     * 切入点为 @Log 注解添加处
     */
    @Pointcut("@annotation(cn.wzblog.server.annotation.Log)")
    public void pointcut() {
    }

    /**
     * 日志环绕通知
     *
     * @param pjp {@link ProceedingJoinPoint} 切入点信息
     * @return {@link Object} 切入方法的返回值
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 转化为方法签名获取通知对应的方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        // 获取日志通知类型
        Log logAnnotation = method.getAnnotation(Log.class);
        LogEnum logEnum = logAnnotation.value();
        String logType = logEnum.getDesc();

        // 获取方法请求参数
        boolean printArgs = true;
        Parameter[] parameters = method.getParameters();
        JSONObject paramJsonObj = new JSONObject();
        Object[] args = pjp.getArgs();
        if (parameters.length != args.length) {
            printArgs = false;
            // TODO 打印一个警告信息
        }
        if (printArgs && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                paramJsonObj.put(parameters[i].getName(), JSON.toJSONString(args[i]));
            }
        }
        String param = paramJsonObj.toJSONString();

        // 执行结果
        String operateRes = "SUCCESS";
        try {
            return pjp.proceed(args);
        } catch (Throwable tr) {
            tr.printStackTrace();
            operateRes = "FAIL";
            throw tr;
        } finally {
            // TODO 执行日志信息保存操作
        }
    }
}
