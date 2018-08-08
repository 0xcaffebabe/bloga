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

//    获取今日数据概况
    @GetMapping("/today")
    @Token
    public Object getTodayOverView(@RequestParam("token") String token){
        return overviewService.getTodayOverview();
    }

//    往日数据概况
    @GetMapping("/olderDay/{older}")
    @Token
    public Object getOlderDayOverView(@RequestParam("token") String token, @PathVariable("older") Integer older){
        return overviewService.getOlderOverview(older);
    }

//    地区分布数据
    @GetMapping("/region")
    @Token
    public Object getRegion(@RequestParam("token") String token){
        return overviewService.getRegion();
    }

//    浏览器数据
    @GetMapping("/browser")
    @Token
    public Object getBrowser(@RequestParam("token") String token){
        return overviewService.getBrowser();
    }

//    各时段请求数据
    @GetMapping("/timeInterval")
    @Token
    public Object getTimeInterval(@RequestParam("token") String token){
        return overviewService.getTimeInterval();
    }

    //获取今日蜘蛛情况
    @GetMapping("/spider/today")
    @Token
    public Object getTodaySpider(@RequestParam("token") String token){
        return overviewService.getTodaySpider();
    }

//    历史蜘蛛概况
    @GetMapping("/spider/whole")
    @Token
    public Object getWholeSpider(@RequestParam("token") String token){
        return overviewService.getWholeSpider();
    }

//    蜘蛛最爱的页面
    @GetMapping("/spider/top10")
    @Token
    public Object getTop10(@RequestParam("token") String token){
        return overviewService.getTop10();
    }

//    最近七日蜘蛛情况
    @GetMapping("/spider/tend")
    @Token
    public Object getTend(@RequestParam("token") String token){
        return overviewService.getTend();
    }

//    蜘蛛最爱的时间段数据
    @GetMapping("/spider/interval")
    @Token
    public Object getInterval(@RequestParam("token") String token){
        return overviewService.getInterval();
    }

//    今日性能数据
    @GetMapping("/performance/today")
    @Token
    public Object performanceToday(@RequestParam("token") String token){
        return overviewService.performanceToday();
    }

//    各时段SQL语句执行数
    @GetMapping("/performance/interval")
    @Token
    public Object performanceInterval(@RequestParam("token") String token){
        return overviewService.performanceInterval();
    }

//    当日访客数据
    @GetMapping("/visitor/over")
    @Token
    public Object getVisitorOver(@RequestParam("token") String token){
        return overviewService.getVisitorOver();
    }

//    访客排行
    @GetMapping("/visitor/visitorTop")
    @Token
    public Object getVisitorTop(@RequestParam("token") String token){
        return overviewService.getVisitorTop();
    }

//    访客最爱的页面
    @GetMapping("/visitor/visitorPage")
    @Token
    public Object getVisitorPage(@RequestParam("token") String token){
        return overviewService.getVisitorPage();
    }


}
