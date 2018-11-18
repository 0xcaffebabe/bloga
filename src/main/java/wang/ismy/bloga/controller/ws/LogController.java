package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.service.LogService;

import java.util.Date;

@RestController
@RequestMapping("/ws/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/request")
    @Token
    public Object request(@RequestParam("token") String token,@RequestParam(value = "delay",defaultValue = "0") Integer delay){
        return logService.getRequestLog(delay);
    }

    @GetMapping("/exception")
    @Token
    public Object situation(@RequestParam("token") String token){
        return logService.getSituationLog();
    }

    @GetMapping("/visitor")
    @Token
    public Object stayTime(@RequestParam("token") String token){
        return logService.getStayTimeLog();
    }

    @GetMapping("/sql")
    @Token
    public Object sql(@RequestParam("token") String token,@RequestParam(value = "delay",defaultValue = "0") Integer delay){
        return logService.getSqlLog(delay);
    }

//    清理日志接口

    @DeleteMapping("/clean/{date}")
    @Token
    public Object clean(@RequestParam("token") String token,@PathVariable("date") String date){
        return logService.cleanLog(date);
    }
}
