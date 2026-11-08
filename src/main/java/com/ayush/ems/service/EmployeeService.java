package com.ayush.ems.service;

import com.ayush.ems.exception.ResourceNotFoundException;
import com.ayush.ems.model.Employee;
import com.ayush.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Employee with this email already exists");
        }
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartmentIgnoreCase(department);
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        existing.setSalary(updated.getSalary());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
