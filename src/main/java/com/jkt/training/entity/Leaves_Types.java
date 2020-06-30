package com.jkt.training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Leaves_Types {

	@Id
	private int id;
	
	private String leave_name;
	
	private int max_count;

	public Leaves_Types() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leaves_Types(int id, String leave_name, int max_count) {
		super();
		this.id = id;
		this.leave_name = leave_name;
		this.max_count = max_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeave_name() {
		return leave_name;
	}

	public void setLeave_name(String leave_name) {
		this.leave_name = leave_name;
	}

	public int getMax_count() {
		return max_count;
	}

	public void setMax_count(int max_count) {
		this.max_count = max_count;
	}
}