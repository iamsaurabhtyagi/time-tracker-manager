package com.ttm.admin.common.model.vo.pomodoro;

public class PomodoroRequest {

	private String taskId;
	private PomodoroCycleRequest pomodoroCycle;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public PomodoroCycleRequest getPomodoroCycle() {
		return pomodoroCycle;
	}

	public void setPomodoroCycle(PomodoroCycleRequest pomodoroCycle) {
		this.pomodoroCycle = pomodoroCycle;
	}

}
