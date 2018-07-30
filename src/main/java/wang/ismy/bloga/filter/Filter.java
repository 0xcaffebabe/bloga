package wang.ismy.bloga.filter;

import org.springframework.beans.factory.annotation.Autowired;
import wang.ismy.bloga.entity.Log;
import wang.ismy.bloga.service.ArticleViewerService;
import wang.ismy.bloga.service.LogService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "Filter",urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {

    @Autowired
    private LogService logService;


    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        long start=System.currentTimeMillis();
        chain.doFilter(req, resp);
        long end=System.currentTimeMillis();
        String UA=request.getHeader("User-Agent");
        String ip=request.getRemoteHost();
        String url=request.getRequestURI();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log log=new Log();
                log.setTime(new Date());
                log.setIp(ip);
                log.setDelay((int) (end-start));
                log.setUa(UA);
                log.setUrl(url);
                logService.addLog(log);

            }
        }).start();


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
