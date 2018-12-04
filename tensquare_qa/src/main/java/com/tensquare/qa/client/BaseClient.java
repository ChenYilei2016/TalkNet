package com.tensquare.qa.client;

import entity.Result;
import entity.StatusCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chenyilei
 * @date 2018/12/02-17:57
 * hello everyone
 */
@FeignClient("tensquare-base")
@RequestMapping("/label")
public interface BaseClient {
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}
