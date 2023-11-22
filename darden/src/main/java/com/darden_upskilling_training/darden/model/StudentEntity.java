package com.darden_upskilling_training.darden.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "studentdata")
public class StudentEntity {
	@Id
	private int id;
	private String name;
	private int age;
	private long salary;
	public StudentEntity() {
		
	}
	public StudentEntity(int id,String name, int age, long salary) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "StudentEntity [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
