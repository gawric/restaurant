package com.restaran.restaran.service;

import com.restaran.restaran.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class OAuthDao {

    public UserModel getUserDetails(String username) {
             Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthoritiesList.add(grantedAuthority);
            UserModel model = new UserModel();
            model.setGrantedAuthoritiesList(grantedAuthoritiesList);
            return model;

    }
}
