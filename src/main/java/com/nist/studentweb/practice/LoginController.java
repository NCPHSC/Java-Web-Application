package com.nist.studentweb.practice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student std = new StudentImpl();
		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(username);
		studentDTO.setPassword(password);
		boolean userExists = std.isUserExists(studentDTO);
		System.out.println(userExists);
		if(userExists) {
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("message","Invalid Credentials");
			rd.include(request, response);
		}

	}
}
