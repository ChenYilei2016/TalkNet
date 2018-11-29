package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenyilei
 * @date 2018/11/28-12:03
 * hello everyone
 */

@RestController
@RequestMapping("/spit")
@CrossOrigin
public class SpitController {

    @Autowired
    SpitService spitService;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findAll());
    }
    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Result findOne(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成 功",spitService.findById(id));
    }
    /**
     * 增加
     * @param spit
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody Spit spit ){
        spitService.add(spit);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     北京市昌平区建材城西路金燕龙办公楼一层 电话：400-618-9090
     4.2.3 根据上级ID查询吐槽列表
     （1）SpitDao新增方法定义
     （2）SpitService新增方法
     * 修改
     * @param spit
     */
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public Result update(@RequestBody Spit spit, @PathVariable String id )
    {
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除
     * @param id
     */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id ){
        spitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    @GetMapping("/comment/{parentid}/{page}/{size}")
    public Result findSpitsByParentId(@PathVariable("parentid")String parentid,
                                                @PathVariable("page")Integer page,
                                                @PathVariable("size")Integer size){
        Page result = spitService.findByParentid(parentid, page, size);
        return new Result(true,StatusCode.OK,"查询成功",
                new PageResult<Spit>(result.getTotalElements(), result.getContent() ) );
    }
    /**
     * 点赞
     * @param id
     * @return
     */
    @RequestMapping(value="/thumbup/{id}",method=RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        // 先判断有无点赞
        String userid = "111";//TODO :临时用户
        if( ! redisTemplate.hasKey("thumbup:"+userid) ){
            return new Result(false,StatusCode.REPERROR,"你已经点过赞了");
        }

        spitService.updateThumbup(id);
        redisTemplate.opsForValue().set( "thumbup_"+userid+"_"+ id,"1");

        return new Result(true,StatusCode.OK,"点赞成功");
    }

}
