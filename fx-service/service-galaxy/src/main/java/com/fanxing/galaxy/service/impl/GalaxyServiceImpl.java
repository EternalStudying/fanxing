package com.fanxing.galaxy.service.impl;

import com.fanxing.galaxy.mapper.GalaxyMapper;
import com.fanxing.galaxy.service.GalaxyService;
import com.fanxing.model.dto.mood.MoodDto;
import com.fanxing.model.dto.mood.MoodGetDto;
import com.fanxing.model.entity.mood.Mood;
import com.fanxing.model.entity.user.User;
import com.fanxing.utils.AuthContextUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalaxyServiceImpl implements GalaxyService {

    @Autowired
    private GalaxyMapper galaxyMapper;

    @Override
    public void insertMood(MoodDto moodDto) {
        User user = AuthContextUtils.getUser();
        Mood mood = new Mood();
        BeanUtils.copyProperties(moodDto, mood);
        mood.setUid(user.getId());
        galaxyMapper.insertMood(mood);
    }

    @Override
    public List<Mood> getAllMood(MoodGetDto moodGetDto) {
        return galaxyMapper.getAllMood(moodGetDto);
    }

    @Override
    public void deleteMood(Long id) {
        galaxyMapper.deleteMood(id);
    }
}
