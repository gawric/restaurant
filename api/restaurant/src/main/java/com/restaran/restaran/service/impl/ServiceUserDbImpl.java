package com.restaran.restaran.service.impl;

import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.repository.UserModelRepository;
import com.restaran.restaran.service.serviceinterface.IServiceUserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("IServiceUserDb")
public class ServiceUserDbImpl implements IServiceUserDb {

    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    public UserModel findByUsername(String username) {
        UserModel userm = userModelRepository.findByUsername(username);
        addRoleMap(userm);
        return userm;
    }

    @Override
    public UserModel findById(long id) {
        return userModelRepository.findById(id);
    }
    public void saveUser(UserModel userm)
    {
        userModelRepository.save(userm);
    }

    private void addRoleMap(UserModel userm)
    {
        if(userm == null) return;

        String myrole = userm.getMyrole();
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(myrole);
        grantedAuthoritiesList.add(grantedAuthority);
        userm.setGrantedAuthoritiesList(grantedAuthoritiesList);

    }
}
