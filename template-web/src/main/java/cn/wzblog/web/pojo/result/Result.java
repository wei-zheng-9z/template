package cn.wzblog.web.pojo.result;

import cn.wzblog.web.pojo.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zheng.wei
 * @Description 通用格式结果对象
 * @create 2020-04-15 11:54 上午
 */
@Getter
@Setter
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    private Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    @SuppressWarnings("rawtypes")
    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    @SuppressWarnings("rawtypes")
    public static Result error() {
        return new Result(ResultCode.FAIL);
    }

    public static <T> Result<T> error(T data) {
        return new Result<>(ResultCode.FAIL, data);
    }
}