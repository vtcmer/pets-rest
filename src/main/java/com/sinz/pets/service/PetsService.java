package com.sinz.pets.service;

import com.sinz.pets.model.Pet;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

public interface PetsService {

	
    List<Pet> findAll();
    Pet getById(final String id);
    Pet findBySpecies(final String specie);
    void save(final Pet pet);
    void update(final Pet pet);
    void delete(final String id);
}
