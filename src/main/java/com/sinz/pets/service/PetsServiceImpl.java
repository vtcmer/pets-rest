package com.sinz.pets.service;

import com.sinz.pets.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsRepository petsRepository;

    @Override
    public List<Pet> findAll() {
        return this.petsRepository.findAll();
    }

    @Override
    public Pet getById(String id) {
        return this.petsRepository.findOne(id);
    }

    @Override
    public Pet findBySpecies(String specie) {
        return null;
    }

    @Override
    public void save(Pet pet) {
         this.petsRepository.save(pet);
    }

    @Override
    public void update(Pet pet) {
        this.petsRepository.save(pet);
    }

    @Override
    public void delete(String id) {
        this.petsRepository.delete(id);
    }
}
