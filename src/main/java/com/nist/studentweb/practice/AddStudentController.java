package com.nist.studentweb.practice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.util.Date;

/**
 * Servlet implementation class AddStudentController
 */
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Student std = new StudentImpl();
		String username = request.getParameter("username");
		String lastname = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String id = request.getParameter("id");
		StudentDTO student = new StudentDTO();
		student.setName(username);
		student.setLastname(lastname);
		student.setDate_of_birth(dob);
		student.setGender(gender);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		student.setCpassword(cpassword);
		if(id == null || id.isEmpty())
		{
			std.saveStudentInfo(student);
		}
	
		else {
			int idnum = Integer.parseInt(id);
			student.setID(idnum);
			std.editStudentInfo(student);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
		request.setAttribute("studentDetails", std.getStudents());
		rd.forward(request, response);
	}
		
		
	}


