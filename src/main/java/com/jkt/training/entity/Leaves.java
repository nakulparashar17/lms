package com.jkt.training.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Leaves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Leaves_Types type;
	private String reason;
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;
	private int duration;
	private boolean acceptRejectFlag;
	private int taken;
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Users users;
	
	public Leaves() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leaves(int id, Leaves_Types type, String reason, Date fromDate, Date toDate, int duration,
			boolean acceptRejectFlag, int taken, boolean active, Users users) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.duration = duration;
		this.acceptRejectFlag = acceptRejectFlag;
		this.taken = taken;
		this.active = active;
		this.users = users;
	}
	
	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Leaves_Types getType() {
		return type;
	}

	public void setType(Leaves_Types type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAcceptRejectFlag() {
		return acceptRejectFlag;
	}

	public void setAcceptRejectFlag(boolean acceptRejectFlag) {
		this.acceptRejectFlag = acceptRejectFlag;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Leaves [id=" + id + ", type=" + type + ", reason=" + reason + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", duration=" + duration + ", acceptRejectFlag=" + acceptRejectFlag + ", active=" + active
				+ ", users=" + users + "]";
	}

}
