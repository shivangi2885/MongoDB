package mypkg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mypkg.entity.Employee;
import mypkg.repository.EmployeeRepository;
import mypkg.service.SequenceGeneratorService;

@RestController
@RequestMapping("emp/version1")
public class EmployeeController {
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployee")
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		return employeeRepository.save(employee);
	}
		@GetMapping("/employees")
		public List<Employee> findAllEmployees(){
			return employeeRepository.findAll();
		}

		
		@PutMapping("/updateemployees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long employeeId,
				         @Valid @RequestBody Employee employeeDetails){
			Employee emp=employeeRepository.findById(employeeId).orElse(null);
			emp.setFirstname(employeeDetails.getFirstname());
			emp.setLastname(employeeDetails.getLastname());
			emp.setEmailid(employeeDetails.getEmailid());
			final Employee updatedemp=employeeRepository.save(emp);
			return ResponseEntity.ok(updatedemp);
		}
		
		

		
		@DeleteMapping("/deleteemployee/{id}")
		public Map<String,Boolean> deleteEmployeeById(@PathVariable(value="id") Long employeeId)
		{
			Employee emp=employeeRepository.findById(employeeId).orElse(null);
			employeeRepository.delete(emp);
			Map<String,Boolean> deleteemp=new HashMap<>();
			deleteemp.put("Employee with id:"+employeeId+"is removed",Boolean.TRUE);
			return deleteemp;
		}
		
		
		
}