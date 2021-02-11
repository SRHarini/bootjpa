package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Employee Object")

@Entity
public class Emp {
	
	@Id 
	@ApiModelProperty(notes="This is Unique ID")
	private int aid;
	@ApiModelProperty(notes="This is Employee's name")

	private String aname;
	@ApiModelProperty(notes="This is Employee's Domain")

	private String tech;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Emp [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
	}

}
