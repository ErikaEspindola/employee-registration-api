package com.employee.registration.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.registration.api.model.Employee;
import com.employee.registration.api.repository.EmployeeRepository;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/addEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(this.countEmployees());
		return repository.save(employee);
	}
	
	@PostMapping("/editEmployee")
	public Employee editEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@GetMapping("/listEmployees")
	public List<Employee> listEmployees() {
		return repository.findAll();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		repository.deleteById(id);
		return "Colaborador deletado";
	}
	
	private int countEmployees() {
		System.out.println(repository.count());
		return (int) repository.findAll().size() + 1;
	}
}
