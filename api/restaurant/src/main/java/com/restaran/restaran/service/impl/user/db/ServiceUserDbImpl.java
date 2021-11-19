package com.restaran.restaran.service.impl.user.db;


import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.repository.UserModelRepository;
import com.restaran.restaran.service.serviceinterface.IServiceUserDb;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Transactional
@Service("IServiceUserDb")
public class ServiceUserDbImpl implements IServiceUserDb {

    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    @Transactional(readOnly = true)
    public UserModel findByUsername(String username) {
        UserModel userm = userModelRepository.findByUsername(username);
        addRoleMap(userm);
        return userm;
    }

    @Override
    @Transactional(readOnly = true)
    public UserModel findById(long id) {
        return userModelRepository.findById(id);
    }


    @Override
    public boolean saveUser(UserModel userm)
    {
        if(userm != null)
        {
            userModelRepository.save(userm);
            return true;
        }

        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean findExistByname(String name) {
        return userModelRepository.findExistByname(name);
    }


    @Override
    public boolean deleteUser(long id) {
        userModelRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean findExistById(long id) {
        return userModelRepository.findExistById(id);
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
