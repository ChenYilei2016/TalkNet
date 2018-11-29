package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author chenyilei
 * @date 2018/11/28-12:02
 * hello everyone
 */
public interface SpitDao extends MongoRepository<Spit,String> {
    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}
