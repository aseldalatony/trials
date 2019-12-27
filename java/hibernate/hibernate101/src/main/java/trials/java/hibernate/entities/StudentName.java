package trials.java.hibernate.entities;

import javax.persistence.Embeddable;

@Embeddable
public class StudentName {
	private String fname;
	private String lname;

	public StudentName() {
	}

	public StudentName(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "StudentName [fname=" + fname + ", lname=" + lname + "]";
	}
}
