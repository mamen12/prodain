package com.test.prodain.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"status", "message", "refrence_data"})
public class UserResponse {
	
	private Boolean status;
	
	private String message;
	
	@JsonProperty(value = "refrence_data")
	private RefrenceDataEntity refrenceDataEntity;


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public RefrenceDataEntity getRefrenceDataEntity() {
		return refrenceDataEntity;
	}


	public void setRefrenceDataEntity(RefrenceDataEntity refrenceDataEntity) {
		this.refrenceDataEntity = refrenceDataEntity;
	}
	
	
	
}
