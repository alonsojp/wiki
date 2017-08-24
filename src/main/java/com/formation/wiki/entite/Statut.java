package com.formation.wiki.entite;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Statut {

	@Id @GeneratedValue
	private Integer id;
	private Boolean published;
	private Boolean waitingForValidation;
	private Boolean reportedAsAbused;
	
	/*
	 * Constructeur
	 */
	public Statut() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Boolean getWaitiingForValidation() {
		return waitingForValidation;
	}

	public void setWaitiingForValidation(Boolean waitiingForValidation) {
		this.waitingForValidation = waitiingForValidation;
	}

	public Boolean getReportedAsAbused() {
		return reportedAsAbused;
	}

	public void setReportedAsAbused(Boolean reportedAsAbused) {
		this.reportedAsAbused = reportedAsAbused;
	}

}
