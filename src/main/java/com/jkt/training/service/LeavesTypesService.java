package com.jkt.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.Leaves_Types;
import com.jkt.training.repository.LeavesTypesRepository;

@Service
public class LeavesTypesService {
	@Autowired
  private LeavesTypesRepository ltrepo;
	
	public Optional<Leaves_Types> getTypebyId(Integer id)
	{
		
		return ltrepo.findById(id);
	}
}
