package com.hayeon.springboot.web;


import com.hayeon.springboot.domain.posts.PostsRepository;
import com.hayeon.springboot.service.PostsSerivce;
import com.hayeon.springboot.web.dto.PostsResponseDto;
import com.hayeon.springboot.web.dto.PostsSaveRequestDto;
import com.hayeon.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsSerivce postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

}
