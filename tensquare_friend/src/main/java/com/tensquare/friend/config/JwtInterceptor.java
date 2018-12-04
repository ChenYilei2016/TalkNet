package com.tensquare.friend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.JwtMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyilei
 * @date 2018/12/01-18:54
 * hello everyone
 */
@Component
@EnableConfigurationProperties(JwtUtil.class)
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        try {
            if(authorization !=null && authorization.startsWith("Bearer ")){
                String token=authorization.substring(7);//提取token
                Claims claims = jwtUtil.parseJWT(token);
                String roles = (String)claims.get("roles");
                /**
                 * 封装成 token对象 放入request 或 threadlocal 中 放拿方便
                 */
                if(null != roles && "admin".equals(roles)  ){
                    request.setAttribute("admin_claims",claims);
                }
                if(null != roles && "user".equals(roles)  ){
                    request.setAttribute("user_claims",claims);
                }
            }
        }catch (Exception e){
            throw new RuntimeException("令牌不正确");
        }
        //TODO: 测试方便
        Map<String,Object> map = new HashMap<>();
        map.put("id","1"); map.put("mobile","17758163513");
        request.setAttribute("user_claims",map);
        return true;
    }
}
