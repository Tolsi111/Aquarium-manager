package springdemo.service;

import java.util.List;

import springdemo.entity.Animal;

public interface AnimalService {

	public List<Animal> getAnimals();

	public void saveAnimal(Animal theAnimal);

	public Animal getAnimal(int theId);

	public void deleteAnimal(int theId);
}
