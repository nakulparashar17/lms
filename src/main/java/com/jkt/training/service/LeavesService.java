package com.jkt.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.Leaves;
import com.jkt.training.entity.Users;
import com.jkt.training.exception.NotFoundException;
import com.jkt.training.repository.LeavesRepository;
import com.jkt.training.repository.Usersrepository;

@Service
public class LeavesService {

	@Autowired
	private LeavesRepository repository;
	
	@Autowired
	private Usersrepository userrepo;
	
	//FOR POST/PUT MAPPING
	@SuppressWarnings("deprecation")
	public Leaves applyLeaves(Leaves leaves) {
		if(!leaves.getFromDate().equals(null)&&!leaves.getToDate().equals(null)
			&&!leaves.getReason().equals(null)&&!leaves.getType().equals(null)) {
				int duration=leaves.getToDate().getDate()-leaves.getFromDate().getDate();
				leaves.setDuration(duration+1);
				leaves.setActive(true);
				return repository.save(leaves);
		}
		else {
			throw new NotFoundException("Some field data is missing!!");
		}
	}
	
	//FOR GET MAPPING(GETTING ALL)
	public List<Leaves> getAllLeaves(){
		if(repository.findAll().isEmpty()) 
			throw new NotFoundException("Leaves record is Empty!");
		else 
			return repository.findAll();
	}
	
	//FOR GET MAPPING (BY ID)
	public Optional<Leaves> getLeavesById(int id) {
		if(repository.findById(id).isPresent())
			return repository.findById(id);
		else
			throw new NotFoundException("Leave Record with id="+id+" not exist!");
	}
	
	//FOR DELETEMAPPING
	public List<Leaves> getAllActiveLeaves() {
		 return repository.getAllActiveLeaves();
	}
	
	public void deleteLeaves(int id) {
		if(repository.existsById(id)) 
			repository.deleteById(id);
		else
			throw new NotFoundException("Leaves record Id not found for deletion!");
		
	}
	
	//MAPPING SERVICE METHOD FOR GETTING AND SETTING LEAVES ACCORDING TO EMPLOYEES
	
	
	public List<Leaves> getAllLeavesByUserId(String id) {
		List<Leaves> leaves=new ArrayList<Leaves>();
		repository.findByUsersId(id).forEach(leaves::add);
		return leaves;
	}
	
	public Leaves rejectApproved(int id,String flag)
	{
		Optional<Leaves> lea=getLeavesById(id);
		System.out.println(flag);
		Leaves l=lea.get();
		System.out.print(l.getReason());
		Users user=l.getUsers();
		//Users user=l.getUsers(user);
		if(flag.equals("success")) {
			//emp.setEarnedleaves(emp.getEarnedleaves()-l.getDuration());
			userrepo.save(user);
			l.setUsers(user);
			l.setActive(false);
			l.setAcceptRejectFlag(true);
		}
		else{
			l.setActive(false);
			l.setAcceptRejectFlag(false);
		}
		repository.save(l);
	
		return l;
	}
	
	public List<Leaves> getAllApprovedLeaves(){
		return repository.getAllApprovedLeaves();
	}
	public List<Leaves> getAllRejectedLeaves(){
		return repository.getAllRejectedLeaves();
	}
}