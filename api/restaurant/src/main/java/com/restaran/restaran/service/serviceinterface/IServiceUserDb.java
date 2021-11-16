package com.restaran.restaran.service.serviceinterface;

import com.restaran.restaran.model.UserModel;

public interface IServiceUserDb {
    UserModel findByUsername(String username);
    UserModel findById(long id);
    void saveUser(UserModel userm);
}
