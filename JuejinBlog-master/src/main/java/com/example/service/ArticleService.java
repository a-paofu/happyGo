package com.example.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.ArticleBodyMapper;
import com.example.dao.ArticleMapper;
import com.example.entity.Article;
import com.example.entity.ArticleBody;
import com.example.utils.CopyUtil;
import com.example.vo.ArticleBodyVO;
import com.example.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleBodyMapper articleBodyMapper;

    public List<ArticleVO> getArticles(){
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        List<Article> articles = articleMapper.selectList(queryWrapper);
        List<ArticleVO> articleVOS = CopyUtil.copyList(articles, ArticleVO.class);
        return articleVOS;
    }


    public ArticleVO getOne(Long id) {
        Article article = articleMapper.selectById(id);
        ArticleVO articleVO = CopyUtil.copy(article, ArticleVO.class);
        LambdaQueryWrapper<ArticleBody> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleBody::getId,article.getBodyId());
        ArticleBody articleBody = articleBodyMapper.selectOne(queryWrapper);
        ArticleBodyVO articleBodyVO = CopyUtil.copy(articleBody, ArticleBodyVO.class);
        articleVO.setArticleBody(articleBodyVO);
        return articleVO;
    }
}
