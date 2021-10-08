package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Animal;
import springdemo.util.SortUtils;

@Repository
public class AnimalDAOImplementation implements AnimalDAO {

	@Autowired///inject the session factory
	private SessionFactory sessionFactory;
	
	@Override
	public List<Animal> getAnimals(int sortField) {
		///get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// determine sort field
		String theFieldName = null;
				
		switch (sortField) {
			case SortUtils.NAME: 
				theFieldName = "name";
				break;
			case SortUtils.AGE:
				theFieldName = "age";
				break;
			default:
				// if nothing matches the default to sort by lastName
				theFieldName = "name";
			}
				
		// create a query  
		String queryString = "from Animal order by " + theFieldName;
		Query<Animal> theQuery = 
				currentSession.createQuery(queryString, Animal.class);
		
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

	@Override
	public List<Animal> searchAnimals(String theSearchName) {
		// get the current session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Animal where lower(name) like :theName", Animal.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Animal", Animal.class);            
        }
        
        // execute query and get result list
        List<Animal> animals = theQuery.getResultList();
                
        // return the results        
        return animals;
        
    }
}


