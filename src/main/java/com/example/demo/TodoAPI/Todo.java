
package com.example.demo.TodoAPI;

public class Todo {
	public Todo(Boolean completed, Integer id, String title, Integer userId) {
		this.completed = completed;
		this.id = id;
		this.title = title;
		this.userId = userId;
	}

	private Boolean completed;
	private Integer id;
	private String title;
	private Integer userId;

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "Todo{" +
				"completed=" + completed +
				", id=" + id +
				", title='" + title + '\'' +
				", userId=" + userId +
				'}';
	}
}

