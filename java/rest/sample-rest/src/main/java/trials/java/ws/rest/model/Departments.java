package trials.java.ws.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Departments {
	private static final List<Department> departments;
	static {
		departments = new ArrayList<>();
		Department d1 = new Department();
		d1.setId(1);
		d1.setName("IT");
		departments.add(d1);
		Department d2 = new Department();
		d2.setId(2);
		d2.setName("CS");
		departments.add(d2);
		Department d3 = new Department();
		d3.setId(3);
		d3.setName("HR");
		departments.add(d3);
	}

	public List<Department> getAll() {
		return departments;
	}

	public Department getOne(int id) {
		return departments.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
	}

	public void add(Department d) {
		departments.add(d);
	}

	public boolean remove(int id) {
		Department d = departments.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
		if (d != null) {
			return departments.remove(d);
		}
		return false;
	}

	public void edit(int id, Department newD) {
		Department d = departments.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
		if (d != null) {
			departments.get(departments.indexOf(d)).setName(newD.getName());
		}
	}
}
