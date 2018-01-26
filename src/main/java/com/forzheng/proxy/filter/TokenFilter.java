package com.forzheng.proxy.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * Created by ls on 2018/1/26.
 */
public class TokenFilter extends ZuulFilter{

	private static Logger logger = LoggerFactory.getLogger(TokenFilter.class);
	 
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s TokenFilter {},{} %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(StringUtils.isNotBlank(token)) {
        	ctx.setSendZuulResponse(true);//进行路由
        	ctx.setResponseStatusCode(200);
        	ctx.set("isSuccess", true);
        }else{
        	ctx.setSendZuulResponse(false);//不进行路由
        	ctx.setResponseStatusCode(400);
        	ctx.setResponseBody("token is empty");
        	ctx.set("isSuccess", false);
        }
        return null;
	}

	@Override
	public boolean shouldFilter() {
		return true; //是否执行该过滤器，为true执行
	}

	@Override
	public int filterOrder() {
		return 0; //filter执行顺序，数据越大，优先级越低
	}

	@Override
	public String filterType() {
		return "pre"; //请求被路由前被拦截
	}

}
