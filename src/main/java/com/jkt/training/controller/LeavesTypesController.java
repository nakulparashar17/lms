package com.jkt.training.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jkt.training.entity.Leaves_Types;
import com.jkt.training.service.LeavesTypesService;

@RestController
public class LeavesTypesController {
	
	@Autowired
	private LeavesTypesService ltser;
	@GetMapping("/leavestype")
    public Optional<Leaves_Types> getTypeById(int id)
    {
		return ltser.getTypebyId(id);
		
    }
}
