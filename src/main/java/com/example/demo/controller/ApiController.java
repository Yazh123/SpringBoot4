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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.Student_service;

import jakarta.persistence.GeneratedValue;

@RestController
public class ApiController {
     @Autowired
     Student_service ss;
     @GeneratedValue
 	 private int value;
     
     @PostMapping("/")
     public boolean postinfo(@RequestBody Student stu) {
    	 ss.saveinfo(stu);
    	 return true;
     }
     
     @PostMapping("/n")
     public boolean postninfo(@RequestBody List<Student> stu) {
    	 ss.saveninfo(stu);
    	 return true;
     }
     
     @GetMapping("/")
      public List<Student> getinfo(){
    	 return ss.printinfo();
     }
     
     @GetMapping("/{id}")
     public Optional<Student> findid(@PathVariable int id)
     {
         return ss.findid(id);
     }
     
    @PutMapping("/{id}")
    public String updatebyid(@PathVariable int id , @RequestBody Student stu){
    	return ss.add(id,stu);
    
    }
    
    @DeleteMapping("/{id}")
	public void deletebyid(@PathVariable int id) {
		ss.deleteid(id);
	}
	
}
