package com.baizhi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req1= (HttpServletRequest) request;
			HttpServletResponse res1=(HttpServletResponse) response;
			HttpSession session = req1.getSession();
			String ok = (String) session.getAttribute("ok");
			if(ok!=null){
				chain.doFilter(request, response);
			}else{
				res1.sendRedirect("/cmfz_gaozh/login.jsp");
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
