package com.fanxing.galaxy.controller;

import com.fanxing.galaxy.service.GalaxyService;
import com.fanxing.model.dto.mood.MoodDto;
import com.fanxing.model.dto.mood.MoodGetDto;
import com.fanxing.model.entity.mood.Mood;
import com.fanxing.model.vo.common.Result;
import com.fanxing.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/service/mood/mood/auth")
public class GalaxyController {

    @Autowired
    private GalaxyService galaxyService;

    @PostMapping("/insertMood")
    public Result insertMood(@RequestBody MoodDto moodDto){
        galaxyService.insertMood(moodDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/getAllMood")
    public Result getAllMood(@RequestBody MoodGetDto moodGetDto){
        List<Mood> list = galaxyService.getAllMood(moodGetDto);
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }

    @DeleteMapping("/deleteMood/{id}")
    public Result deleteMood(@PathVariable Long id){
        galaxyService.deleteMood(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        String url = galaxyService.upload(file);
        return Result.build(url, ResultCodeEnum.SUCCESS);
    }
}
