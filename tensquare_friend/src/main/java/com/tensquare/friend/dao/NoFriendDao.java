package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chenyilei
 * @date 2018/12/03-16:52
 * hello everyone
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {
    NoFriend findByUseridAndFriendid(String var1, String var2);

}
