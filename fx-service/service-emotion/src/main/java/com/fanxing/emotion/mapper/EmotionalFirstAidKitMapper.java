package com.fanxing.emotion.mapper;

import com.fanxing.model.entity.emotion.EmotionalFirstAidKit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmotionalFirstAidKitMapper {
    EmotionalFirstAidKit getEmotionalFirstAidKit();
}
