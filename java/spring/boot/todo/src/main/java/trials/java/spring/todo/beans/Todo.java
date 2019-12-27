package trials.java.spring.todo.beans;

import java.time.LocalDate;

public class Todo {
	int id;
	private String user;
	private String title;
	private LocalDate dueDate;

	public Todo() {
	}

	public Todo(int id, String user, String title, LocalDate dueDate) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
