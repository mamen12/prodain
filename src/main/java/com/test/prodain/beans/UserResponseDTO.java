package com.test.prodain.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.test.prodain.entity.DetailUserInfo;
import com.test.prodain.entity.JobsUserInfo;

@JsonPropertyOrder({"id", "name", "detail", "jobs", "created_by", "created_at", "updated_by", "updated_at", "deleted_by", "deleted_at"})
public class UserResponseDTO {

	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "username")
	private String name;
	
	@JsonProperty(value = "detail")
	private DetailUserInfo detailUser;
	
	@JsonProperty(value = "jobs")
	private List<JobsUserInfo> jobs;
	
	@JsonProperty(value = "created_by")
	private int createdBy;
	
	@JsonProperty(value = "created_at")
	private String createdAt;
	
	@JsonProperty(value = "updated_by")
	private int updatedBy;
	
	@JsonProperty(value = "updated_at")
	private String updatedAt;

	@JsonProperty(value = "deleted_by")
	private int deletedBy;
	
	@JsonProperty(value = "deleted_at")
	private String deletedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DetailUserInfo getDetailUser() {
		return detailUser;
	}

	public void setDetailUser(DetailUserInfo detailUser) {
		this.detailUser = detailUser;
	}

	public List<JobsUserInfo> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobsUserInfo> jobs) {
		this.jobs = jobs;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(int deletedBy) {
		this.deletedBy = deletedBy;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	
}
