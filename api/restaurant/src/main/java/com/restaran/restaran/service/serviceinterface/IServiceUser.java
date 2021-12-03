package com.restaran.restaran.service.serviceinterface;

import com.restaran.restaran.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface IServiceUser {
    ResponseEntity<Object> findByIdTWeb(long id);
    ResponseEntity<Object> addUserWeb(UserModel newUser);
    ResponseEntity<Object> updUserWeb(UserModel newUser);
    ResponseEntity<Object> delUserWeb(long id);
    ResponseEntity<Object> selfUpdUserWeb(String authUsername , UserModel newUser);
    //true blocked
    //false unblocked
    ResponseEntity<Object> blockUserWeb(long userId , boolean isBlock);

}
