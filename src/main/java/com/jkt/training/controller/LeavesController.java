package com.jkt.training.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jkt.training.entity.Leaves;
import com.jkt.training.entity.Users;
import com.jkt.training.service.LeavesService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class LeavesController {

	@Autowired
	private LeavesService service;
	
	
	@GetMapping("/leaves")
	public List<Leaves> getAllLeaves(){
		return service.getAllLeaves();
	}
	
	@PutMapping(path = "/leaves/{id}/acceptreject/{flag}",consumes = "application/json")
	public  Leaves rejectApproved(@RequestBody Leaves leave,@PathVariable int id,@PathVariable String flag){
	
		return service.rejectApproved(id, flag);
	}
	
	@GetMapping("/users/{id}/leaves")
	public List<Leaves> getAllLeavesByUserId(@PathVariable String id){
		//int temp=Integer.parseInt(id);
		return service.getAllLeavesByUserId(id);
	}
	
	@GetMapping("users/{id}/leaves/{l_id}")
	public ResponseEntity<?> getLeavesById(@PathVariable int l_id) {
		Optional<Leaves> leaves= service.getLeavesByIdUser(l_id);
		return leaves.map(response->ResponseEntity.ok().body(response))
			   .orElse(new ResponseEntity<Leaves>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/leaves/{l_id}")
	public Leaves getLeaveById(@PathVariable int l_id) {
		Leaves leaves= service.getLeavesById(l_id);
		return leaves;
	}
	
	@GetMapping("/users/{id}/leaves/active")
	public List<Leaves> getAllUserActiveLeaves(@PathVariable String id){
		return service.getAllUserActiveLeaves(id);
	}
	
	@GetMapping("/users/{id}/leaves/approved")
	public List<Leaves> getAllUserApprovedLeaves(@PathVariable String id){
		return service.getAllUserApprovedLeaves(id);
	}
	
	@GetMapping("/users/{id}/leaves/rejected")
	public List<Leaves> getAllUserRejectedLeaves(@PathVariable String id){
		return service.getAllUserRejectedLeaves(id);
	}
	
	@GetMapping("/leaves/active")
	public List<Leaves> getAllActiveLeaves(){
		return service.getAllActiveLeaves();
	}
	
	@GetMapping("/leaves/approved")
	public List<Leaves> getAllApprovedLeaves(){
		return service.getAllApprovedLeaves();
	}
	
	@GetMapping("/leaves/rejected")
	public List<Leaves> getAllRejectedLeaves(){
		return service.getAllRejectedLeaves();
	}

	
	@PostMapping(path = "/leaves/{typeid}",consumes = "application/json")
	public ResponseEntity<Leaves> applyLeaves(@Valid @RequestBody Leaves leaves,@PathVariable int typeid)throws URISyntaxException{
		Leaves result=service.applyLeaves(leaves,typeid);
		return ResponseEntity.created(new URI("/leaves"+result.getId())).body(result);

	}
	
	//employee with leaves
	@PostMapping(path = "/users/{id}/leaves/{typeid}",consumes = "application/json")
	public ResponseEntity<Leaves> applyEmployeeLeaves(@Valid @RequestBody Leaves leaves,@PathVariable String id,@PathVariable int typeid)throws URISyntaxException{
		Leaves result=service.applyLeavesUser(leaves,typeid,id);
		return ResponseEntity.created(new URI("/leaves"+result.getId())).body(result);
	}
	
	@PutMapping(path = "/leaves/{l_id}",consumes = "application/json")
	ResponseEntity<Leaves> updateLeaves(@Valid @RequestBody Leaves leaves,@PathVariable int l_id){
		//LeavesTrack result=service.updateLeaves(leaves,l_id);;
		Leaves result=service.applyLeaves(leaves,l_id);
		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping(path = "/users/{id}/leaves/{l_id}",consumes = "application/json")
	ResponseEntity<Leaves> updateLeavesByEmployeeId(@Valid @RequestBody Leaves leaves,@PathVariable int l_id,@PathVariable String id){
		//LeavesTrack result=service.updateLeaves(leaves,l_id);;
		leaves.setUsers(new Users(id));
		Leaves result=service.applyLeaves(leaves,l_id);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/users/{id}/leaves/{l_id}")
	ResponseEntity<?> deleteLeaves(@PathVariable int l_id){
		service.deleteLeaves(l_id);
		return ResponseEntity.ok().build();
	}
}
