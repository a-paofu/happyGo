package com.example.controller;

import com.example.service.ArticleBodyService;
import com.example.service.ArticleService;
import com.example.vo.ArticleVO;
import com.example.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="文章管理模块")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleBodyService articleBodyService;


    @ApiOperation("查看所有文章列表")
    @GetMapping("/list")
    public Result getArticleList(){
        /**
         * 查询所有文章，返回一个list
         */
        List<ArticleVO> list = articleService.getArticles();

        return Result.success(list);
    }



    @ApiOperation("查看文章详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "文章的主键id")
    })
    @GetMapping("/get/{id}")
    public Result getArticle(@PathVariable("id") Long id){
        /**
         * 查询文章id的文章详情，返回一个ArticleVO对象
         */
        ArticleVO articleVO = articleService.getOne(id);
        System.out.println(articleVO.getCreateTime());
        return Result.success(articleVO);
    }
}
