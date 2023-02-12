package com.nist.studentweb.practice;

import java.util.List;

public interface Student {
	public void saveStudentInfo(StudentDTO studentDTO);
	public boolean isUserExists(StudentDTO studentDTO);
	public List<StudentDTO> getStudents();
	public void deleteStudent(int ID);
	public void editStudentInfo(StudentDTO studentDTO);
	public StudentDTO getStudent(int ID);
	
}
