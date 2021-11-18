package com.psjava.oceantech.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String acidification;
	private String waterPh;
	private Date date;
	private AuthorDTO author;
	
	public CommentDTO() {
	}

	public CommentDTO(String acidification, String waterPh, Date date, AuthorDTO author) {
		super();
		this.acidification = acidification;
		this.waterPh = waterPh;
		this.date = date;
		this.author = author;
	}

	public String getAcidification() {
		return acidification;
	}

	public void setAcidification(String acidification) {
		this.acidification = acidification;
	}

	public String getWaterPh() {
		return waterPh;
	}

	public void setWaterPh(String waterPh) {
		this.waterPh = waterPh;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
