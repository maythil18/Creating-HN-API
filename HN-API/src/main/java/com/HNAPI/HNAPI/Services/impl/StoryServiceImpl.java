package com.HNAPI.HNAPI.Services.impl;

import com.HNAPI.HNAPI.Entity.Story;
import com.HNAPI.HNAPI.Services.StoryService;
import com.HNAPI.HNAPI.payload.StoryDto;
import com.HNAPI.HNAPI.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {
    private StoryRepository storyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository, ModelMapper modelMapper) {
        this.storyRepository = storyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StoryDto> getAllStories() {
        List<Story> stories = storyRepository.findAll();
        return stories.stream()
                .map(story -> modelMapper.map(story, StoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StoryDto getStoryById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        return story.map(value -> modelMapper.map(value, StoryDto.class)).orElse(null);
    }

    @Override
    public StoryDto createStory(StoryDto storyDto) {
        Story story = modelMapper.map(storyDto, Story.class);
        Story savedStory = storyRepository.save(story);
        return modelMapper.map(savedStory, StoryDto.class);
    }

    @Override
    public StoryDto updateStory(Long id, StoryDto storyDto) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        if (optionalStory.isPresent()) {
            Story story = optionalStory.get();
            modelMapper.map(storyDto, story);
            story.setId(id);
            Story updatedStory = storyRepository.save(story);
            return modelMapper.map(updatedStory, StoryDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStoryById(Long id) {
        storyRepository.deleteById(id);
    }
}
