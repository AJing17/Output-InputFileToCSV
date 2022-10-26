package dao;

import java.util.ArrayList;

import animal.animalfile;

public interface AnimalAdoptDao {
	//操作CRUD
	
	//Create
	void createAnimalFile(animalfile animal);
	
	//Read
	//全部
	ArrayList<animalfile> findAnimals();
	
	//特定id
	animalfile findAnimalById(int id);
	//特定種類
	ArrayList<animalfile> findAnimalsByKind(String kind);
	
	//update
	void updateAnimal(int animal_id,animalfile animal);
	
	//delete
	void deleteAnimal(animalfile animal);
	
	
	
	

}
