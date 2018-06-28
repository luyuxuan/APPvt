package com.testfilter.filtertest;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class filtertest1
 */
@WebFilter(filterName = "author",
initParams = { @WebInitParam(name = "chartSet", value = "utf-8") },
urlPatterns = "/*",
dispatcherTypes = {
		DispatcherType.REQUEST, DispatcherType.FORWARD })


//如果上面不写forword类型  下面.forword就不会执行
//如果我要拦截我所有的Servlet 我的serverlet都是以.do结尾的 那urlPatterns 应该写成*.do
public class filtertest1 implements Filter {
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public filtertest1() {
        // TODO Auto-generated constructor stub FourWeb
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获取初始化的参数
		String charset = config.getInitParameter("chartSet");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// 设置了字符集  怕有乱码
		httpRequest.setCharacterEncoding(charset);
		httpResponse.setCharacterEncoding(charset);
		// 进行登陆判断的逻辑
		// 获取访问地址
		String requestPath = httpRequest.getServletPath();
		Object sessionName = httpRequest.getSession(true).getAttribute(
				"account");
		
		//所有请求的页面如果是login.jsp页面或者是logsession.do直接正常进行操作||requestPath.endsWith("addserverlet.do")
		if(requestPath.endsWith("login.jsp")||requestPath.endsWith("logsession.do")||requestPath.endsWith("addserverlet.do")||requestPath.endsWith("senddataseverlet.do")||requestPath.contains("android"))
		{
			//继续执行服务器逻辑
			chain.doFilter(request, response);
		}
		else
		{
			if(sessionName!=null)
			{
				//跳到下一个过滤器在我们这次操作中就一个过滤器 就显示login.jsp页面就可以
				chain.doFilter(request, response);
			}
			else
			{
				//httpResponse.getWriter().write("请先登陆");
			    //httpResponse.sendRedirect("login.jsp");
				
				//这2句代码代表着要跳到login.jsp页面  再到servlet里面 再到main.jsp里面最后再返回来
				//上面if(sessionName!=null)语句
				httpRequest.getRequestDispatcher("login.jsp")
				.forward(httpRequest, httpResponse);
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		this.config = fConfig;
	}

}
