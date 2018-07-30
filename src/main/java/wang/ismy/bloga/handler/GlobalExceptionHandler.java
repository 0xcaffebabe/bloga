package wang.ismy.bloga.handler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.bloga.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e, HttpServletRequest request,HttpServletResponse response){
        e.printStackTrace();
        String requestType = request.getHeader("Blog");
        if("Restful".equals(requestType)){
            Result result=new Result();
            result.setData(null);
            result.setStatus(403);
            response.setStatus(403);
            result.setMsg(e.getLocalizedMessage());
            return result;
        }else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("msg",e.getMessage());
            modelAndView.addObject("status",response.getStatus());
            return modelAndView;
        }


    }
}
