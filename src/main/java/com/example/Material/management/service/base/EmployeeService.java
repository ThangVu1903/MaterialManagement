package com.example.Material.management.service.base;

import com.example.Material.management.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Iterable<Employee> findAllEmployee();

    List<Employee>SearchEmployee(String term);

    Optional<Employee> findOneEmployee(Integer id);

    void saveEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
