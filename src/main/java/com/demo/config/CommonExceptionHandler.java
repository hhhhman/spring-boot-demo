package com.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {
    /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(ConstraintViolationException e){
        Map<String,Object> result = new HashMap<String,Object>(16);
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        result.put("respError","数据验证不通过");
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }
}
