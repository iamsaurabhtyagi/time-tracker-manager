package com.ttm.admin.pomodoro.service.activate;

import com.ttm.admin.common.model.entity.pomodoro.Pomodoro;

public interface PomodoroActivateService {
	
	public Pomodoro startPomodoroStep(Pomodoro pomodoro);
	
	public Pomodoro completePomodoroStep(String id);

}
