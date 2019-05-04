package com.med.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.med.info.response.Response;
import com.med.info.service.MissArticleService;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	@Autowired
	MissArticleService missArticleService;
	
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public Response checkInfo(@RequestParam(value = "title", required = false) String title, @RequestParam(value = "author", required = false) String author) {
		if (null == title && null == author) {
            return new Response().failure("校验条件至少传递一个");
        }
        try {
            String taskId = missArticleService.checkArticleInfo(title, author);
            return new Response().success(taskId);
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
	}
}
