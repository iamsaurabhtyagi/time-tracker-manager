package com.ttm.admin.pomodoro.repository.activate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ttm.admin.common.model.entity.pomodoro.Pomodoro;

public interface PomodoroActivateRepository extends MongoRepository<Pomodoro, ObjectId> {
	
	public Pomodoro findByUserIdAndTaskIdAndDateAndStatus(String userId, String taskId, String date, String status);
	
}
