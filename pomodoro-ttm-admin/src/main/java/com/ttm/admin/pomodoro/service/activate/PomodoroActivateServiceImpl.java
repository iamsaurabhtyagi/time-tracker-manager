package com.ttm.admin.pomodoro.service.activate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttm.admin.common.config.CommonDateFormatter;
import com.ttm.admin.common.constants.CommonConstants;
import com.ttm.admin.common.enums.pomodoro.ON;
import com.ttm.admin.common.enums.pomodoro.STAGE;
import com.ttm.admin.common.enums.pomodoro.STATUS;
import com.ttm.admin.common.model.entity.pomodoro.Pomodoro;
import com.ttm.admin.common.model.entity.pomodoro.PomodoroCycle;
import com.ttm.admin.pomodoro.repository.activate.PomodoroActivateRepository;

@Service
public class PomodoroActivateServiceImpl implements PomodoroActivateService {

	@Autowired
	private PomodoroActivateRepository pomodoroActivateRepo;

	@Override
	public Pomodoro startPomodoroStep(Pomodoro pomodoro) {
		// TODO: JWT token validation and get user data in object for further use

		pomodoro.setUserId("1");
		pomodoro.setGroupId("1");

		// TODO: get user profile data to get customized work time and break time
		// TODO: Find the current active POMODORO with UserId, TaskId, Date, Status
		Pomodoro pomodoroEntity = pomodoroActivateRepo.findByUserIdAndTaskIdAndDateAndStatus("1", "1",
				CommonDateFormatter.dateFormatterToString(new Date()), STATUS.ACTIVE.toString());
		// NOTE: if previous day task is not completed yet then run scheduler which is
		// responsible to CLOSE pomodoro cycle by system

		//Steps time Validation
		
		if (pomodoroEntity != null) {
			return updatePomodoro(pomodoroEntity, pomodoro.getPomodoroCycle().get(CommonConstants.ZERO));
		} else {
			return addNewPomodoro(pomodoro);
		}
	}

	@Override
	public Pomodoro completePomodoroStep(String id) {
		Pomodoro pomodoro = getPomodoroById(id);
		
		pomodoro.setStage(STAGE.COMPLETE.toString());
		pomodoro.setStatus(STATUS.COMPLETE.toString());
		
		Date date = new Date();
		pomodoro.setEndTime(CommonDateFormatter.dateTimeFormatterToString(date));
		pomodoro.setUpdatedAt(CommonDateFormatter.dateTimeZoneFormatterToString(date));
		
		PomodoroCycle pomodoroCycle = prevousPomodoroStep(pomodoro.getPomodoroCycle());
		pomodoroCycle.setStatus(STATUS.COMPLETE);
		pomodoroCycle.setEndTime(CommonDateFormatter.dateTimeFormatterToString(date));
		
		return saveOrUpdatePomodoro(pomodoro);
	}

	private Pomodoro updatePomodoro(Pomodoro entity, PomodoroCycle pomodoroCycle) {
		PomodoroCycle previousPomodoroCycle = prevousPomodoroStep(entity.getPomodoroCycle());

		if (pomodoroCycle.getOn() == previousPomodoroCycle.getOn())
			throw new RuntimeException("You are already on: " + pomodoroCycle.getOn());

		previousPomodoroCycle.setEndTime(CommonDateFormatter.dateTimeFormatterToString(new Date()));
		previousPomodoroCycle.setStatus(STATUS.COMPLETE);

		if (previousPomodoroCycle.getOn() == ON.WORK)
			pomodoroCycle.setCycle(previousPomodoroCycle.getCycle());
		else
			pomodoroCycle.setCycle(previousPomodoroCycle.getCycle() + 1);

		// Get user profile, IF duration not NULL then update duration

		pomodoroCycle.setStep(entity.getPomodoroCycle().size() + 1);

		// IF cycle is 4th and ON.BREAK then update endTime as well

		entity.addPomodoroCycle(pomodoroCycle);
		return saveOrUpdatePomodoro(entity);
	}

	private Pomodoro addNewPomodoro(Pomodoro entity) {
		PomodoroCycle pomodoroCycle = entity.getPomodoroCycle().get(CommonConstants.ZERO);
		pomodoroCycle.setCycle(1);
		pomodoroCycle.setStep(1);
		// set endTime, updatedAt and updatedBy of previous PomodoroCycle data

		return saveOrUpdatePomodoro(entity);
	}

	private PomodoroCycle prevousPomodoroStep(List<PomodoroCycle> pomodoroCycles) {
		Optional<PomodoroCycle> optionalPomodoroCycle = pomodoroCycles.stream()
				.reduce((pc1, pc2) -> pc1.getStep() > pc2.getStep() ? pc1 : pc2);
		return optionalPomodoroCycle.get();

	}
	
	private Pomodoro getPomodoroById(String id) {
		Optional<Pomodoro> entity = pomodoroActivateRepo.findById(new ObjectId(id));
		return entity.get();
	}

	private Pomodoro saveOrUpdatePomodoro(Pomodoro entity) {
		return pomodoroActivateRepo.save(entity);
	}

}
