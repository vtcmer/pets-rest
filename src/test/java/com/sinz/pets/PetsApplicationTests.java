package com.sinz.pets;

import com.sinz.pets.model.Pet;
import com.sinz.pets.service.PetsRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetsApplicationTests {

	@Autowired
	private PetsRepository petsRepository;

	@Before
	public  void prepare(){
		this.petsRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
	}


	

	@Test
	public void savePet(){
		Pet pet = new Pet("boby","dog","Pastor Alemán");
		this.petsRepository.save(pet);
	}


}
