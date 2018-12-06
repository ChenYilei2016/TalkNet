package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenyilei
 * @date 2018/12/06-12:16
 * hello everyone
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if(request.getRequestURI().startsWith("/admin/login")){
            return false;
        }

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("后台过滤器");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String header = request.getHeader("Authorization");

        if("no".equals(header)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
            requestContext.setResponseBody("权限不对 header");
        }

        return null;
    }
}
