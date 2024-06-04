package com.fanxing.galaxy.service;

import com.fanxing.model.dto.mood.MoodDto;
import com.fanxing.model.dto.mood.MoodGetDto;
import com.fanxing.model.entity.mood.Mood;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalaxyService {
    void insertMood(MoodDto moodDto);

    List<Mood> getAllMood(MoodGetDto moodGetDto);

    void deleteMood(Long id);

    String upload(MultipartFile file);
}
