package cn.wzblog.server.annotation;

import cn.wzblog.server.enums.LogEnum;

import java.lang.annotation.*;

/**
 * @author zheng.wei
 * @Description 日志记录注解
 * @create 2020-04-15 10:12 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Log {

    LogEnum value();
}
