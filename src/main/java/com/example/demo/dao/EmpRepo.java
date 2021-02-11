 package com.example.demo.dao;
 


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Emp;



public interface EmpRepo extends JpaRepository<Emp,Integer>
{

}