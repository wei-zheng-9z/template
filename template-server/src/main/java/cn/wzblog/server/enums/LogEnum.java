package cn.wzblog.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zheng.wei
 * @Description 日志记录枚举类
 * @create 2020-04-15 10:16 上午
 */
@Getter
@AllArgsConstructor
public enum LogEnum {

    /**
     *
     */
    OPERATE_LOG("普通操作记录");

    private String desc;

}
