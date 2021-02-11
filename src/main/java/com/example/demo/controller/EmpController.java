package com.example.demo.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpRepo;

import com.example.demo.model.Emp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Employee") 
public class EmpController
{
	@Autowired
	EmpRepo repo;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@DeleteMapping("/emp/{aid}")
	@ApiOperation(value="REMOVE EMPLOYEE DETAILS")
	public String deleteEmp(@PathVariable int aid)
	{
		Emp a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PostMapping(path="/emp",consumes= {"application/json"})
	@ApiOperation(value="SUBMIT EMPLOYEE DETAILS")
	public Emp addEmp(@RequestBody Emp emp)
	{
		repo.save(emp);
		return emp;
	}
	@GetMapping(path="/emps")
	@ApiOperation(value="FETCH EMPLOYEE DETAILS")
	public List<Emp> getEmps()
	{
		return repo.findAll();
			
	}
	@PutMapping(path="/emp",consumes= {"application/json"})
	@ApiOperation(value="UPDATE EMPLOYEE DETAILS")
	public Emp saveOrUpdateEmp(@RequestBody Emp emp)
	{
		repo.save(emp);
		return emp;
	}
	
	
	@RequestMapping("/alien/{aid}")
	public Optional<Emp> getAlien(@PathVariable("aid")int aid)
	{
		return repo.findById(aid);
		
		
	}
}