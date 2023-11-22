package com.darden_upskilling_training.darden.model;

public class StudentDao {
	private int id;
	private String name;
	private int age;
	private long salary;
	public StudentDao(int id,String name, int age, long salary) {
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
	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
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
		return "StudentDao [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	

}