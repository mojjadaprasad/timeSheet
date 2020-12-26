package org.tc.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.tc.timesheet.model.AssignmentModel;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentModel, Long> {

}
