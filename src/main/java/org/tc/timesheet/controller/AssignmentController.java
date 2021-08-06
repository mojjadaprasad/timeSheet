package org.tc.timesheet.controller;

import java.lang.reflect.InvocationTargetException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.AssignmentDto;
import org.tc.timesheet.repository.AssignmentRepository;
import org.tc.timesheet.service.AssignmentService;
import org.tc.timesheet.util.Messages;
import org.tc.timesheet.util.ResponceException;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	static final Logger logg = LoggerFactory.getLogger(AssignmentController.class);
	@Autowired
	AssignmentRepository assignmentRepository;

	@Autowired
	AssignmentService assignmentService;

	@GetMapping
	@ResponseBody
	public List<AssignmentDto> getList(@RequestParam(value = "employeeId", required = false) Long employeeId)
			throws IllegalAccessException, InvocationTargetException, ResponceException {

		try {
			List<AssignmentDto> list = assignmentService.findAssignments(employeeId);
			logg.info("Responce:{{}}", list);
			return list;
		} catch (Exception e) {
			logg.error("No data found");
			throw new ResponceException(Messages.NO_DATA);
		}
	}

	@GetMapping("/{id}")
	@ResponseBody
	public AssignmentDto getById(@PathVariable(value = "id") Long id) throws ResponceException {
		try {
			AssignmentDto assignmentDto = assignmentService.findById(id);
			logg.info("Responce:{{}}", assignmentDto);
			return assignmentDto;
		} catch (ResponceException e) {
			logg.error(" assignment ID not found in database");
			throw new ResponceException(Messages.INVALID_ID, e);
		}

	}

	@PostMapping
	@ResponseBody
	public AssignmentDto addAssignment(@RequestBody AssignmentDto assignmentModel)
			throws IllegalAccessException, InvocationTargetException {
		AssignmentDto assignment = assignmentService.create(assignmentModel);
		logg.info("Responce:{{}}", assignment);
		return assignment;
	}

	@PutMapping
	@ResponseBody
	public AssignmentDto updateAssignment(@RequestBody AssignmentDto assignmentModel) throws ResponceException {
		try {
			AssignmentDto updateAssignment = assignmentService.updateAssignment(assignmentModel);
			logg.info("Responce:{{}}", updateAssignment);
			return updateAssignment;
		} catch (Exception e) {
			logg.error("Given data not updated");
			throw new ResponceException(Messages.NOT_UPDATE);
		}

	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> deleteAssignment(@PathVariable(value = "id") Long id) throws ResponceException {
		try {
			Map<String, Object> responseMap = assignmentService.deleteAssignment(id);
			logg.info("Responce:{{}}", responseMap);
			return responseMap;
		} catch (Exception e) {
			throw new ResponceException(Messages.INVALID_ID);
		}
	}

}
