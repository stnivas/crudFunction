package com.crud.project.empController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.project.empModel.Employee;
import com.crud.project.empService.EmpService;

@RestController
@RequestMapping("/Api/v1/employee")
public class EmpController {
	@Autowired
	private EmpService empSrv;
	
	@PostMapping
	public String createDtl(@RequestBody Employee employee) {
		 Optional<Employee> emp=empSrv.insertDtl(employee);
		 if(emp.isPresent()) {
			 return "successfully created";
		 }else {
			 return "exisit employee";
		 }
	}
	@GetMapping
	public List<Employee>getAllEmp(){
		return empSrv.getAllEmpDtl();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee>getByResID(@RequestParam("id")int empId){
		Optional<Employee> emp=empSrv.getByEmpID(empId);
		if(emp.isPresent()) {
			return new ResponseEntity<>(emp.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping
	public String update(@RequestBody Employee employee) {
		Optional<Employee>emp=empSrv.updateById(employee);
	  if(emp.isEmpty()) {
		  return"not fount employee details";
	  }else {
		  return "successfuly updated";
	  }
	}
	@DeleteMapping
	public String deleteResEmp(@RequestParam int id) {
		return empSrv.deleteByEmpID(id);
	}
	
}
