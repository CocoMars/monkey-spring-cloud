package com.github.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.article.dao.ArticleServiceDao;
import com.github.article.po.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleServiceDao articleServiceDao;

	public String saveArticle(Article article) {
		return articleServiceDao.saveArticle(article);
	}
	
}
