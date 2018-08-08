package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.entity.Setting;
import wang.ismy.bloga.service.SettingService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ws/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

//    获取所有设置
    @GetMapping("")
    @Token
    public Object getAllSettings(@RequestParam("token") String token){
        return settingService.getSettings();
    }

//    根据key获取设置
    @GetMapping("/{key}")
    @Token
    public Object getSetting(@RequestParam("token") String token, @PathVariable("key") String key){

        return settingService.getSettingByKey(key);
    }

    //根据ID获取设置
    @GetMapping("/id/{key}")
    @Token
    public Object getSettingById(@RequestParam("token") String token, @PathVariable("key") Integer id){

        return settingService.getSettingById(id);
    }

//    新增设置
    @PutMapping("")
    @Token
    public Object addSetting(@RequestParam("token") String token,
                             @RequestBody @Valid  Setting setting){
        return settingService.addSetting(setting);
    }

//    更新设置
    @PostMapping("")
    @Token
    public Object updateSetting(@RequestParam("token") String token,
                             @RequestBody  Setting setting){
        return settingService.updateSetting(setting);
    }

//    根据key删除设置
    @DeleteMapping("/{key}")
    @Token
    public Object deleteSettingByKey(@RequestParam("token") String token,
                                     @PathVariable("key") String key){
        return settingService.deleteSettingByKey(key);
    }

//    搜索设置
    @GetMapping("/search/{keyWord}")
    @Token
    public Object getSettingBySearch(@RequestParam("token") String token,
                                     @PathVariable("keyWord") String keyWord){
        return settingService.getSettingBySearch(keyWord);
    }

    //批量删除
    @DeleteMapping("")
    @Token
    public Object deleteSettingBatch(@RequestParam("token") String token,
                                     @RequestBody List<Integer> idList){
        return settingService.deleteSettingBatch(idList);
    }

    //批量更新
    @PostMapping("/batch")
    @Token
    public Object updateBatch(@RequestParam("token") String token,
                                     @RequestBody Map<String,String> map){
        return settingService.updateBatch(map);
    }

    //获取网站设置
    @GetMapping("/site")
    @Token
    public Object siteSetting(@RequestParam("token") String token){
        return settingService.siteSetting();
    }


}
