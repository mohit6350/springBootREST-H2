package com.quinnox.SpringBootWihtH2REST.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.SpringBootWihtH2REST.entity.Student;
import com.quinnox.SpringBootWihtH2REST.repository.StudentRepository;
import com.quinnox.SpringBootWihtH2REST.utils.NullAwareBeanUtilsBean;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtilsBean;
	
	public Student addNewStudent(Student student){
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student updatePartialStudent(Student student){
		Student original = studentRepository.findById(student.getRoll()).get();
		try {
			nullAwareBeanUtilsBean.copyProperties(original,student);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRepository.save(original);
	}
	
	public Student updateCompleteStudent(Student student){
		return studentRepository.save(student);
	}
	
	public String deleteStudent(int roll){
		try {
			studentRepository.deleteById(roll);
			return "student deleted successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "error deleting student by roll : "+ roll;
		}
	}
}
