package com.spingworkapps.sampletask.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spingworkapps.sampletask.entity.Tasks;

public interface TaskRepo extends MongoRepository<Tasks, Integer> {

}
