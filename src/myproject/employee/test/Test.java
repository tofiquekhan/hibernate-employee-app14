package myproject.employee.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import myproject.employee.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("/myproject/employee/resources/hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee emp = (Employee) session.get(Employee.class, "102");
			System.out.println("--------------------Employee Detail---------------");
			System.out.println("Employee No : "+emp.getEno());
			System.out.println("Employee Name : "+emp.getEname());
			System.out.println("Employee Salary : "+emp.getEsal());
			System.out.println("Employee Address : "+emp.getEaddr());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
		
		
	}
}
