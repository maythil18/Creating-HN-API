package com.HNAPI.HNAPI.Services;

import com.HNAPI.HNAPI.payload.StoryDto;

import java.util.List;

public interface StoryService {
    List<StoryDto> getAllStories();
    StoryDto getStoryById(Long id);
    StoryDto createStory(StoryDto storyDto);
    StoryDto updateStory(Long id, StoryDto storyDto);
    void deleteStoryById(Long id);
}