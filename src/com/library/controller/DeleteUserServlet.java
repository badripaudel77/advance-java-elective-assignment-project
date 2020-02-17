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

public class DeleteUserServlet extends HttpServlet {

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

		User user = new User();

		System.out.println("from DeleteUserServlet, added  ");

		int id = Integer.parseInt(request.getParameter("id"));

		user.setId(id);
		
		UserService userService = new UserServiceImpl();

		boolean isUserDeleted = userService.deleteUser(user);
		
		// To get list of users

				List<User> usrList = userService.getAllUsers();

				request.setAttribute("userList", usrList);

				dispatch = context.getRequestDispatcher("/view/users.jsp");
//
//		if (isUserDeleted) {
//			System.out.println("dispatching to --- from DeleteUserServlet ? ");
//			dispatch = context.getRequestDispatcher("/home.jsp");
//		} 
//		
//		else {
//			dispatch = context.getRequestDispatcher("/home.jsp");
//		}
		dispatch.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
