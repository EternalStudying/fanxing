package com.fanxing.common.controller;

import com.fanxing.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/service/common/common/auth")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/upload")
    public String upload(MultipartFile file, String type) {
        return commonService.upload(file, type);
    }
}
