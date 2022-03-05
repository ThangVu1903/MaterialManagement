package com.example.Material.management.service.impl;

import com.example.Material.management.entity.Employee;
import com.example.Material.management.repository.EmployeeRepository;
import com.example.Material.management.service.base.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> SearchEmployee(String term) {
        return employeeRepository.findEmployeeByName(term);
    }

    @Override
    public Optional<Employee> findOneEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }


}
