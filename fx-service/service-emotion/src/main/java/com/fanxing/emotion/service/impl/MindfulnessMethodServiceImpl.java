package com.fanxing.emotion.service.impl;

import com.fanxing.emotion.mapper.MindfulnessMethodMapper;
import com.fanxing.emotion.service.MindfulnessMethodService;
import com.fanxing.model.entity.emotion.MindfulnessMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MindfulnessMethodServiceImpl implements MindfulnessMethodService {

    @Autowired
    private MindfulnessMethodMapper mindfulnessMethodMapper;

    @Override
    public MindfulnessMethod getMindfulnessMethod() {
        return mindfulnessMethodMapper.getMindfulnessMethod();
    }
}
