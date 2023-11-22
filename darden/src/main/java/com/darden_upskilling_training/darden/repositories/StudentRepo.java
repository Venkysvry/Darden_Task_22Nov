package com.darden_upskilling_training.darden.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.darden_upskilling_training.darden.model.StudentEntity;

public interface StudentRepo extends MongoRepository<StudentEntity, Integer> {
	StudentEntity findById(int id );

}
