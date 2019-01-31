package trials.java.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trials.java.ws.rest.model.Department;
import trials.java.ws.rest.model.Departments;

@Path("departments")
public class DepartmentService {
	private Departments d = new Departments();

	@Path("hello")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
		return "Hello, REST";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> findAllDepartments() {
		return d.getAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Department findDepartment(@PathParam("id") int id) {
		return d.getOne(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createDepartment(Department entity) {
		d.add(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editDepartment(@PathParam("id") Short id, Department entity) {
		d.edit(id, entity);
	}

	@DELETE
	@Path("{id}")
	public void removeDepartment(@PathParam("id") Short id) {
		d.remove(id);
	}
}
