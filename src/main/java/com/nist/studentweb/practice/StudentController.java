package com.nist.studentweb.practice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public StudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward ="";
		
		Student stdn = new StudentImpl();
		if(action.equals("student")) {
			request.setAttribute("studentDetails", stdn.getStudents());
			forward="Student.jsp";
		}
		else if(action.equals("home")){
				forward="Dashboard.jsp";
				}
		else if(action.equals("addstudent")){
		forward="AddStudent.jsp";
	}
		else if(action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("logout", "You are logged out!");
			forward = "Login.jsp";
		}
		else if(action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			stdn.deleteStudent(id);
			request.setAttribute("studentDetails", stdn.getStudents());
			forward = "Student.jsp";
		}
		else if(action.equals("edit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("student", stdn.getStudent(id));
			forward = "AddStudent.jsp";
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
