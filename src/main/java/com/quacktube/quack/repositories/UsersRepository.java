package com.quacktube.quack.repositories;

import com.quacktube.quack.models.UsersModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends MongoRepository<UsersModel, String> {
    UsersModel findByUsername(String username);
    UsersModel findByEmail(String email);
}
