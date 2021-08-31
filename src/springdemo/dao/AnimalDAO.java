package springdemo.dao;

import java.util.List;

import springdemo.entity.Animal;

public interface AnimalDAO {

	public List<Animal> getAnimals();

	public void saveAnimal(Animal theAnimal);
}
