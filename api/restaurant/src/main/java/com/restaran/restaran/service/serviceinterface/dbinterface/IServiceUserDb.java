package com.restaran.restaran.service.serviceinterface.dbinterface;

import com.restaran.restaran.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface IServiceUserDb {
    UserModel findByUsername(String username);
    UserModel findById(long id);
    boolean saveUser(UserModel userm);
    boolean findExistByname(String name);
    boolean deleteUser(long id);
    boolean findExistById(long id);


}
