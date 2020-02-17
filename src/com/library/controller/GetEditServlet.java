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

public class GetEditServlet extends HttpServlet {

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

		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = new User();
        
		user.setId(id);
        
		UserService userService = new UserServiceImpl();
       
		System.out.println("service instantiated=== from GetEditServlet.java");
	   
		User userByIdList = userService.getUserById(user);
      
		request.setAttribute("userByIdList", userByIdList);
		
		System.out.println("User updated \n dispatching to --- from EditUserServlet ? ");

		dispatch = context.getRequestDispatcher("/view/editUser.jsp");

		dispatch.forward(request, response);

}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}