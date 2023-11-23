package com.darden_upskilling_training.darden.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.darden_upskilling_training.darden.model.StudentDao;
import com.darden_upskilling_training.darden.model.StudentEntity;
import com.darden_upskilling_training.darden.repositories.StudentRepo;
import com.darden_upskilling_training.darden.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
	@Mock
	StudentRepo srepo;
	@Mock
	private StudentService sservice;

	@InjectMocks
	StudentController scontroler;

	@Autowired
	MockMvc mockmvc;
	StudentEntity s;
	StudentDao sdao;
	List<StudentEntity> s1 = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		s = new StudentEntity(1, "venkatesh", 25, 100000);
		sdao = new StudentDao(1, "sathish", 26, 200000);

		s1.add(new StudentEntity(2, "pavan", 25, 100000));
		mockmvc = MockMvcBuilders.standaloneSetup(scontroler).build();
		// when(srepo.findById(sdao.getId())).thenReturn(s);
	}

	@Test
	public void testAddstudent() throws JsonProcessingException, Exception {

		Mockito.when(sservice.addStudent(any())).thenReturn(s);
		mockmvc.perform(post("/studentcontroller/add").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(s))).andExpect(status().isOk());
		verify(sservice, times(1)).addStudent(any());

	}

	@Test
	public void testGetStudentById() throws JsonProcessingException, Exception {
		
		when(sservice.getById(s.getId())).thenReturn(s);		
		mockmvc.perform(MockMvcRequestBuilders.get("/studentcontroller/getByid/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(s)))
		        .andDo(MockMvcResultHandlers.print());
		        verify(sservice,times(1)).getById(1);
 	}

	@Test
	public void testGetList() throws JsonProcessingException, Exception {
		when(sservice.getDetails()).thenReturn(s1);
		mockmvc.perform(MockMvcRequestBuilders.get("/studentcontroller/get")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(s1)))
				.andDo(MockMvcResultHandlers.print());

	    verify(sservice,times(1)).getDetails();
	}

	@Test
	public void testUpdatestudentId() throws JsonProcessingException, Exception {
		
		when(sservice.update(sdao)).thenReturn(s);
		
		mockmvc.perform(MockMvcRequestBuilders.put("/studentcontroller/update")
				.contentType(MediaType.APPLICATION_JSON) 
				.content(new ObjectMapper().writeValueAsString(sdao)))
				.andDo(MockMvcResultHandlers.print());
			verify(sservice,times(1)).update(sdao);	
	}
	@Test
	public void testDeleteStudent() throws JsonProcessingException, Exception {
		when(sservice.delete(1)).thenReturn("deleted successfully");
		mockmvc.perform(MockMvcRequestBuilders.delete("/studentcontroller/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
				verify(sservice,times(1)).delete(1);
				 
	}
}
