package com.jkt.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.Leaves;
import com.jkt.training.entity.Leaves_Types;
import com.jkt.training.entity.Users;
import com.jkt.training.exception.NotFoundException;
import com.jkt.training.repository.LeavesRepository;
import com.jkt.training.repository.LeavesTypesRepository;
import com.jkt.training.repository.Usersrepository;

@Service
public class LeavesService {

	@Autowired
	private LeavesRepository repository;
	
	@Autowired
	private LeavesTypesRepository ltyperepo;
	
	@Autowired
	private Usersrepository urepo;
	
	//FOR POST/PUT MAPPING
	@SuppressWarnings("deprecation")
	public Leaves applyLeaves(Leaves leaves,int typeid) {
		if(!leaves.getFromDate().equals(null)&&!leaves.getToDate().equals(null)
			&&!leaves.getReason().equals(null)&&!leaves.getType().equals(null)) {
				int duration=leaves.getToDate().getDate()-leaves.getFromDate().getDate();
				leaves.setDuration(duration+1);
				leaves.setTaken(duration+1);
				Optional<Leaves_Types> type=ltyperepo.findById(typeid);
				Leaves_Types t=type.get();
				if(t.getMax_count()<duration) {
					throw new NotFoundException("exceed the fix count(not applied)!!");
				}
				else {	
				leaves.setType(new Leaves_Types(typeid));
				leaves.setActive(true);
				return repository.save(leaves);
				}
		}
		else {
			throw new NotFoundException("Some field data is missing!!");
		}
	}
	
	@SuppressWarnings("deprecation")
	public Leaves applyLeavesUser(Leaves leaves,int typeid,String uid) {
		if(!leaves.getFromDate().equals(null)&&!leaves.getToDate().equals(null)
			&&!leaves.getReason().equals(null)&&!leaves.getType().equals(null)) {
				int duration=leaves.getToDate().getDate()-leaves.getFromDate().getDate();
				leaves.setDuration(duration+1);
				Optional<Leaves_Types> type=ltyperepo.findById(typeid);
				leaves.setTaken(duration+1);
				Leaves_Types t=type.get();
				Optional<Users> user=urepo.findById(uid);
				Users u=user.get();
				if(t.getMax_count()<(duration+1)) {
					throw new NotFoundException("exceed the fix count(not applied)!!");
				}
				else {	
				leaves.setUsers(u);
				leaves.setType(t);
				leaves.setActive(true);
				return repository.save(leaves);
				}
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
	public Leaves getLeavesById(int id) {
		Optional<Leaves> l=repository.findById(id);
		Leaves leaves=l.get();
		if(leaves!=null)
			return leaves;
		else
			throw new NotFoundException("Leave Record with id="+id+" not exist!");
	}
	
	public Optional<Leaves> getLeavesByIdUser(int id) {
		Optional<Leaves> l=repository.findById(id);
		if(l.isPresent())
			return l;
		else
			throw new NotFoundException("Leave Record with id="+id+" not exist!");
	}
	
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
		Optional<Leaves> lea=repository.findById(id);
		System.out.println(flag);
		Leaves l=lea.get();
		System.out.print(l.getReason());
		if(flag.equals("accept")) {
			l.setActive(false);
			l.setAcceptRejectFlag(true);
			
		}
		else{
			l.setActive(false);
			l.setAcceptRejectFlag(false);
			l.setTaken(l.getTaken()-l.getDuration());
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
