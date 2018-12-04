package com.tensquare.friend.client;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenyilei
 * @date 2018/12/04-19:42
 * hello everyone
 */
@Slf4j
public class UserClientFallBack implements UserClient {
    @Override
    public void updateFanscountAndFollowcount(String userid, String friendid, String x) {
        log.error("updateFanscountAndFollowcount error");
        return ;
    }
}
