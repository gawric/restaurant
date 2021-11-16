package com.restaran.restaran.service;

import com.restaran.restaran.model.CustomUser;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.service.serviceinterface.IServiceUserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class CustomDetailsService  implements UserDetailsService {

    @Autowired
    private IServiceUserDb serviceUserDb;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {

        try {
             CustomUser cUser = getCustom(serviceUserDb.findByUsername(username));
             return getCustomUser(cUser ,  username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }

    private CustomUser getCustomUser(CustomUser cUser , String username)
    {
        if(cUser == null) throw new UsernameNotFoundException("User " + username + " was not found in the database");
        return cUser;
    }

    private CustomUser getCustom(UserModel userEntity)
    {
        if(userEntity != null) return new CustomUser(userEntity);
        return null;
    }
    //тестовая учетка для админа
    private void addTestAdmin()
    {
        UserModel userModel = new UserModel();
            userModel.setCreatedata(LocalDateTime.now());
            userModel.setEmail("gawric@mail.ru");
            userModel.setFirstname("sunil");
            userModel.setUsername("gawric");
            userModel.setLastname("worms");
            userModel.setMyrole("ROLE_ADMIN");
            userModel.setPassword(passwordEncoder.encode("11111111"));
        serviceUserDb.saveUser(userModel);

    }

    //тестовая учетка для юзера
    private void addTestUser()
    {
        UserModel userModel = new UserModel();
        userModel.setCreatedata(LocalDateTime.now());
        userModel.setEmail("test@mail.ru");
        userModel.setFirstname("testfirst");
        userModel.setUsername("testuser");
        userModel.setLastname("testlast");
        userModel.setMyrole("ROLE_USER");
        userModel.setPassword(passwordEncoder.encode("11111111"));
        serviceUserDb.saveUser(userModel);

    }


}

