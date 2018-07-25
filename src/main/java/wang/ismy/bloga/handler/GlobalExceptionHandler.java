package wang.ismy.bloga.handler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import wang.ismy.bloga.Result;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e, HttpServletResponse response){
        Result result=new Result();
        result.setData(null);
        result.setStatus(response.getStatus());
        result.setMsg(e.getLocalizedMessage());
        return result;
    }
}
