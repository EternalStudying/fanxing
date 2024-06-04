package com.fanxing.emotion.service.impl;

import com.fanxing.emotion.mapper.EmotionalFirstAidKitMapper;
import com.fanxing.emotion.service.EmotionalFirstAidKitService;
import com.fanxing.model.entity.emotion.EmotionalFirstAidKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionalFirstAidKitServiceImpl implements EmotionalFirstAidKitService {

    @Autowired
    private EmotionalFirstAidKitMapper emotionalFirstAidKitMapper;

    @Override
    public EmotionalFirstAidKit getEmotionalFirstAidKit() {
        return emotionalFirstAidKitMapper.getEmotionalFirstAidKit();
    }
}
