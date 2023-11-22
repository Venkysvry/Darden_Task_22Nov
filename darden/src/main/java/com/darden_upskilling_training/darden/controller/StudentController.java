package com.darden_upskilling_training.darden.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darden_upskilling_training.darden.model.StudentDao;
import com.darden_upskilling_training.darden.model.StudentEntity;
import com.darden_upskilling_training.darden.service.StudentService;

@RestController
@RequestMapping("/studentcontroller")
public class StudentController {
	Logger logger =LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService sservice;
	@PostMapping("/add")
	public StudentEntity addstudent(@RequestBody StudentEntity data){
		logger.info("you are inside of addstudent controller method");
		return sservice.addStudent(data);
		
	}
	@GetMapping("/get")
	public List<StudentEntity> getList(){
		logger.info("you are inside of getList controller method");
		return sservice.getDetails() ;
		
	}
	@GetMapping("/getByid/{id}")
	public StudentEntity getStudentById(@PathVariable int id) {
		logger.info("you are inside of getStudentBYId controller method");
		return sservice.getById(id);
	}
	@PutMapping("/update")
	public StudentEntity updatestudentId(@RequestBody StudentDao s) {
		logger.info("you are inside of updatestudnt controller method");
		return sservice.update(s);
		}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		logger.info("you are inside of deleteStudent controller method");
		return  sservice.delete(id);
		
	}

}
