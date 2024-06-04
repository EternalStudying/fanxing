package com.fanxing.emotion.controller;

import com.fanxing.emotion.service.MindfulnessMethodService;
import com.fanxing.model.entity.emotion.MindfulnessMethod;
import com.fanxing.model.vo.common.Result;
import com.fanxing.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/emotion/mindfulnessMethod/auth")
public class MindfulnessMethodController {

    @Autowired
    private MindfulnessMethodService mindfulnessMethodService;

    @GetMapping("/getMindfulnessMethod")
    public Result getMindfulnessMethod(){
        MindfulnessMethod mindfulnessMethod = mindfulnessMethodService.getMindfulnessMethod();
        return Result.build(mindfulnessMethod, ResultCodeEnum.SUCCESS);
    }

}
