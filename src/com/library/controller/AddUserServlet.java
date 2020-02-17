package com.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.entities.User;
import com.library.services.UserService;
import com.library.servicesimpl.UserServiceImpl;

public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ServletContext context;
	RequestDispatcher dispatch;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	// the way of handling both doPost() and doGet() is similar.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// communication in web occurs in string so "username"
		// data comes as 'request'

		String fullName = request.getParameter("fullName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));

		System.out.println("from AddUserServlet, added  " + " username " + " : " + username);

		// creating user
		User user = new User();

		// setting data to that user
		user.setFullName(fullName);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);

		UserService userService = new UserServiceImpl();

		boolean isUserAdded = userService.addUser(user);

		if (isUserAdded) {
			
	List<User> usrList = userService.getAllUsers();
			
			request.setAttribute("userList", usrList);
			
			dispatch = context.getRequestDispatcher("/view/users.jsp");
			
			System.out.println("dispatching to --- from AddUserServlet ? ");
			//dispatch = context.getRequestDispatcher("/home.jsp");
		}
		else {
			dispatch = context.getRequestDispatcher("/home.jsp");
		}
		
		dispatch.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
