package com.amith.article_service.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amith.article_service.resources.Article;
import com.amith.article_service.util.constants.Publusher;

@RestController
public class ArticleController {

	Logger logger = LogManager.getFormatterLogger(ArticleController.class);

	@GetMapping("/api/articles/{id}")
	public List<Article> getArticles(@PathVariable String id) {

		List<Article> samples = generateSampleArticles();

		return samples;
	}

	private List<Article> generateSampleArticles() {
		List<Article> articles = new ArrayList<>();

		Article sample1 = new Article();
		sample1.setLink("http://sample1");
		sample1.setName("sample 1");
		sample1.setPublishedDate(new Date());
		sample1.setPublusher(Publusher.MEDIUM);

		articles.add(sample1);

		Article sample2 = new Article();
		sample2.setLink("http://sample2");
		sample2.setName("sample 2");
		sample2.setPublishedDate(new Date());
		sample2.setPublusher(Publusher.LINKED_IN);

		articles.add(sample2);
		articles.add(sample1);

		return articles;
	}
}
