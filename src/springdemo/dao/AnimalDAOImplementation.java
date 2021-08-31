package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Animal;

@Repository
public class AnimalDAOImplementation implements AnimalDAO {

	@Autowired///inject the session factory
	private SessionFactory sessionFactory;
	
	@Override
	public List<Animal> getAnimals() {
		///get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		///create query
		Query<Animal> theQuery=
	            currentSession.createQuery("from Animal", Animal.class);
		
		///execute and get customers
		List<Animal> animals = theQuery.getResultList();
		
		///return customers
		return animals;
	}

}
