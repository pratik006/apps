package com.prapps.travel.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="travel")
public class TravelComment implements Serializable {

	private static final long serialVersionUID = 3131509627652076280L;
	@Id
	private String id;
	private Long blogId;
	private String name;
	private String email;
	private String title;
	private String comment;
	private Date time;
	
	public TravelComment() {
		time = new Date();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TravelComment [id=" + id + ", blogId=" + blogId + ", name=" + name + ", email=" + email + ", title=" + title + ", comment=" + comment
				+ ", time=" + time + "]";
	}
	
}
