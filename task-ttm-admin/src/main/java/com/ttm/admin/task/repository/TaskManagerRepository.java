package com.ttm.admin.task.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ttm.admin.common.model.entity.task.Task;

public interface TaskManagerRepository extends MongoRepository<Task, ObjectId> {

}
