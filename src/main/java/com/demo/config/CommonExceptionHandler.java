package com.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName CommonExceptionHandler
 * @Description 全局异常处理
 * @Author hyj
 * @Date 2019/4/8 10:38
 * @Version 1.0
 */
@ControllerAdvice
public class CommonExceptionHandler {
    /**
     *  拦截Exception类的异常
     * @param e 异常对象
     * @return 结果
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(ConstraintViolationException e){
        Map<String,Object> result = new HashMap<>(16);
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        result.put("respError","数据验证不通过");
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }
}
