package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    @Query(value ="select * from tb_problem join tb_pl on id=problemid where labelid = ? ORDER BY replytime DESC ",nativeQuery = true)
    public Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    @Query(value ="select * from tb_problem join tb_pl on id=problemid where labelid = ? ORDER BY reply DESC ",nativeQuery = true)
    public Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);

    @Query(value ="select * from tb_problem join tb_pl on id=problemid where labelid = ? AND reply=0 ORDER BY createtime DESC ",nativeQuery = true)
    public Page<Problem> findWaitListByLabelId(String labelId, Pageable pageable);

}
