package com.spingworkapps.sampletask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spingworkapps.sampletask.entity.Tasks;
import com.spingworkapps.sampletask.services.TaskServices;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class TaskController {
	
	@Autowired
	TaskServices ts;
	
	@RequestMapping(value= "/saved", method= RequestMethod.POST)
	public Tasks save(@RequestBody Tasks t) {
		ts.saveall(t);
		return t;
	}
	
	@RequestMapping(value= "/getall", method= RequestMethod.GET)
	public List<Tasks> getallTasks(){
		return ts.getall();
	}
	
	@RequestMapping(value= "/getbyid/{id}", method= RequestMethod.GET)
	public Tasks getallbyid(@PathVariable("id") int id) {
		return ts.getbyid(id);
		
	}
	
	@RequestMapping(value= "/delete/{id}", method= RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ts.deletebyid(id);
		return "success";
		
	}
	@RequestMapping(value="/update/{id}", method= RequestMethod.PUT)
	public Tasks updateTasks(@PathVariable("id") int id) {
		return ts.update(id);
	}
}

