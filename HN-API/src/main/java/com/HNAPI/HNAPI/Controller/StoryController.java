package com.HNAPI.HNAPI.Controller;

import com.HNAPI.HNAPI.Services.StoryService;
import com.HNAPI.HNAPI.payload.StoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    private StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping
    public List<StoryDto> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/{id}")
    public StoryDto getStoryById(@PathVariable Long id) {
        return storyService.getStoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoryDto createStory(@RequestBody StoryDto storyDto) {
        return storyService.createStory(storyDto);
    }

    @PutMapping("/{id}")
    public StoryDto updateStory(@PathVariable Long id, @RequestBody StoryDto storyDto) {
        return storyService.updateStory(id, storyDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStoryById(@PathVariable Long id) {
        storyService.deleteStoryById(id);
    }
}