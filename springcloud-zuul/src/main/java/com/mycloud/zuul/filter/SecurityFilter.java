package com.mycloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyingjie
 * @Title: SecurityFilter
 * @Description: 过滤器  zuul不仅只是路由，并且还能过滤，做一些安全验证。
 * @date 2019/2/20
 */

/*filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
filterOrder：过滤的顺序，越小优先级越高
shouldFilter：这里可以写逻辑判断，是否要过滤，本文true，永远过滤。
run：过滤器的具体逻辑。*/
@Component
public class SecurityFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //pre路由之前
        //routing：路由之时
        // post： 路由之后
        // error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //true表示拦截
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取Request与Response接口对象
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String securityToken = request.getParameter("token");
        if (securityToken == null) {
            ctx.setSendZuulResponse(false);
            //状态码
            ctx.setResponseStatusCode(401);
            try {
                //返回响应
                ctx.getResponse().getWriter().write("request failure , you do not have security token ");
            } catch (Exception e) {
            }
        }
        //return null 表示直接越过此Filter
        return null;
    }
}
