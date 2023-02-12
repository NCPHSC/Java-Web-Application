package com.nist.studentweb.practice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.nist.studentweb.practice.DatabaseConnectivity;

public class StudentImpl implements Student {
	PreparedStatement ps = null;
	@Override
	public void saveStudentInfo(StudentDTO studentDAO) {
		String sql = "INSERT INTO student_details(username,lastname,dob,gender,phone,email,password,cpassword) VALUES (?,?,?,?,?,?,?,?)";
		try {
			ps = DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setString(1, studentDAO.getName());
			ps.setString(2, studentDAO.getLastname());
//			java.util.Date utilDateOfBirth = studentDAO.getDate_of_birth();
//			java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
//			ps.setDate(3, sqlDateOfBirth);
			ps.setString(3, studentDAO.getDate_of_birth());
			ps.setString(4, studentDAO.getGender());
			ps.setString(5, studentDAO.getPhone());
			ps.setString(6, studentDAO.getEmail());
			ps.setString(7, studentDAO.getPassword());
			ps.setString(8, studentDAO.getCpassword());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isUserExists(StudentDTO studentDTO) {
		boolean userExists = false;
		String sql = "SELECT * FROM student_details WHERE username=? AND password=?";
		try {
			ps = DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setString(1, studentDTO.getName());
			ps.setString(2, studentDTO.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userExists =true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userExists;
	}

	@Override
	public List<StudentDTO> getStudents() {
		List<StudentDTO> studentList = new ArrayList<>();
		String sql = "SELECT * from student_details";
		try {
			ps = DatabaseConnectivity.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentDTO student = new StudentDTO();
				student.setID(rs.getInt("ID"));
				student.setName(rs.getString("username"));
				student.setLastname(rs.getString("lastname"));
				student.setDate_of_birth(rs.getString("dob")); 
				student.setGender(rs.getString("gender"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				studentList.add(student);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return studentList;
	}

	@Override
	public void deleteStudent(int ID) {
		String sql = "DELETE FROM student_details WHERE ID=?";
		try {
			ps = DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setInt(1, ID);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editStudentInfo(StudentDTO studentDTO) {
		String sql = "UPDATE student_details SET username=?,lastname=?,dob=?,gender=?,phone=?,email=?,password=?,cpassword=? WHERE ID=?";
		try {
			ps = DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setString(1, studentDTO.getName());
			ps.setString(2, studentDTO.getLastname());
			ps.setString(3, studentDTO.getDate_of_birth());
			ps.setString(4, studentDTO.getGender());
			ps.setString(5, studentDTO.getPhone());
			ps.setString(6, studentDTO.getEmail());
			ps.setString(7, studentDTO.getPassword());
			ps.setString(8, studentDTO.getCpassword());
			ps.setInt(9, studentDTO.getID());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public StudentDTO getStudent(int ID) {
		StudentDTO student = new StudentDTO();
		String sql = "SELECT * FROM student_details WHERE ID=?";
		try {
			ps = DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				student.setID(rs.getInt("ID"));
				student.setName(rs.getString("username"));
				student.setLastname(rs.getString("lastname"));
				student.setDate_of_birth(rs.getString("dob")); 
				student.setGender(rs.getString("gender"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setPassword(rs.getString("password"));
				student.setCpassword(rs.getString("cpassword"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
