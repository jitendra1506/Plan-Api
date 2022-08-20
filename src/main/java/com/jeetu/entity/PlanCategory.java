package com.jeetu.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer id;

	@Column(name = "CATEGORY_NAME")
	private String catogryname;

	@Column(name = "CREATED_DATE" , updatable=false)
	@CreationTimestamp
	private LocalDate createdate;

	@Column(name = "UPDATED_DATE" , insertable=false)
	@UpdateTimestamp
	private LocalDate updateddate;

	@Column(name = "CREATED_BY")
	
	private String createby;

	@Column(name = "UPDATED_BY")
	private String updatedby;

	@Column(name = "ACTIVE_SW")
	private String activesw;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatogryname() {
		return catogryname;
	}

	public void setCatogryname(String catogryname) {
		this.catogryname = catogryname;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public LocalDate getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(LocalDate updateddate) {
		this.updateddate = updateddate;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getActivesw() {
		return activesw;
	}

	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}

}
