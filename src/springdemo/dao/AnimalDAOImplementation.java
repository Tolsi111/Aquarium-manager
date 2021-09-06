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
		
		///create query ... sort by name
		Query<Animal> theQuery=
	            currentSession.createQuery("from Animal order by name", Animal.class);
		
		///execute and get customers
		List<Animal> animals = theQuery.getResultList();
		
		///return customers
		return animals;
	}

	@Override
	public void saveAnimal(Animal theAnimal) {
		///get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		///save or update if the PK is not null
		currentSession.saveOrUpdate(theAnimal);
	}

	@Override
	public Animal getAnimal(int theId) {
		///get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Animal.class,theId);
	}

	@Override
	public void deleteAnimal(int theId) {
		///get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		///delete object using primary key
		Query theQuery = currentSession.createQuery("delete from Animal where id=:animalId");
		theQuery.setParameter("animalId",theId);
		
		///execute query
		theQuery.executeUpdate();
		
	}

}
