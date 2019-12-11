package com.AwsServices.AwsServices;

public class placeholder {

	public int userId;
	public int id;
	public String title;
	public String body;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "placeholder [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}

}
