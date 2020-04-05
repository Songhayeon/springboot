package com.hayeon.springboot.web;

import com.hayeon.springboot.service.PostsSerivce;
import com.hayeon.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsSerivce postsSerivce;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsSerivce.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsSerivce.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
