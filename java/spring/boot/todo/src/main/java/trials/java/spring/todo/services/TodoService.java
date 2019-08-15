package trials.java.spring.todo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import trials.java.spring.todo.beans.Todo;

@Service
public class TodoService {
	private static int count;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(count++, "ahmed", "spring boot", LocalDate.of(2018, 12, 30)));
		todos.add(new Todo(count++, "ali", "spring mvc", LocalDate.of(2018, 12, 30)));
		todos.add(new Todo(count++, "magdy", "spring data", LocalDate.of(2018, 12, 30)));
		todos.add(new Todo(count++, "ahmed", "angular", LocalDate.of(2019, 1, 30)));
	}

	public void addTodo(String name, String title, LocalDate dueDate) {
		todos.add(new Todo(count++, name, title, dueDate));
	}

	public List<Todo> retriveTodos(String name) {
		return todos.stream().filter(t -> name.equals(t.getUser())).collect(Collectors.toList());
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = (Todo) iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}

}
