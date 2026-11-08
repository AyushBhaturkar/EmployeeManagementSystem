package com.ayush.ems.repository;

import com.ayush.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentIgnoreCase(String department);
    boolean existsByEmail(String email);
}
