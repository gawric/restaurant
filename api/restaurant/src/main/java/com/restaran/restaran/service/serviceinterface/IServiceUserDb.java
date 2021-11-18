package com.restaran.restaran.service.serviceinterface;

import com.restaran.restaran.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface IServiceUserDb {
    UserModel findByUsername(String username);
    UserModel findById(long id);
    boolean saveUser(UserModel userm);
    boolean findExistByname(String name);
    ResponseEntity<Object> findByIdTWeb(long id);
    ResponseEntity<Object> addUserWeb(UserModel newUser);
}
