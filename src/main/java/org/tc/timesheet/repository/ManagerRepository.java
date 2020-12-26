package org.tc.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.tc.timesheet.model.ManagerModel;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerModel, Long> {

}
