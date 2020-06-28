package com.jkt.training.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Users_Leaves_Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private int taken;
	@ManyToOne
	private Users users;
	
	@ManyToOne
	private Leaves_Types types;

	public Users_Leaves_Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users_Leaves_Track(int id, int taken, Users users, Leaves_Types types) {
		super();
		this.id = id;
		this.taken = taken;
		this.users = users;
		this.types = types;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Leaves_Types getTypes() {
		return types;
	}

	public void setTypes(Leaves_Types types) {
		this.types = types;
	}
	
}
