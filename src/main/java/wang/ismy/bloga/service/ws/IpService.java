package wang.ismy.bloga.service.ws;


import net.ipip.datx.City;
import net.ipip.datx.IPv4FormatException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.entity.Region;

import java.io.IOException;

@Service
public class IpService {

    @Autowired
    private City city;

    //根据IP返回一个地区对象
    public Region getRegionByIp(String ip) throws IPv4FormatException {
        String[] ret=city.find(ip);
        String country="";
        String province="";
        String city="";
        if(ret.length>=1){
            country=ret[0];
        }
        if(ret.length>=2){
            province=ret[1];
        }
        if(ret.length>=3){
            province=ret[2];
        }
        Region region=new Region();
        region.setCity(city);
        region.setCountry(country);
        region.setProvince(province);

        return region;
    }

    @Bean
    public City getCity(){
        try {
            return new City("ip.datx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
