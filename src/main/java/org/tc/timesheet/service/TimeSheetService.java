package org.tc.timesheet.service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.timesheet.dto.TimeSheetDto;
import org.tc.timesheet.exception.ResourceNotFoundException;
import org.tc.timesheet.model.TimeSheetModel;
import org.tc.timesheet.repository.TimeSheetRepository;
import org.tc.timesheet.util.ExcelHelper;
import org.tc.timesheet.util.MapperUtil;

@Service
public class TimeSheetService {
	Logger log = LoggerFactory.getLogger(TimeSheetService.class);
	public static String fileName;
	@Autowired
	TimeSheetRepository repository;

	public ByteArrayInputStream load(Long managerId, Date from, Date to) {
		LocalDateTime ldt = LocalDateTime.ofInstant(to.toInstant(), ZoneId.systemDefault()).plusDays(1);
		Date nextDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		List<TimeSheetModel> list = repository.getEmployeeTimesheets(managerId, from, nextDate);
		Map<String, Object> employeeMap = segregateEmployees(list);
		String taskName = list.get(0).getAssignment().getTask();
		String projectName = list.get(0).getAssignment().getProjectName();
		// LocalDate date = LocalDate.of(from.getYear(), from.getMonth(),
		// from.getDay());

		LocalDate date = LocalDate.now();

		String monthName = date.getMonth().toString().substring(0, 3);
		Month m = date.getMonth();
		// int startYear = 1900;
		fileName = projectName.concat("-" + monthName + "-" + (date.getYear()));
		ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(employeeMap);
		log.info("Response:{{}}", in);
		return in;
	}

	private Map<String, Object> segregateEmployees(List<TimeSheetModel> list) {
		Map<String, Object> employeeSheet = new HashMap<>();
		for (TimeSheetModel timeSheet : list) {
			List<TimeSheetModel> employeeTimeSheet = null;
			if (employeeSheet.get(timeSheet.getAssignment().getEmployee().getName()) == null) {
				employeeTimeSheet = new ArrayList<>();
				employeeTimeSheet.add(timeSheet);
			} else {
				employeeTimeSheet = (List<TimeSheetModel>) employeeSheet
						.get(timeSheet.getAssignment().getEmployee().getName());
				employeeTimeSheet.add(timeSheet);
			}
			employeeSheet.put(timeSheet.getAssignment().getEmployee().getName(), employeeTimeSheet);
		}
		log.info("Responce:{{}}", employeeSheet);
		return employeeSheet;
	}

	public List<TimeSheetDto> findAll() {
		List<TimeSheetModel> timeSheetList = repository.findAll();
		List<TimeSheetDto> timeSheetDtoList = MapperUtil.map(timeSheetList, TimeSheetDto.class);
		log.debug("Responce:{}" + timeSheetDtoList);
		return timeSheetDtoList;
	}

	public List<TimeSheetDto> save(List<TimeSheetDto> timeSheetDto) {
		List<TimeSheetModel> timeSheet = MapperUtil.map(timeSheetDto, TimeSheetModel.class);
		for (TimeSheetModel model : timeSheet) {
			model.setCreatedOn(new Date());
		}
		timeSheet = repository.saveAll(timeSheet);
		timeSheetDto = MapperUtil.map(timeSheet, TimeSheetDto.class);
		log.info("Responce:{{}}", timeSheetDto);
		return timeSheetDto;
	}

	public TimeSheetDto findById(Long id) {
		TimeSheetModel timeSheet = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TimeSheet not found"));
		TimeSheetDto sheetDto = MapperUtil.map(timeSheet, TimeSheetDto.class);
		log.info("Responce:{{}}", sheetDto);
		return sheetDto;
	}

	public TimeSheetDto updateTimeSheet(TimeSheetDto timeSheetDto) {
		TimeSheetModel timeSheet = MapperUtil.map(timeSheetDto, TimeSheetModel.class);
		timeSheet = repository.save(timeSheet);
		timeSheetDto = MapperUtil.map(timeSheet, TimeSheetDto.class);
		log.info("Responce:{{}}", timeSheetDto);
		return timeSheetDto;
	}

	public List<TimeSheetDto> findByAssignmentIdAndDateRange(Long assignmentId, Date fromDate, Date toDate) {
		LocalDateTime ldt = LocalDateTime.ofInstant(toDate.toInstant(), ZoneId.systemDefault()).plusDays(1);
		Date nextDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		List<TimeSheetModel> modelList = repository.findByAssignmentIdAndDateRange(assignmentId, fromDate, nextDate);
		List<TimeSheetDto> dtoList = MapperUtil.map(modelList, TimeSheetDto.class);
		log.info("Responce:{{}}", dtoList);
		return dtoList;
	}
}
