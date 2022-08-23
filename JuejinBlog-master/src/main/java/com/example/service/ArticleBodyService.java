package com.example.service;

import com.example.dao.ArticleBodyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleBodyService {
    @Autowired
    private ArticleBodyMapper articleBodyMapper;


}
