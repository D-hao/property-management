package com.dh.project02.returnJson;

/**
 * @Auther:D-hao
 * @Date:2020/11/11-11-11-18:35
 * @Description:com.dh.project02.returnJson
 */
public class ReturnObject {

    private String message="";
    private Object result;
    private Integer code=200;

    public ReturnObject() {
    }

    public ReturnObject(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public ReturnObject(Object result) {
        this.result = result;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "ReturnObject{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", code=" + code +
                '}';
    }
}
