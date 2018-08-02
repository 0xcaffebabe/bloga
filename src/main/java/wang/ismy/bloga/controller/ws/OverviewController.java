package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/olderDay/{older}")
    @Token
    public Object getOlderdayOverView(@RequestParam("token") String token, @PathVariable("older") Integer older){
        return overviewService.getOlderOverview(older);
    }

    @GetMapping("/region")
    @Token
    public Object getRegion(@RequestParam("token") String token){
        return overviewService.getRegion();
    }

    @GetMapping("/browser")
    @Token
    public Object getBrowser(@RequestParam("token") String token){
        return overviewService.getBrowser();
    }

    @GetMapping("/timeInterval")
    @Token
    public Object getTimeInterval(@RequestParam("token") String token){
        return overviewService.getTimeInterval();
    }


}
