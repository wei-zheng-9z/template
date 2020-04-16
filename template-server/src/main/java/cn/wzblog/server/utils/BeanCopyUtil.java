package cn.wzblog.server.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zheng.wei
 * @Description 对象复制工具类
 * @create 2020-04-15 10:59 上午
 */
public final class BeanCopyUtil {

    /**
     * 对象属性拷贝
     *
     * @param source {@link Object} 原对象数据
     * @param target {@link Class} 目标对象类描述对象
     * @param <T>    目标对象范型
     * @return 目标对象
     */
    public static <T> T copy(Object source, Class<T> target) {
        if (source == null || target == null) {
            throw new NullPointerException("传入参数不能为空");
        }
        try {
            T t = target.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("目标类型实例化失败 " + e.getMessage());
        }
    }

    /**
     * 集合对象属性拷贝
     *
     * @param sourceList {@link List<Object>} 原集合对象
     * @param target     {@link Class} 目标对象类描述对象
     * @param <T>        目标对象范型
     * @return {@link List<T>}目标集合对象
     */
    public static <T> List<T> copyList(List<Object> sourceList, Class<T> target) {
        if (sourceList == null || target == null) {
            throw new NullPointerException("传入参数不能为空");
        }
        if (sourceList.size() == 0) {
            return new ArrayList<>();
        }
        return JSONArray.parseArray(JSON.toJSONString(sourceList), target);
    }
}
