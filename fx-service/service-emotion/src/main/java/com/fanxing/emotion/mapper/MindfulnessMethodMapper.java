package com.fanxing.emotion.mapper;

import com.fanxing.model.entity.emotion.MindfulnessMethod;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MindfulnessMethodMapper {
    MindfulnessMethod getMindfulnessMethod();
}
