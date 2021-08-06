package org.tc.timesheet.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	static final Logger logg = LoggerFactory.getLogger(HolidayController.class);
	@Autowired
	HolidayService service;

	@GetMapping
	@ResponseBody
	public List<HolidayDto> getList() {
		List<HolidayDto> list = service.findAll();
		logg.info("Responce:{{}}", list);
		return list;
	}

	@PostMapping
	@ResponseBody
	public HolidayDto addHoliday(@RequestBody HolidayDto employeeModel) {
		HolidayDto employee = service.save(employeeModel);
		logg.info("Responce:{{}}", employee);
		return employee;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public HolidayDto getById(@PathVariable(value = "id") Long id) {
		HolidayDto employeeModel = service.findById(id);
		logg.info("Responce:{{}}", employeeModel);
		return employeeModel;
	}

	@PutMapping
	@ResponseBody
	public HolidayDto update(@RequestBody HolidayDto employeeModel) {
		HolidayDto updateData = service.update(employeeModel);

		logg.info("Responce:{{}}", updateData);
		return updateData;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable(value = "id") Long id) {
		Map<String, Object> responseMap = service.delete(id);
		logg.info("Responce:{{}}", responseMap);
		return responseMap;
	}
}
