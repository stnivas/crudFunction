package com.crud.project.empRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.project.empModel.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
