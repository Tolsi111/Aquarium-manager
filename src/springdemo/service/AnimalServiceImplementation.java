package springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdemo.dao.AnimalDAO;
import springdemo.entity.Animal;

@Service
public class AnimalServiceImplementation implements AnimalService {

	///inject animal dao
	@Autowired
	private AnimalDAO animalDao;
	
	@Override
	@Transactional
	public List<Animal> getAnimals(int sortField) {
		return animalDao.getAnimals(sortField);	
	}

	@Override
	@Transactional
	public void saveAnimal(Animal theAnimal) {
		animalDao.saveAnimal(theAnimal);
	}

	@Override
	@Transactional
	public Animal getAnimal(int theId) {
		return animalDao.getAnimal(theId);
	}

	@Override
	@Transactional
	public void deleteAnimal(int theId) {
		animalDao.deleteAnimal(theId);		
	}

	@Override
	@Transactional
	public List<Animal> searchAnimals(String theSearchName) {
		return animalDao.searchAnimals(theSearchName);
	}

}
