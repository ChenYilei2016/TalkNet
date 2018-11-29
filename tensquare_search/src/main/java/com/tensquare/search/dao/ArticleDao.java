package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author chenyilei
 * @date 2018/11/28-18:37
 * hello everyone
 */
public interface ArticleDao extends ElasticsearchRepository<Article,String> {

    Page<Article> findByContentLikeOrTitleLike(String s1,String s2,Pageable pageable);
}
