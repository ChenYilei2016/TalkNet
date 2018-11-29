package com.tensquare.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author chenyilei
 * @date 2018/11/28-18:19
 * hello everyone
 */
@Data
//indexname 一般项目名 数据库名
//type 实体类的名字 -->表
@Document(indexName="tensquare",type="article")
public class Article implements Serializable {
    @Id
    private String id;

    @Field(index= true
            ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题
    @Field(index= true
            ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//文章正文


    private String state;//审核状态
}
