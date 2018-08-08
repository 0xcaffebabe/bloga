package wang.ismy.bloga.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.bloga.Result;
import wang.ismy.bloga.entity.Situation;
import wang.ismy.bloga.service.SituationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @Autowired
    private SituationService situationService;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e, HttpServletRequest request,HttpServletResponse response){
        //将相关异常信息写入数据库
        new Thread(new Runnable() {
            @Override
            public void run() {
                var t=new Situation();
                t.setMsg(e.getMessage());
                var sb=new StringBuilder();
                for(StackTraceElement i:e.getStackTrace()){
                    sb.append(i+"\n");
                }
                t.setStack(sb.toString());
                situationService.add(t);
            }
        }).start();
        String requestType = request.getHeader("Blog");
        if("Restful".equals(requestType)){
            Result result=new Result();
            result.setData(null);
            result.setStatus(403);
            response.setStatus(403);
            result.setMessage(e.getLocalizedMessage());
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
