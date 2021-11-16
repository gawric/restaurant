package com.restaran.restaran.repository;

import com.restaran.restaran.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserModelRepository extends CrudRepository<UserModel, String> {
    UserModel findByUsername(String username);
    UserModel findById(long id);
}
