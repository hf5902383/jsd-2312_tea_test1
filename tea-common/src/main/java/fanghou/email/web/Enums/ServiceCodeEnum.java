package fanghou.email.web.Enums;

import lombok.Getter;

@Getter
public enum ServiceCodeEnum {

    SUCCESS(200,"Success"),
    BAD_REQUEST(400,"Client ERROR"),
    FAILED(500,"Service ERROR");

    private Integer code;
    private String msg;
    ServiceCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
