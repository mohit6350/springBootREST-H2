package com.quinnox.SpringBootWihtH2REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.SpringBootWihtH2REST.entity.Student;
import com.quinnox.SpringBootWihtH2REST.service.StudentService;

@RestController
@RequestMapping("/rest/student/service")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping(value="/add", consumes="application/json", produces="application/json")
	public Student addNewStudent(@RequestBody Student student){
		return studentService.addNewStudent(student);
	}
	
    @PatchMapping(value="update", produces="application/json",consumes="application/json")
	public Student updatePartialStudent(@RequestBody Student student){
    	System.out.println("Patch mapping");
		return studentService.updatePartialStudent(student);
	}
    
    @PutMapping(value="update", produces="application/json", consumes="application/json")
    public Student updateCompleteStudent(@RequestBody Student student){
    	return studentService.updateCompleteStudent(student);
    }
	
	@GetMapping(value="/getAllStudents", produces="application/json")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@DeleteMapping(value="/delete/{roll}")
    public String deleteStudent(@PathVariable int roll){
    	return studentService.deleteStudent(roll);
    }
	
}
