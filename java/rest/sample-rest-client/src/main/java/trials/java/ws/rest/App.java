package trials.java.ws.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import trials.java.ws.rest.model.Department;

public class App {
	public static void main(String[] args) {
		Client client = null;
		try {
			client = ClientBuilder.newClient();
			WebTarget resource = client.target("http://localhost:8080/sample-rest/api").path("departments");
			get(resource);
			System.out.println("getOne-----------------------------------------");
			getOne(resource, 2);
			System.out.println("post-------------------------------------------");
			Department department = new Department(4, "New");
			post(resource, department);
			get(resource);
			System.out.println("put--------------------------------------------");
			department.setName("SW");
			put(resource, department);
			get(resource);
			System.out.println("delete-----------------------------------------");
			delete(resource, 4);
			get(resource);
		} finally {
			if (client != null) {
				client.close();
			}
		}

	}

	private static void delete(WebTarget resource, int id) {
		resource = resource.path("" + id);
		Invocation deleteRequest = resource.request(MediaType.APPLICATION_JSON).buildDelete();
		deleteRequest.invoke();
	}

	private static void put(WebTarget resource, Department department) {
		resource = resource.path("" + department.getId());
		Invocation putRequest = resource.request(MediaType.APPLICATION_JSON)
				.buildPut(Entity.entity(department, MediaType.APPLICATION_JSON));
		putRequest.invoke();
	}

	private static void get(WebTarget resource) {
		Invocation getRequest = resource.request(MediaType.APPLICATION_JSON).buildGet();
		List<Department> result = getRequest.invoke(new GenericType<List<Department>>() {
		});
		for (Department department : result) {
			System.out.printf("Id:%d\tName:%s%n", department.getId(), department.getName());
		}
	}

	private static void post(WebTarget resource, Department department) {
		Invocation postRequest = resource.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(department, MediaType.APPLICATION_JSON));
		postRequest.invoke();
	}

	private static void getOne(WebTarget resource, int id) {
		resource = resource.path("" + id);
		Invocation getRequest = resource.request(MediaType.APPLICATION_JSON).buildGet();
		Department result = getRequest.invoke(Department.class);
		System.out.printf("Id:%d\tName:%s%n", result.getId(), result.getName());
	}
}
