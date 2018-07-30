package com.sinz.pets;

import com.sinz.pets.model.Pet;
import com.sinz.pets.dao.PetsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetsApplicationTests {

	@Autowired
	private PetsRepository petsRepository;

	@Before
	public  void prepare(){
		//this.petsRepository.deleteAll();
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void findBySpecies(){

		List<Pet> pets = this.petsRepository.findBySpeciesNameQuery("cat");
		assertNotNull(pets);
		assertEquals(2,pets.size());
	}

	@Test
	public void findBySpeciesAndBreeds(){

		List<Pet> pets = this.petsRepository.findBySpeciesAndBreedsQuery("dog","coker");
		assertNotNull(pets);
		assertEquals(1,pets.size());
	}

	//@Test
	public void savePet(){
		//Pet pet = new Pet("boby","dog","Pastor Alemán");
		List<Pet> pets = this.prepareMockPetsToSave();
		assertNotNull(pets);
		int cont = 0;
		for (Pet pet:pets) {
			this.petsRepository.save(pet);
			cont++;
		}

		assertTrue(cont == pets.size());
	}


	private List<Pet> prepareMockPetsToSave(){

		// -- se borra todo para hacer el preparado
		this.petsRepository.deleteAll();

		List<Pet> items = new ArrayList<Pet>();

		Pet pet = new Pet("boby","dog","Pastor Alemán");
		items.add(pet);

		pet = new Pet("lulu","dog","Pastor Alemán");
		items.add(pet);

		pet = new Pet("peti","dog","coker");
		items.add(pet);

		pet = new Pet("billy","cat","común");
		items.add(pet);

		pet = new Pet("susy","cat","siames");
		items.add(pet);

		return items;
	}


}
