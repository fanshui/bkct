package com.bkct.controller.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        Logger logger = Logger.getLogger(FileUploadController.class);
        logger.info("originalFilename is " + originalFilename);
        String uuid = UUID.randomUUID().toString();
        logger.info("uuid is " + uuid);
        if (!file.isEmpty()) {
            file.transferTo(new File("d:/"+ uuid + originalFilename ));
        }
        return "success";
    }

}
