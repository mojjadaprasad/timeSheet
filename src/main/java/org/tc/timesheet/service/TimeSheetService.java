package org.tc.timesheet.service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static String fileName;
	@Autowired
	TimeSheetRepository repository;

	public ByteArrayInputStream load(Long managerId, Date from, Date to) {
		List<TimeSheetModel> list = repository.getEmployeeTimesheets(managerId, from, to);
		Map<String, Object> employeeMap = segregateEmployees(list);
		String taskName = list.get(0).getAssignment().getTask();
		String projectName = list.get(0).getAssignment().getProjectName();
		LocalDate date = LocalDate.of(from.getYear(), from.getMonth(), from.getDay());
		String monthName = date.getMonth().toString().substring(0, 3);
		int startYear = 1900;
		fileName = projectName.concat("-" + monthName + "-" + (date.getYear() + startYear));
		ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(employeeMap);
		return in;
	}

	public List<TimeSheetDto> getEmployeeInformation(String userName, String password) {
		List<TimeSheetModel> list = repository.getEmployeeInformation(userName, password);
		List<TimeSheetDto> dtoList=MapperUtil.map(list, TimeSheetDto.class);
		return dtoList;
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
		return employeeSheet;
	}

	public List<TimeSheetDto> findAll() {
		List<TimeSheetModel> timeSheetList = repository.findAll();
		List<TimeSheetDto> timeSheetDtoList = MapperUtil.map(timeSheetList, TimeSheetDto.class);
		return timeSheetDtoList;
	}

	public List<TimeSheetDto> save(List<TimeSheetDto> timeSheetDto) {
		List<TimeSheetModel> timeSheet = MapperUtil.map(timeSheetDto, TimeSheetModel.class);
		for(TimeSheetModel model:timeSheet) {
			model.setCreatedOn(new Date());
		}
		timeSheet = repository.saveAll(timeSheet);
		timeSheetDto = MapperUtil.map(timeSheet, TimeSheetDto.class);
		return timeSheetDto;
	}

	public TimeSheetDto findById(Long id) {
		TimeSheetModel timeSheet = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TimeSheet not found"));
		TimeSheetDto sheetDto = MapperUtil.map(timeSheet, TimeSheetDto.class);
		return sheetDto;
	}

	public TimeSheetDto updateTimeSheet(TimeSheetDto timeSheetDto) {
		TimeSheetModel timeSheet = MapperUtil.map(timeSheetDto, TimeSheetModel.class);
		timeSheet = repository.save(timeSheet);
		timeSheetDto = MapperUtil.map(timeSheet, TimeSheetDto.class);
		return timeSheetDto;
	}
}
