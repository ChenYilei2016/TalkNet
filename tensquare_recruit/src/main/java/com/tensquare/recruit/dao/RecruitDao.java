package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state); //4个 职位

    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);//不是什么的
}
