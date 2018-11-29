package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenyilei
 * @date 2018/11/28-18:42
 * hello everyone
 */
@CrossOrigin
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(method= RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleService.addArticle(article);
        return new Result(true, StatusCode.OK, "操作成功");
    }
    @RequestMapping(value="/search/{keywords}/{page}/{size}",method= RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords,
                                  @PathVariable int page, @PathVariable int size){
        Page<Article> articlePage =
                articleService.findByTitleLike(keywords,page,size);
        return new Result(true, StatusCode.OK, "查询成功",
                new PageResult<Article>(articlePage.getTotalElements(),
                        articlePage.getContent()));
    }

}
