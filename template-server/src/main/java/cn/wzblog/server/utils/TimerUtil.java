package cn.wzblog.server.utils;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author zheng.wei
 * @Description 时间处理工具类
 * @create 2020-04-15 11:15 上午
 */
public class TimerUtil {

    /**
     * 日期修改，通过输入原始日期，日期类型及改变值配对参数（这个配对参数指的是，类型-偏移量，这是一个参数对）
     *
     * @param originDate {@link Date} 原始日期
     * @param changeMap  {@link Map} 键值配对参数，key为下述类型取值，value偏移量正为type日期之后，负为type日期之前
     *                   Calendar.YEAR            年
     *                   Calendar.DAY_OF_MONTH    年度日
     *                   Calendar.HOUR_OF_DAY     小时
     *                   Calendar.MINUTE          分钟
     *                   Calendar.SECOND          秒
     * @return {@link Date}改变后的日期
     */
    public static Date changeDate(Date originDate, Map<Integer, Integer> changeMap) {
        if (originDate == null) {
            throw new NullPointerException("原始日期不能为空");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originDate);
        if (changeMap == null || changeMap.size() == 0) {
            return originDate;
        }
        // 根据键值对设置日期改变
        changeMap.forEach((type, offset) -> calendar.set(type, calendar.get(type) + offset));
        return calendar.getTime();
    }
}
