package com.sinz.pets.service;

import com.sinz.pets.model.Pet;

import java.util.List;

public interface PetsService {

    List<Pet> findAll();
    Pet getById(final String id);
    Pet findBySpecies(final String specie);
    void save(final Pet pet);
    void update(final Pet pet);
    void delete(final String id);
}
