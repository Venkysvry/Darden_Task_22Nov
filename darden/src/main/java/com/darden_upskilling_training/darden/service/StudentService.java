package com.darden_upskilling_training.darden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darden_upskilling_training.darden.model.StudentDao;
import com.darden_upskilling_training.darden.model.StudentEntity;
import com.darden_upskilling_training.darden.repositories.StudentRepo;

@Service
public class StudentService {
	@Autowired
	public StudentRepo studentrepo;

	public StudentEntity addStudent(StudentEntity s) {
		studentrepo.save(s);
		return s;
	}

	public List<StudentEntity> getDetails() {
		return studentrepo.findAll();
	}
	public StudentEntity getById(int id) {
		return studentrepo.findById(id);
	}
	public StudentEntity update(StudentDao s) {
		StudentEntity s1=studentrepo.findById(s.getId());
		s1.setAge(s.getAge());
		s1.setName(s.getName());
		s1.setSalary(s.getSalary());
		studentrepo.save(s1);
		return s1;
	}
	public String delete(int id) {
		StudentEntity s=studentrepo.findById(id);
		studentrepo.delete(s);
		return "deleted successfully";
	}
}
