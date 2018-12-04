package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author chenyilei
 * @date 2018/12/03-16:52
 * hello everyone
 */
public interface FriendDao extends JpaRepository<Friend,String> {
    Friend findByUseridAndFriendid(String var1,String var2);

    @Modifying
    @Query(value = "update tb_friend set islike = ?1 where userid= ?2 and friendid = ?3",nativeQuery = true)
    public void updateLike(String islike,String userid,String friendid);

    public int deleteByUseridAndFriendid(String var1,String var2);

}
