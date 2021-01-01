package org.tc.timesheet.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.TimeSheetDto;
import org.tc.timesheet.model.TimeSheetModel;
import org.tc.timesheet.repository.TimeSheetRepository;
import org.tc.timesheet.service.TimeSheetService;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {

	@Autowired

	TimeSheetRepository timeSheetRepository;

	@Autowired
	TimeSheetService timeSheetService;

	@GetMapping
	@ResponseBody
	public List<TimeSheetDto> findAll() {
		List<TimeSheetDto> list = timeSheetService.findAll();
		return list;
	}
	
	@GetMapping("/search")
	public List<TimeSheetDto> findByAssignmentIdAndDateRange(@RequestParam(value="assignmentId",required=true) Long assignmentId,
			@RequestParam(value="fromDate",required=true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate ,
			@RequestParam(value="toDate",required=true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate){
		List<TimeSheetDto> dtoList=timeSheetService.findByAssignmentIdAndDateRange(assignmentId,fromDate,toDate);
		return dtoList;
	}

	@PostMapping
	@ResponseBody
	public List<TimeSheetDto> saveData(@RequestBody List<TimeSheetDto> timeSheetModel) {
		List<TimeSheetDto> timeSheet = timeSheetService.save(timeSheetModel);
		return timeSheet;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public TimeSheetDto getById(@PathVariable(value = "id") Long id, @RequestBody TimeSheetModel timeSheetModel) {
		TimeSheetDto timeSheet = timeSheetService.findById(id);
		return timeSheet;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public TimeSheetDto updateTimeSheet(@RequestBody TimeSheetDto timeSheet) {
		TimeSheetDto updateTimeSheet = timeSheetService.updateTimeSheet(timeSheet);
		return updateTimeSheet;
	}

	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> getFile(
			@RequestParam(required = true, name = "managerId") Long managerId,
			@RequestParam(name = "from", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam(name = "to", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		InputStreamResource file = new InputStreamResource(timeSheetService.load(managerId, from, to));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + TimeSheetService.fileName + ".xlsx")
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

}
