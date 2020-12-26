package org.tc.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tc.timesheet.model.HolidayModel;

public interface HolidayRepository extends JpaRepository<HolidayModel, Long> {
}
