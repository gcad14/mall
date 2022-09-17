package com.gc.response;

/**
 * @author Administrator
 */
public class ResponseData {

    private Integer code;
    private String message;
    private Object data;

    //成功不带参数
    public static ResponseData success(){
        return new ResponseData(ResponseDataCode.SUCCESS.code,ResponseDataCode.SUCCESS.message,null);
    }
    //成功不带参数
    public static ResponseData success(Object data){
        return new ResponseData(ResponseDataCode.SUCCESS.code,ResponseDataCode.SUCCESS.message,data);
    }

    ResponseData(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
