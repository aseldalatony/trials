package trials.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import trials.java.hibernate.entities.Address;
import trials.java.hibernate.entities.Course;
import trials.java.hibernate.entities.Instructor;
import trials.java.hibernate.entities.Student;
import trials.java.hibernate.entities.StudentName;

public class App {
	public static void main(String[] args) {
//		StudentName name = new StudentName();
//		name.setFname("f1");
//		name.setLname("l1");
//
//		Student s1 = new Student(1, name, 21);
//		Student s2 = new Student(2, new StudentName("f2", "l2"), 22);
//
//		Address a1 = new Address(1, "Egy", "Ca");
//		a1.setStudent(s1);
//		Address a2 = new Address(2, "USA", "LA");
//		a2.setStudent(s2);
//
//		Instructor i1 = new Instructor(1, "i1");
//		Instructor i2 = new Instructor(2, "i2");
//
//		Course c1 = new Course(1, "Math");
//		Course c2 = new Course(2, "CS");
//		Course c3 = new Course(3, "English");
//
//		c1.setInstructor(i1);
//		c2.setInstructor(i1);
//		c3.setInstructor(i2);
//
//		s1.getCourses().add(c1);
//		s1.getCourses().add(c2);
//		s2.getCourses().add(c3);

		try (StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				SessionFactory factory = new MetadataSources(registry).addAnnotatedClass(Student.class)
						.addAnnotatedClass(Address.class).addAnnotatedClass(Course.class)
						.addAnnotatedClass(Instructor.class).buildMetadata().buildSessionFactory();
				Session session = factory.openSession();) {
			session.beginTransaction();
//			session.save(i1);
//			session.save(i2);
//			session.save(s1);
//			session.save(s2);
//			session.save(a1);
//			session.save(a2);
//			session.save(c1);
//			session.save(c2);
//			session.save(c3);
			Student x = session.get(Student.class, 1);
			System.out.println(x);
			System.out.println(x.getAddress());
			System.out.println(x.getCourses());
			
			Instructor i=session.get(Instructor.class, 2);
			System.out.println(i);
			System.out.println(i.getCourses());
			i.getCourses().stream().forEach(c->c.getStudents().stream().forEach(System.out::println));
			session.getTransaction().commit();
		}
	}
}
