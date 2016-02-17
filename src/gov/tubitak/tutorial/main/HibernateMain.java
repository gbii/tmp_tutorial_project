   package gov.tubitak.tutorial.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import gov.tubitak.tutorial.hibernate.entities.Department;
import gov.tubitak.tutorial.hibernate.entities.Student;
import gov.tubitak.tutorial.hibernate.entities.Teacher;
import gov.tubitak.tutorial.hibernate.entities.Tmp;

public class HibernateMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/gov/tubitak/tutorial/hibernate/configuration/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		
		Student std = new Student(9756524);
		std.setName("Tunç");
		std.setSurname("Gürsoy");
		//saveDBObject(sf, std);
		
		Teacher teacher = new Teacher(201);
		teacher.setName("Nuriye");
		teacher.setSurname("Sütlü");
		//saveDBObject(sf, teacher);
		
		Tmp tmp = new Tmp();
		tmp.setName("Diego");
		saveDBObject(sf, tmp);
		//updateDBObject(sf, tmp);
		//deleteDBObject(sf, tmp);
		
		printObjects("Tmp", getObjects(sf, "Tmp"));;
		
		sf.close();
	}
	
	public static void saveDBObject(SessionFactory sf, Object obj){
		Session s = sf.openSession();
		s.beginTransaction();
		//Tmp tmp = (Tmp) s.get(Tmp.class, 37);
		s.save(obj);
		//((Tmp) obj).setName("Cemal");
		s.getTransaction().commit();
		s.close();
	}

	public static void deleteDBObject(SessionFactory sf, Object obj){
		Session s = sf.openSession();
		s.beginTransaction();
		s.delete(obj);
		s.getTransaction().commit();
		s.close();
	}

	public static void updateDBObject(SessionFactory sf, Object obj){
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(obj);
		s.getTransaction().commit();
		s.close();
	}

	public static List<?> getObjects(SessionFactory sf, String tableName){
		Session s = sf.openSession();
		Query q = s.createQuery("From " + tableName + " s");
		List<?> list = q.list();
		s.close();
		return list;
	}

	public static void printObjects(String entityName, List<?> list){
		System.out.println("-----------------------------------");
		System.out.println("Objects from " + entityName + " tables");
		System.out.println("-----------------------------------");
		if (!list.isEmpty())
			for (Object obj : list) {
				Class<?> objClass = obj.getClass();
				if (objClass.getName().equals(Student.class.getName())){
					Student item = (Student) obj;
					System.out.println("Id : " + item.getId());
					System.out.println("Name : " + item.getName());
					System.out.println("Surname : " + item.getSurname());
					System.out.println("Deparment : " + item.getDepartment());
				}else if (objClass.getName().equals(Teacher.class.getName())){
					Teacher item = (Teacher) obj;
					System.out.println("Id : " + item.getId());
					System.out.println("Name : " + item.getName());
					System.out.println("Surname : " + item.getSurname());
				}else if (objClass.getName().equals(Department.class.getName())){
					Department item = (Department) obj;
					System.out.println("Id : " + item.getId());
					System.out.println("Name : " + item.getName());
				}else if (objClass.getName().equals(Tmp.class.getName())){
					Tmp item = (Tmp) obj;
					System.out.println("Id : " + item.getId());
					System.out.println("Name : " + item.getName());
					System.out.println("Surname : " + item.getSeqId());
				}
			}
		System.out.println("-----------------------------------");
	}
}
