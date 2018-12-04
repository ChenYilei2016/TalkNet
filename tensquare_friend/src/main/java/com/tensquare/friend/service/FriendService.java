package com.tensquare.friend.service;

import com.tensquare.friend.client.UserClient;
import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenyilei
 * @date 2018/12/03-16:08
 * hello everyone
 */

@Service
@Transactional
public class FriendService {
    @Autowired
    FriendDao friendDao;
    @Autowired
    NoFriendDao noFriendDao;
    @Autowired
    UserClient userClient;

    public int addFriend(String userId, String friendid) {
        //判断 是否已经添加了好友
        Friend isFriend =friendDao.findByUseridAndFriendid(userId,friendid);
        if(isFriend != null){
            return 0;
        }
        //判断 好友有没有加自己
        Friend isFriend2 = friendDao.findByUseridAndFriendid(friendid,userId);
        //也加了自己 -> 自己添加1 好友变为1
        Friend query = new Friend();
        query.setUserid(userId); query.setFriendid(friendid);
        if(isFriend2 != null){
            query.setIslike("1");
            friendDao.save(query);
            friendDao.updateLike("1",friendid,userId);
        }else{
            //没有加自己 -> 自己添加0
            query.setIslike("0");
            friendDao.save(query);
        }
        userClient.updateFanscountAndFollowcount(userId,friendid,"1");
        return 1;
    }

    public int addNoFriend(String userId, String friendid) {
        // 判断
        NoFriend isFriend = noFriendDao.findByUseridAndFriendid(userId, friendid);
        if(isFriend != null){
            return 0;
        }
        NoFriend query = new NoFriend();
        query.setUserid(userId); query.setFriendid(friendid);
        noFriendDao.save(query);

        return 0;
    }

    public void deleteFriend(String userId, String friendid) {
        friendDao.deleteByUseridAndFriendid(userId,friendid);
        friendDao.updateLike("0",friendid,userId);
        userClient.updateFanscountAndFollowcount(userId,friendid,"-1");
    }
}
