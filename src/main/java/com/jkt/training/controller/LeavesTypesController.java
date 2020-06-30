package com.jkt.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jkt.training.entity.Leaves_Types;
import com.jkt.training.service.LeavesTypesService;

@RestController
public class LeavesTypesController {
	
	@Autowired
	private LeavesTypesService ltser;
	
	@GetMapping("/leavestype/{id}")
    public Optional<Leaves_Types> getTypeById(@PathVariable int id)
    {
		return ltser.getTypebyId(id);
		
    }
   
    @PutMapping(path="/leavestype/",consumes = "application/json")
    public String addType(@RequestBody Leaves_Types ltype) {
    	ltser.addType(ltype);
    	return "added";
    }
    
    @GetMapping("/leavestype")
    public List<Leaves_Types> getAllType(){
    	return ltser.getAllType();
    }
    
    @DeleteMapping("/leavestype/{id}")
    public String deleteType(@PathVariable int id) {
    	ltser.deleteType(id);
    	return "type deleted";
    }
    
    @PutMapping(path="/leavestype/{id}",consumes = "application/json")
    public String updateType(@PathVariable int id,@RequestBody Leaves_Types ltype) {
    	ltser.updateType(ltype);
    	return "updated";
    }
    
}
