package springdemo.dao;

import java.util.List;

import springdemo.entity.Animal;

public interface AnimalDAO {

	public List<Animal> getAnimals(int sortField);

	public void saveAnimal(Animal theAnimal);

	public Animal getAnimal(int theId);

	public void deleteAnimal(int theId);

	public List<Animal> searchAnimals(String theSearchName);
}
