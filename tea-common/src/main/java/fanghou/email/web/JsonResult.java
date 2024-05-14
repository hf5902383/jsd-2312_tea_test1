package fanghou.email.web;

import fanghou.email.web.Enums.ServiceCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一接口出参
 */
@Data
public class JsonResult<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public static JsonResult success(){
        JsonResult success = JsonResult.code(ServiceCodeEnum.SUCCESS);
        return success;
    }

    public static JsonResult success(Object list){
       JsonResult success = JsonResult.code(ServiceCodeEnum.SUCCESS);
       success.setData(list);
       return success;
    }

    public static JsonResult failed(Integer code, String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
    }




    /**
     * 统一静态封装代码，减少大量重复code
     * @param e
     * @return
     */
    private static JsonResult code(ServiceCodeEnum e){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(e.getCode());
        jsonResult.setMsg(e.getMsg());
        return jsonResult;
    }





}
