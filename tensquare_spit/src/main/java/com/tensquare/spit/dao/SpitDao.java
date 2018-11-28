package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author chenyilei
 * @date 2018/11/28-12:02
 * hello everyone
 */
public interface SpitDao extends MongoRepository<Spit,String> {

}
