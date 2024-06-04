package com.fanxing.feign.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "service-common")
public interface CommonFeignClient {

    @PostMapping(value = "/service/common/common/auth/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart(value = "file") MultipartFile file, @RequestParam(value = "type") String type);

}
