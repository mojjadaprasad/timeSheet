package org.tc.timesheet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.HolidayDto;
import org.tc.timesheet.service.HolidayService;

@RestController
@RequestMapping("/holiday")
public class HolidayController {

	@Autowired
	HolidayService service;
	
	@GetMapping
	@ResponseBody
	public List<HolidayDto> getList() {
		List<HolidayDto> list = service.findAll();
		return list;
	}

	@PostMapping
	@ResponseBody
	public HolidayDto addHoliday(@RequestBody HolidayDto employeeModel) {
		HolidayDto employee = service.save(employeeModel);
		return employee;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public HolidayDto getById(@PathVariable(value = "id") Long id) {
		HolidayDto employeeModel = service.findById(id);

		return employeeModel;
	}

	@PutMapping
	@ResponseBody
	public HolidayDto update(@RequestBody HolidayDto employeeModel) {
		HolidayDto updateData = service.update(employeeModel);
		return updateData;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable(value = "id") Long id) {
		Map<String, Object> responseMap = service.delete(id);
		return responseMap;
	}
}
