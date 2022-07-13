package com.greatlearning.stumanagement.StudentManagement1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.stumanagement.StudentManagement1.entity.Student;
import com.greatlearning.stumanagement.StudentManagement1.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	public String showStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("studentObj", students);
		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("studentObj", student);
		model.addAttribute("mode", "Add ");
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("studentObj", student);
		model.addAttribute("mode", "Update ");
		return "student-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student = null;
		if (id == 0)
			student = new Student(firstName, lastName, course, country);
		else {
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:/students/list";
	}

	@RequestMapping("/401")
	public String AccessDenied() {
		return "401";
	}
}
