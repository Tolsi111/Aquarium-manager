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
	public List<Animal> getAnimals() {
		return animalDao.getAnimals();
	}

}
