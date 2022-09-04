package com.ttm.admin.task.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttm.admin.common.config.CommonDateFormatter;
import com.ttm.admin.common.enums.task.TASK_PRIORITY;
import com.ttm.admin.common.enums.task.TASK_STATUS;
import com.ttm.admin.common.model.entity.task.Task;
import com.ttm.admin.task.repository.TaskManagerRepository;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	private TaskManagerRepository repository;

	@Override
	public Task createTask(Task task) {
		// TODO: JWT token validation
		// TODO: Field validation if required
		task.setGroupId("1"); // TODO: get the group id from grouping service
		task.setUserId("1"); // TODO: get the user id from JWT token
		task.setCreatedBy("system"); // TODO: get user name from JWT token
		task.setUsername("system"); // TODO: get the username from JWT token
		task.setPriority(getTaskPriority(task));
		return repository.insert(task);
	}

	@Override
	public Task updateTask(Task task) {
		// TODO: JWT token validation
		// TODO: Field validation if required

		// User can update only title, description, urgent and important
		task.setUpdatedAt(CommonDateFormatter.dateTimeZoneFormatterToString(new Date()));
		task.setUpdatedBy("System");

		return repository.save(task);
	}

	@Override
	public Task deleteTask(String id) {
		// TODO: JWT token validation
		// TODO: Field validation if required
		
		Task task = getTaskById(new ObjectId(id));
		task.setStatus(TASK_STATUS.DELETE); // soft delete
		task.setUpdatedAt(CommonDateFormatter.dateTimeZoneFormatterToString(new Date()));
		task.setUpdatedBy("System");

		return repository.save(task);
	}

	@Override
	public Task readTask(String id) {
		// TODO: JWT token validation
		return getTaskById(new ObjectId(id));
	}

	@Override
	public List<Task> listTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	private Task getTaskById(ObjectId id) {
		Optional<Task> task = repository.findById(id);
		return task.get();
	}

	private TASK_PRIORITY getTaskPriority(Task task) {
		if (task.isImportant() && task.isUrgent())
			return TASK_PRIORITY.VERY_HIGH;
		else if (task.isUrgent())
			return TASK_PRIORITY.HIGH;
		else if (task.isImportant())
			return TASK_PRIORITY.MEDIUM;
		else
			return TASK_PRIORITY.LOW;
	}

}
