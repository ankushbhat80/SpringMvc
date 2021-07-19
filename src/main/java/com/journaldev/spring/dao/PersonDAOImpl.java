package com.journaldev.spring.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;


//commit from feature
//commit from master

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM Person";
		List<Object[]> personsList = session.createSQLQuery(sql).list();
		for(Object p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
	
	@Override
	public List listPersons1(){
		Session session = this.sessionFactory.getCurrentSession();
		//String sql = "select * from Emp e where e.id = :id";
		String sql = "select * from Demo";
		//Query query = session.createSQLQuery(sql).setParameter("id",1);
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		return list;
	}

	@Override
	public void hibernateEntityChecking(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.flush();
		int id = (Integer) session.save(p);
		
		System.out.println("Id is "+id);
		
		
	}

	@Override
	public void createDynamicQuery(final List<String> list) {
		Session session = this.sessionFactory.getCurrentSession();
		
			
            session.doWork(new Work(){
             
			@Override
			public void execute(Connection connection) throws SQLException {
			   Statement s = null;
				try{	
					s = connection.createStatement();
					int batchsize = 1000;
					int count = 0;
					for(String query:list){
						s.addBatch(query);
						if(batchsize%++count==0){
							s.executeBatch();
						}
					}
					s.executeBatch();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					s.close();
				}
			}
            
                   
            });
			
		
	}

}
