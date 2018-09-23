package com.sinz.pets.controller;


import com.sinz.pets.model.Pet;
import com.sinz.pets.model.User;
import com.sinz.pets.service.PetsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PetsController {

    private static final Logger logger = LoggerFactory.getLogger(PetsController.class);

    @Autowired
    private PetsService petsService;

    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public  ResponseEntity<?> test(){
        logger.info("Invoke test method");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> findAll() {
        List<Pet> pets = this.petsService.findAll();
        return  ResponseEntity.ok(pets);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pet> getPet(@PathVariable ("id")  String id){

        final Pet pet = this.petsService.getById(id);
        if  (pet != null) {
            return ResponseEntity.ok(pet);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Pet> create(@RequestBody Pet pet){
        this.petsService.save(pet);
        return ResponseEntity.ok(pet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pet> update(@PathVariable("id") String id, @RequestBody Pet pet){
        pet.setId(id);
        this.petsService.save(pet);
        return ResponseEntity.ok(pet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        this.petsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
