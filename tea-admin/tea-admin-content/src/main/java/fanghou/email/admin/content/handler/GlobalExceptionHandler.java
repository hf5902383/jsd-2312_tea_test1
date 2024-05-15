package fanghou.email.admin.content.handler;

import fanghou.email.web.Enums.ServiceCodeEnum;
import fanghou.email.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("捕获MethodArgumentNotValidException", e);
        List<FieldError> fieldErrors = e.getFieldErrors();
        StringBuffer allMessage = new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            String defaultMessage = fieldError.getDefaultMessage();
            allMessage.append(defaultMessage);
            allMessage.append(",");
        }
        return JsonResult.failed(ServiceCodeEnum.BAD_REQUEST.getCode(), deleteComma(allMessage));
    }


    @ExceptionHandler
    public JsonResult handleRunTimeException(RuntimeException e){
        return JsonResult.failed(ServiceCodeEnum.BAD_REQUIRE.getCode(), e.getMessage());
    }

    @ExceptionHandler
    public JsonResult handlerException(Throwable throwable){
        log.error("Service have something wrong: ",throwable);
        return JsonResult.failed(ServiceCodeEnum.BAD_REQUIRE.getCode(), "程序员正在尽力修复网络波动");
    }







    private String deleteComma(StringBuffer str){
        str.delete(str.lastIndexOf(","),str.length());
        return str.toString();
    }
}
