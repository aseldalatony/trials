package trials.java.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	private int id;
	private String country;
	private String city;
	@OneToOne(fetch = FetchType.LAZY)
	private Student student;

	public Address() {
	}

	public Address(int id, String country, String city) {
		this.id = id;
		this.country = country;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", city=" + city + "]";
	}
}
