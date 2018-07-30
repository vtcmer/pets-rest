package com.sinz.pets.dao;

import com.sinz.pets.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


    User findByUserName(final String userName);

}
