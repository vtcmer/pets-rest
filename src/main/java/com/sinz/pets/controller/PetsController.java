package com.sinz.pets.controller;


import com.sinz.pets.model.Pet;
import com.sinz.pets.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PetsController {

    @Autowired
    private PetsService petsService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("It is OK");
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
    public ResponseEntity<Pet> create(@PathVariable("id") String id, @RequestBody Pet pet){
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
