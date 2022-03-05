package com.example.Material.management.repository;

import com.example.Material.management.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    List<Employee> findEmployeeByName(String term);
}
