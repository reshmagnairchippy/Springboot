package com.spingworkapps.sampletask.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="simpdemo")
public class Tasks {
	
	public static final String SEQUENCE_NAME="Task_Sequences";
	
	@Id
	private int id;
	private String tname,status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String toString() {
		return "Tasks[id: "+id+", Tname: "+tname+" , Status: "+status+" ]";
	}
	
}
