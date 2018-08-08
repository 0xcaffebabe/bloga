package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.entity.StayTime;
import wang.ismy.bloga.service.ws.StayTimeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/ws/stayTime")
public class StayTimeController {


    @Autowired
    private StayTimeService stayTimeService;

//    访客请求此接口获取一个唯一请求ID
    @GetMapping("/id")
    public Object in(HttpServletRequest request, @RequestParam("url") String url){
        String ip=request.getRemoteHost();
        StayTime stayTime=new StayTime();
        stayTime.setIp(ip);
        stayTime.setUrl(url);
        stayTime.setTime(new Date());
        stayTime.setResidenceTime(0);
        return stayTimeService.recordAndGetId(stayTime);
    }

//    根据请求ID更新访客留存时间
    @GetMapping("/per/{id}")
    public Object per(@PathVariable("id") Integer id){
        return stayTimeService.updateStatus(id);
    }
}
