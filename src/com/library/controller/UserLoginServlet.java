package com.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.entities.User;
import com.library.services.UserService;
import com.library.servicesimpl.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ServletContext context;
	RequestDispatcher dispatch;

	@Override
	public void init(ServletConfig config) throws ServletException{
		context = config.getServletContext();
	}

	//the way of handling both doPost() and doGet() is similar.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		//communication in web occurs in string so "username"
		//data comes as 'request'
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		

		//creating session variable for the future use.
		HttpSession session = request.getSession();
		
		session.setAttribute("sessionValue",username);
		
		//creating user
		User user  = new User();
		
		//setting data to that user
		user.setUsername(username);
		user.setPassword(password);
		
		UserService userService = new UserServiceImpl();
		
		boolean isUserValid = userService.isUserValid(user);
		
		if(isUserValid) {
		  dispatch = context.getRequestDispatcher("/home.jsp");
        
		}
		else {
			dispatch = context.getRequestDispatcher("/index.jsp");
		   	request.setAttribute("errorMsg", "Couldn't login || check your credentials");
		}
		dispatch.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doPost(request, response);
	}
}
