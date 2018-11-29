package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @author chenyilei
 * @date 2018/11/28-18:40
 * hello everyone
 */
@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    IdWorker idWorker;
/**
 * 增加文章
 * @param article
 */
    public void addArticle(Article article){
//        article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        return articleDao.findByContentLikeOrTitleLike(keywords,keywords,PageRequest.of(page-1,size));
    }
}
