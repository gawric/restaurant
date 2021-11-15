package com.restaran.restaran.service;

import com.restaran.restaran.model.CustomUser;
import com.restaran.restaran.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsService  implements UserDetailsService {

    @Override
    public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {

        try {
            UserModel userEntity  = getAuthDao().getUserDetails("username");
            return  new CustomUser(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");

        }
    }

    private OAuthDao getAuthDao()
    {
        return new OAuthDao();
    }
}

