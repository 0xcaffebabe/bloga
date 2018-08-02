package wang.ismy.bloga.controller.ws;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wang.ismy.bloga.annotation.Token;
import wang.ismy.bloga.service.ws.UploadService;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/ws/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;
    @PostMapping("")
    @Token
    public Object upload(@RequestParam("token") String token, @RequestParam("file")MultipartFile file) throws IOException {
        File localFile=new File(System.currentTimeMillis()+file.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file.getInputStream(),
                localFile);
        String location=uploadService.aliyunUpload(localFile.getAbsolutePath());
        localFile.delete();
        return location;
    }
}
