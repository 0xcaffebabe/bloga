package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.service.LogService;

@RestController
@RequestMapping("/ws/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/request")
    @Token
    public Object request(@RequestParam("token") String token){
        return logService.getRequestLog();
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
    public Object sql(@RequestParam("token") String token){
        return logService.getSqlLog();
    }

}
