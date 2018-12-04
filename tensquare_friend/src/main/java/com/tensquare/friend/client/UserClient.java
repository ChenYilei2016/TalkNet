package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenyilei
 * @date 2018/12/03-18:38
 * hello everyone
 */
@FeignClient(value = "tensquare-user",fallback = UserClientFallBack.class)
@RequestMapping("/user")
public interface UserClient {

    @PutMapping("/{userid}/{friendid}/{x}")
    public void updateFanscountAndFollowcount(@PathVariable("userid") String userid,
                                              @PathVariable("friendid") String friendid,
                                              @PathVariable("x") String x);

}
