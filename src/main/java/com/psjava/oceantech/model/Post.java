package com.psjava.oceantech.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.psjava.oceantech.dto.AuthorDTO;
import com.psjava.oceantech.dto.CommentDTO;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private String ocean;
	private String geoLocation;
	private String acidification;
	private String waterPh;
	private AuthorDTO author;
	
	private List<CommentDTO> audit = new ArrayList<>();
	
	public Post() {
	}

	public Post(String id, Date date, String ocean, String geoLocation, String acidification, String waterPh, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.ocean = ocean;
		this.geoLocation = geoLocation;
		this.acidification = acidification;
		this.waterPh = waterPh;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOcean() {
		return ocean;
	}

	public void setOcean(String ocean) {
		this.ocean = ocean;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public List<CommentDTO> getAudit() {
		return audit;
	}

	public void setAudit(List<CommentDTO> audit) {
		this.audit = audit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
