package org.tc.timesheet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.timesheet.dto.HolidayDto;
import org.tc.timesheet.exception.ResourceNotFoundException;
import org.tc.timesheet.model.HolidayModel;
import org.tc.timesheet.repository.HolidayRepository;
import org.tc.timesheet.util.MapperUtil;

@Service
public class HolidayService {

	@Autowired
	HolidayRepository holidayRepository;
	
	public List<HolidayDto> findAll() {
		List<HolidayDto> dtoList = new ArrayList<>();
		List<HolidayModel> list = holidayRepository.findAll();
		dtoList = MapperUtil.map(list, HolidayDto.class);
		return dtoList;
	}

	public HolidayDto save(HolidayDto holidayDto) {

		HolidayModel holiday = MapperUtil.map(holidayDto, HolidayModel.class);
		holiday.setCreatedOn(new Date());
		holiday = holidayRepository.save(holiday);
		holidayDto = MapperUtil.map(holiday, HolidayDto.class);
		return holidayDto;
	}

	public HolidayDto findById(Long id) {
		HolidayModel holidayModel = holidayRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Holiday not found:"));
		HolidayDto holidayDto = MapperUtil.map(holidayModel, HolidayDto.class);
		return holidayDto;
	}

	public HolidayDto update(HolidayDto holidayDto) {
		HolidayModel holiday = MapperUtil.map(holidayDto, HolidayModel.class);
		holiday = holidayRepository.save(holiday);
		holidayDto = MapperUtil.map(holiday, HolidayDto.class);
		return holidayDto;
	}

	public Map<String, Object> delete(Long id) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("response", "Successfully Deleted Record");
		holidayRepository.deleteById(id);
		return responseMap;
	}
}
