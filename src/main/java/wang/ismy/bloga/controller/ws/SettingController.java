package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.entity.Setting;
import wang.ismy.bloga.service.SettingService;

import javax.validation.Valid;

@RestController
@RequestMapping("/ws/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping("")
    @Token
    public Object getAllSettings(@RequestParam("token") String token){
        return settingService.getSettings();
    }

    @GetMapping("/{key}")
    @Token
    public Object getSetting(@RequestParam("token") String token, @PathVariable("key") String key){

        return settingService.getSettingByKey(key);
    }
    @PutMapping("")
    @Token
    public Object addSetting(@RequestParam("token") String token,
                             @RequestBody @Valid  Setting setting){
        return settingService.addSetting(setting);
    }

    @PostMapping("")
    @Token
    public Object updateSetting(@RequestParam("token") String token,
                             @RequestBody  Setting setting){
        return settingService.updateSetting(setting);
    }

    @DeleteMapping("{key}")
    @Token
    public Object deleteSettingByKey(@RequestParam("token") String token,
                                     @PathVariable("key") String key){
        return settingService.deleteSettingByKey(key);
    }

    @GetMapping("/search/{keyWord}")
    @Token
    public Object getSettingBySearch(@RequestParam("token") String token,
                                     @PathVariable("keyWord") String keyWord){
        return settingService.getSettingBySearch(keyWord);
    }



}
