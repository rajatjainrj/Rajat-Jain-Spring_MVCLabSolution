package com.greatlearning.collegefestdebate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.collegefestdebate.model.Student;
import com.greatlearning.collegefestdebate.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String showList(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "list-students";
	}

	@RequestMapping("/showFormForAddUpdate")
	public String showFormForUpdate(@RequestParam(required = false) Integer studentId, Model model) {
		Student student;
		if (studentId != null && studentId > 0) {
			student = studentService.findById(studentId);
		}else {
			student = new Student();
		}
		model.addAttribute("student", student);
		return "student-update-form";
	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		if(student.getId() != null) {
			Student studentDb = studentService.findById(student.getId());
			studentDb.setCountry(student.getCountry());
			studentDb.setDepartment(student.getDepartment());
			studentDb.setName(student.getName());
			studentService.save(studentDb);
		}else {
			studentService.save(student);
		}
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") Integer studentId) {

		studentService.deleteById(studentId);

		return "redirect:/student/list";

	}

}
