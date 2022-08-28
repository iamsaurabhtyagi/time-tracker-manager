package com.ttm.admin.pomodoro.controller.activate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ttm.admin.common.config.CommonDateFormatter;
import com.ttm.admin.common.constants.PomodoroConstants;
import com.ttm.admin.common.enums.pomodoro.ON;
import com.ttm.admin.common.enums.pomodoro.STAGE;
import com.ttm.admin.common.enums.pomodoro.STATUS;
import com.ttm.admin.common.model.entity.pomodoro.Pomodoro;
import com.ttm.admin.common.model.entity.pomodoro.PomodoroCycle;
import com.ttm.admin.common.model.vo.pomodoro.PomodoroCycleResponse;
import com.ttm.admin.common.model.vo.pomodoro.PomodoroRequest;
import com.ttm.admin.common.model.vo.pomodoro.PomodoroResponse;

public class PomodoroActivateConverter {

	public static Pomodoro requestToEntity(PomodoroRequest request) {
		Pomodoro pomodoro = new Pomodoro();

		pomodoro.setTaskId(request.getTaskId());

		pomodoro.setStatus(STATUS.ACTIVE.toString());
		pomodoro.setStage(STAGE.IN_PROGRESS.toString());

		Date date = new Date();
		pomodoro.setDate(CommonDateFormatter.dateFormatterToString(date));
		pomodoro.setStartTime(CommonDateFormatter.dateTimeFormatterToString(date));
		pomodoro.setCreatedAt(CommonDateFormatter.dateTimeZoneFormatterToString(date));

		PomodoroCycle pomodoroCycle = new PomodoroCycle();
		pomodoroCycle.setOn(request.getPomodoroCycle().getOn());
		if (pomodoroCycle.getOn() == ON.BREAK)
			pomodoroCycle.setDuration(PomodoroConstants.DEFAULT_BREAK_DURATION);
		else
			pomodoroCycle.setDuration(PomodoroConstants.DEFAULT_WORK_DURATION);
		pomodoroCycle.setStatus(STATUS.STARTED);
		pomodoroCycle.setStartTime(CommonDateFormatter.dateTimeFormatterToString(date));
		
		pomodoro.addPomodoroCycle(pomodoroCycle);

		return pomodoro;
	}

	public static PomodoroResponse entityToResponse(Pomodoro pomodoro) {
		PomodoroResponse response = new PomodoroResponse();

		
		response.setId(pomodoro.getId().toHexString());
		response.setTaskId(pomodoro.getTaskId());
		response.setStatus(pomodoro.getStatus());
		response.setStage(pomodoro.getStage());
		response.setStartTime(pomodoro.getStartTime());
		response.setPomodoroCycle(getPomodoroCycleResponseList(pomodoro.getPomodoroCycle()));

		return response;
	}

	private static List<PomodoroCycleResponse> getPomodoroCycleResponseList(List<PomodoroCycle> pomodoroCycle) {
		List<PomodoroCycleResponse> pomodoroCycleResponseList = new ArrayList<>();
		pomodoroCycle.stream().forEach(pc -> pomodoroCycleResponseList.add(getPomodoroCycleResponse(pc)));
		return pomodoroCycleResponseList;
	}

	private static PomodoroCycleResponse getPomodoroCycleResponse(PomodoroCycle pc) {
		PomodoroCycleResponse pcr = new PomodoroCycleResponse();

		pcr.setOn(pc.getOn());
		pcr.setCycle(pc.getCycle());
		pcr.setStep(pc.getStep());
		pcr.setDuration(pc.getDuration());
		pcr.setStatus(pc.getStatus().toString());
		pcr.setStartTime(pc.getStartTime());
		pcr.setEndTime(pc.getEndTime());

		return pcr;
	}

}
