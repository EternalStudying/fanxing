package com.fanxing.galaxy.mapper;

import com.fanxing.model.dto.mood.MoodGetDto;
import com.fanxing.model.entity.mood.Mood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalaxyMapper {
    void insertMood(Mood mood);

    List<Mood> getAllMood(MoodGetDto moodGetDto);

    void deleteMood(Long id);
}
