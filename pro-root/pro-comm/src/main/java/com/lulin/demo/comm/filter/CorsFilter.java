package com.lulin.demo.comm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description CROS跨域解决
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 16:48
 */
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String origin = req.getHeader("origin");
		resp.setHeader("Access-Control-Allow-Credentials", "true");//解决带登录session不一致的跨域问题
		resp.setHeader("Access-Control-Allow-Origin", origin);//这里可以设置为*
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		resp.setHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept");
		resp.setHeader("Access-Control-Expose-Headers", "*");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}


