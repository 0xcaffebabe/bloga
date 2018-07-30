package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.service.ws.OverviewService;

@RestController
@RequestMapping("/ws/overview")
public class OverviewController {

    @Autowired
    private OverviewService overviewService;
    @GetMapping("/today")
    @Token
    public Object getTodayOverView(@RequestParam("token") String token){
        return overviewService.getTodayOverview();
    }
}
