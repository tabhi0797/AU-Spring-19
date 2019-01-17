package com.accolite.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		if(session.getAttribute("usertoken") == null)
		{
			((HttpServletResponse) response).sendRedirect("./login");
		}
		else
			chain.doFilter(request, response);
		
		//logging requests
		System.out.println(((HttpServletRequest)request).getRequestURL()+"?"+((HttpServletRequest)request).getQueryString());
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
