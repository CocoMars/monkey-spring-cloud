package com.github.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.article.po.Article;
import com.github.article.service.ArticleService;
import com.github.common.base.Response;
import com.github.common.base.ResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="文章控制器")
@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@ApiOperation(value = "添加文章")
	@PostMapping("/add")
	public ResponseData<String> addArticle(@RequestBody Article article) {
		if (article == null) {
			return Response.fail("参数不能为空");
		}
		if (!StringUtils.hasText(article.getTitle())) {
			return Response.fail("title不能为空");
		}
		if (!StringUtils.hasText(article.getContent())) {
			return Response.fail("content不能为空");
		}
		if (CollectionUtils.isEmpty(article.getTags())) {
			return Response.fail("tags不能为空");
		}
		if (article.getUserId() == null) {
			return Response.fail("userId不能为空");
		}
		String id = articleService.saveArticle(article);
		return Response.ok(id);
	}
	
}
