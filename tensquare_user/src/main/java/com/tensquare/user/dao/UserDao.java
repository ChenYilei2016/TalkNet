package com.tensquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
	User findByMobileAndPassword(String phone,String password);
    @Modifying
    @Query(value = "update tb_user set fanscount = fanscount+ ? where id= ?",nativeQuery = true)
    void updateFansCount(String x, String userid);
    @Modifying
    @Query(value = "update tb_user set followcount = followcount+ ? where id=? ",nativeQuery = true)
    void updateFollowCount(String x, String friendid);
}
