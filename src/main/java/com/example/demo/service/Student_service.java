package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.Student_repo;

@Service
public class Student_service {
    @Autowired
    Student_repo sr;
    
    public Student saveinfo(Student ss) {
    	return sr.save(ss);
    }
    public List<Student> saveninfo(List<Student> ss) {
    	return (List<Student>)sr.saveAll(ss);
    }
     
    public List<Student> printinfo(){
    	return sr.findAll();
    }
    
    public Optional<Student> findid(int id){
    	return sr.findById(id);
    }
   
    public void update(int id) {
    	sr.deleteById(id);
    }
    public void deleteid(int id){
    	sr.deleteById(id);
    }
    public String add(int id, Student ss) {
    	sr.saveAndFlush(ss);
    	if(sr.existsById(id)) {
    		return "updated";
    	}
    	else {
    		return "enter a valid id";
    	}
    }
    public void deletebyid(int id) {
		sr.deleteById(id);
	}
}
