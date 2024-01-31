package com.test.prodain.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_user")
public class JobsUserInfo {
	
	@Id
	private String id;
	
	private String name;
	
	@Column(name = "start_at")
	private Date startAt;
	
	@Column(name = "until_at")
	private Date untilAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	public Date getUntilAt() {
		return untilAt;
	}

	public void setUntilAt(Date untilAt) {
		this.untilAt = untilAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
