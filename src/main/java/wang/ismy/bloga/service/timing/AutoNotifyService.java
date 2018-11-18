package wang.ismy.bloga.service.timing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.service.MailService;
import wang.ismy.bloga.service.ws.OverviewService;

@Service
public class AutoNotifyService {


    @Autowired
    private OverviewService overviewService;


    private static final String overviewNotifyCron="0 0 0,3,6,9,12,15,18,21 * * ? ";

    @Autowired
    private MailService mailService;
    @Scheduled(cron=overviewNotifyCron)
    public void overviewNotify(){

        var map=overviewService.getTodayOverview();

        mailService.sendtTextMail("715711877@qq.com","每小时数据概览:","这个小时的数据:"+map);
    }
}
