package org.tc.timesheet.service;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.math3.exception.NoDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.timesheet.dto.AssignmentDto;
import org.tc.timesheet.exception.ResourceNotFoundException;
import org.tc.timesheet.model.AssignmentModel;
import org.tc.timesheet.repository.AssignmentRepository;
import org.tc.timesheet.util.MapperUtil;
import org.tc.timesheet.util.Messages;
import org.tc.timesheet.util.ResponceException;

@Service
public class AssignmentService {
	Logger logg = LoggerFactory.getLogger(AssignmentService.class);
	@Autowired
	AssignmentRepository assignmentRepository;

	public List<AssignmentDto> findAll() throws IllegalAccessException, InvocationTargetException, ResponceException {
		try {
			List<AssignmentDto> dtoList = new ArrayList<>();
			List<AssignmentModel> list = assignmentRepository.findAll();
			dtoList = MapperUtil.map(list, AssignmentDto.class);
			logg.info("Responce:{{}}", dtoList);
			return dtoList;
		} catch (Exception e) {
			logg.error("No data found");
			throw new ResponceException(Messages.NO_DATA);
		}
	}

	public AssignmentDto create(AssignmentDto assignmentDto) throws IllegalAccessException, InvocationTargetException {

		AssignmentModel assignment = MapperUtil.map(assignmentDto, AssignmentModel.class);
		assignment.setCreatedOn(new Date());
		assignment.setStatus("Active");
		assignment = assignmentRepository.save(assignment);
		assignmentDto = MapperUtil.map(assignment, AssignmentDto.class);
		return assignmentDto;
	}

	public AssignmentDto findById(Long id) throws ResponceException {
		try {
			AssignmentModel assignmentModel = assignmentRepository.findById(id).get();
			// .orElseThrow(() -> new ResourceNotFoundException("Assignment not found:"));
			AssignmentDto assignmentDto = MapperUtil.map(assignmentModel, AssignmentDto.class);
			logg.info("Responce:{{}}", assignmentDto);
			return assignmentDto;
		} catch (Exception e) {
			logg.error("Id not found");
			throw new ResponceException(Messages.INVALID_ID);
		}
	}

	public AssignmentDto updateAssignment(AssignmentDto assignmentDto) throws ResponceException {
		try {
			AssignmentModel assignment = MapperUtil.map(assignmentDto, AssignmentModel.class);

			assignment = assignmentRepository.save(assignment);
			assignmentDto = MapperUtil.map(assignment, AssignmentDto.class);
			logg.info("Responce:{}", assignmentDto, "updated success");
			return assignmentDto;
		} catch (Exception e) {
			logg.error("Given data not updated");
			throw new ResponceException(Messages.NOT_UPDATE);
		}
	}

	public Map<String, Object> deleteAssignment(Long id) throws ResponceException {
		try {
			Map<String, Object> responseMap = new HashMap<>();
			AssignmentModel model = assignmentRepository.findById(id).get();
			model.setStatus("InActive");
			model = assignmentRepository.save(model);
			logg.info("Responce:{{}}", responseMap, "Successfully Deleted Record");
			return responseMap;
		} catch (Exception e) {
			logg.error(" given ID not found in database");
			throw new ResponceException(Messages.INVALID_ID);
		}
	}

	public List<AssignmentDto> findAssignments(Long employeeId) throws ResponceException {
		try {
			List<AssignmentDto> dtoList = new ArrayList<>();
			List<AssignmentModel> list = assignmentRepository.findAssignments(employeeId);
			dtoList = MapperUtil.map(list, AssignmentDto.class);
			logg.error("No data found");
			return dtoList;
		} catch (Exception e) {
			logg.error("Given data not updated");
			throw new ResponceException(Messages.NOT_UPDATE);
		}
	}

}
