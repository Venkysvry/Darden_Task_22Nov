package com.darden_upskilling_training.darden;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.darden_upskilling_training.darden.model.StudentDao;
import com.darden_upskilling_training.darden.model.StudentEntity;
import com.darden_upskilling_training.darden.repositories.StudentRepo;
import com.darden_upskilling_training.darden.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	@Mock
	StudentRepo sRepo;
	@InjectMocks
	StudentService sservice;
	@Test
	public void testGetDetails() {
		List<StudentEntity> list=new ArrayList<>();
		list.add(new StudentEntity(1,"venkatesh",24,10000));
		list.add(new StudentEntity(1,"pavan",24,10000));
		list.add(new StudentEntity(1,"srujan",24,10000));
		list.add(new StudentEntity(1,"sahith",24,10000));
		when(sRepo.findAll()).thenReturn(list);
		List<StudentEntity> userExpected=sservice.getDetails();
		assertEquals(userExpected, list);
	}
	@Test
	public void testAddStudent() {
		StudentEntity s=new StudentEntity(1,"venkatesh",25,100000);
		when(sRepo.save(s)).thenReturn(s);
		StudentEntity s1=sservice.addStudent(s);
		assertEquals(s.getId(), s1.getId());
	}
	@Test
	public void testGetById() {
		StudentEntity s=new StudentEntity(1,"venkatesh",25,100000);
		when(sRepo.findById(1)).thenReturn(s);
		StudentEntity s1=sservice.getById(s.getId());
		assertEquals(s.getId(), s1.getId());
	}
	@Test
	public void testUpdate() {
		StudentEntity s=new StudentEntity(1,"venkatesh",25,100000);
		StudentDao s1=new StudentDao(1,"sathish",26,1000000);
		when(sRepo.findById(1)).thenReturn(s);
		when(sRepo.save(s)).thenReturn(s);
		StudentEntity s2=sservice.update(s1);
		assertEquals(s1.getName(), s2.getName());
	}
@Test
public void testDelete() {
	StudentEntity s=new StudentEntity(1,"venkatesh",25,100000);
	when(sRepo.findById(1)).thenReturn(s);
	assertEquals("deleted successfully", sservice.delete(1));
}

}
