package com.confRoomBooking.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.confRoomBooking.models.User;
import com.confRoomBooking.services.UserServiceImpl;
import com.confRoomBooking.services.userService;
import com.confRoomBooking.utilities.UserType;

/**
 * Servlet Filter implementation class Filter1
 */
public class Global extends HttpFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    System.out.println("In global filter");
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession(false);
	    String uri = req.getRequestURI();
	    System.out.println(uri);

	    if (uri.endsWith("/login")) {
	        chain.doFilter(request, response);
	        return;
	    }

	    User user = null;
	    if (session != null) {
	        user = (User) session.getAttribute("user");
	    }

	    if (user != null) {
	        chain.doFilter(request, response);
	    } else {
	        if (session == null) {
	            session = req.getSession(true); // Create a new session if it doesn't exist
	        }
	        user = new User();
	        user.setUserName("Guest");
	        user.setType(UserType.GUEST);
	        session.setAttribute("user", user);
	        RequestDispatcher dispatcher = req.getRequestDispatcher("");
	        dispatcher.forward(request, response);
	    }
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter 1 initialized");
	}

}
