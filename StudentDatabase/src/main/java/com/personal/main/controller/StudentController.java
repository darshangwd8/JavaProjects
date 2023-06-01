package com.personal.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.form.GradeForm;
import com.personal.main.model.Student;
import com.personal.main.repository.StudentRepository;
import com.personal.main.service.StudentServiceIMP;


@Controller
@RequestMapping("/")
public class StudentController {

	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}

	@GetMapping("/grade-list")
	public String getUsers(Model model){
		List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "grade-list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentRepository.deleteById(id);
		return "redirect:/grade-list";
	}
	
	@PostMapping("/save-grade")
	public String savestudent(@RequestParam("studentId") String studentId,
            @RequestParam("midtermGrade") int midtermGrade,
            @RequestParam("labGrade") int labGrade,
            @RequestParam("finalGrade") int finalGrade,
            Model model) {
		
		// Validate the input values
        if (midtermGrade < 0 || midtermGrade > 100 ||
            labGrade < 0 || labGrade > 100 ||
            finalGrade < 0 || finalGrade > 100 ||
            studentId.length() != 7) {
            model.addAttribute("error", "Invalid grade values or student ID length!");
            return "enter-grade";
        }

        // Create a new Student object
        Student student = new Student();
        student.setStudentId(studentId);
        student.setMidtermGrade(midtermGrade);
        student.setLabGrade(labGrade);
        student.setFinalGraded(finalGrade);
        StudentServiceIMP ss = new StudentServiceIMP();
        Double avg = ss.GradeAverage(midtermGrade, labGrade, finalGrade);
        student.setAvg(avg);
        
        // Save the student object to the database
        studentRepository.save(student);
        System.out.println("Succesfully Inserted");
		return "redirect:/enter-grade";
	}
	 @RequestMapping({"/enter-grade","/"})
	 public String login(Model model) { 
	        model.addAttribute("GradeForm", new GradeForm());
	        return "enter-grade";
	 }
	
	
}
