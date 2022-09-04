package com.ttm.admin.common.model.entity.task;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ttm.admin.common.enums.task.TASK_PRIORITY;
import com.ttm.admin.common.enums.task.TASK_STATUS;
import com.ttm.admin.common.model.entity.base.Base;

@Document
public class Task extends Base {

	@Id
	private ObjectId id;

	private String title;

	private String description;

	private TASK_STATUS status;

	private TASK_PRIORITY priority;

	private boolean important;

	private boolean urgent;

	private String groupId;

	private String username;

	private String userId;

	private String startTime;

	private String endTime;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TASK_STATUS getStatus() {
		return status;
	}

	public void setStatus(TASK_STATUS status) {
		this.status = status;
	}

	public TASK_PRIORITY getPriority() {
		return priority;
	}

	public void setPriority(TASK_PRIORITY priority) {
		this.priority = priority;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
