package com.sinz.pets.dao;

import com.sinz.pets.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends MongoRepository<Pet,String> {

    @Query("{species : ?0}")
    List<Pet> findBySpeciesNameQuery(final String speciesName);

    @Query("{species : ?0, breeds: ?1}")
    List<Pet> findBySpeciesAndBreedsQuery(final String species, final String breeds);
}
