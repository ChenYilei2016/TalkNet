package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author chenyilei
 * @date 2018/12/03-16:06
 * hello everyone
 */
@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private HttpServletRequest request;
    /**
     * 添加好友
     * @param friendid 对方用户ID
     * @param type 1：喜欢 0：不喜欢
     * @return
     */
    @RequestMapping(value="/like/{friendid}/{type}",method= RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid ,
                             @PathVariable String type){
        //拿到自己的ID
        Map user_claims = (Map)request.getAttribute("user_claims");
        String userId = (String)user_claims.get("id");

        if("1".equals(type)){
            int rs = friendService.addFriend(userId,friendid);
            if(0 == rs){
                //重复添加
                return new Result(false, StatusCode.ERROR, "重复添加");
            }else{
                //成功
                return new Result(true, StatusCode.OK, "操作成功");
            }
        }else if("2".equals(type)){
            //黑名单
            int rs = friendService.addNoFriend(userId,friendid);
            if(0 == rs){
                //重复添加
                return new Result(false, StatusCode.ERROR, "重复不喜欢");
            }else{
                //成功
                return new Result(true, StatusCode.OK, "操作成功");
            }
        }else{
            return new Result(false, StatusCode.ERROR, "参数异常");
        }
    }
    @RequestMapping(value="/{friendid}",method= RequestMethod.DELETE)
    public Result deleteFriend(@PathVariable String friendid){
        //拿到自己的ID
        Map user_claims = (Map)request.getAttribute("user_claims");
        String userId = (String)user_claims.get("id");

        friendService.deleteFriend(userId,friendid);

        return new Result(true, StatusCode.OK, "操作成功");
    }

}

