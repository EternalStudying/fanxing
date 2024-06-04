package com.fanxing.emotion.controller;


import com.fanxing.emotion.service.EmotionalFirstAidKitService;
import com.fanxing.model.entity.emotion.EmotionalFirstAidKit;
import com.fanxing.model.vo.common.Result;
import com.fanxing.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/emotion/emotionalFirstAidKit/auth")
public class EmotionalFirstAidKitController {

    @Autowired
    private EmotionalFirstAidKitService emotionalFirstAidKitService;

    @GetMapping("/getEmotionalFirstAidKit")
    public Result getEmotionalFirstAidKit(){
        EmotionalFirstAidKit emotionalFirstAidKit = emotionalFirstAidKitService.getEmotionalFirstAidKit();
        return Result.build(emotionalFirstAidKit, ResultCodeEnum.SUCCESS);
    }
}
