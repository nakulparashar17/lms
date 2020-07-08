package com.jkt.training.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.Leaves_Types;
import com.jkt.training.repository.LeavesTypesRepository;

@Service
public class LeavesTypesService {
	
	@Autowired
	private LeavesTypesRepository ltrepo;
	
	@PostConstruct
	public void initRecords() {
		ltrepo.saveAll(new ArrayList<Leaves_Types>(Arrays.asList(new Leaves_Types(201,"Earned Leaves",4),
																 new Leaves_Types(202,"Maternity Leaves",180),
																 new Leaves_Types(203,"Accumulated Earned Leave",2),
																 new Leaves_Types(204,"Leave Without Pay",24),
																 new Leaves_Types(205,"Maternity Leave(Miscarriage)",60),
																 new Leaves_Types(206,"Maternity Leave(Adoption or Surrogacy)",60),
																 new Leaves_Types(207, "Compansatory Off",6),
																 new Leaves_Types(208,"Work From Home",24),
																 new Leaves_Types(209,"On Duty",12))));
	}
	
	public Optional<Leaves_Types> getTypebyId(Integer id)
	{
		
		return ltrepo.findById(id);
	}
	
	
	public List<Leaves_Types> getAllType(){
		return ltrepo.findAll();
	}
	
	public void deleteType(int id) {
		Leaves_Types type=ltrepo.getOne(id);
		ltrepo.delete(type);
	}
	
	public void updateType(Leaves_Types l) {
		ltrepo.save(l);
	}
	
	public void addType(Leaves_Types l) {
		ltrepo.save(l);
	}
}
