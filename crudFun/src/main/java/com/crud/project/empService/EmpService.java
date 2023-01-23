package com.crud.project.empService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.project.empModel.Employee;
import com.crud.project.empRepository.EmpRepository;

public class EmpService {
@Autowired
private EmpRepository empRpo;
   
   public Optional<Employee> insertDtl(Employee employee) {
	   if(empRpo.existsById(employee.getEmpId())) {
		   return Optional.empty();
	   }else {
		  return  Optional.of(empRpo.save(employee));
	   }
   }
   public List<Employee>getAllEmpDtl(){
	   return empRpo.findAll();
   }
   public Optional<Employee> getByEmpID(int id){
	  return empRpo.findById(id);
   }
   
   public Optional<Employee>updateById(Employee employee){
	   if(empRpo.existsById(employee.getEmpId())) {
		   return Optional.of(empRpo.save(employee));
	   }else {
		   return Optional.empty();
	   }
   }
   public String deleteByEmpID(int id){
	   if(empRpo.existsById(id)) {
		   empRpo.deleteById(id);
		   return"delete successfuly";
	   }else {
		   return "id not fount in dp";
	   }
   }
}
