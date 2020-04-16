package cn.wzblog.web.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zheng.wei
 * @Description 结果码
 * @create 2020-04-15 1:59 下午
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    /**
     *
     */
    SUCCESS(1, "SUCCESS"),
    FAIL(-1, "FAIL");

    private int code;

    private String msg;
}
