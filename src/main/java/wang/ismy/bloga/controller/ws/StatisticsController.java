package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.bloga.service.StatisticsService;

@RestController
@RequestMapping("/ws/st/")
public class StatisticsController {


    @Autowired
    private StatisticsService statisticsService;
    @GetMapping("online")

    public Object online(){
        return statisticsService.getOnlineUser();
    }
}
