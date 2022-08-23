package com.example.controller;

import com.example.vo.ArticleVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {
    @PostMapping("/t1")
    public void t1(@RequestBody ArticleVO articleVO){
        return ;
    }
}
