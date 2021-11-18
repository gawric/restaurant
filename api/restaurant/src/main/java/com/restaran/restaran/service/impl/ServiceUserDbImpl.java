package com.restaran.restaran.service.impl;

import com.restaran.restaran.exception.IncorrectUserNameException;
import com.restaran.restaran.exception.NotFoundUserException;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.repository.UserModelRepository;
import com.restaran.restaran.service.serviceinterface.IServiceUserDb;
import com.restaran.restaran.variable.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    //медленное добавление для вебки
    public ResponseEntity<Object> addUserWeb(UserModel newUser)
    {

      try
      {
          if(findExistByname(newUser.getUsername())) throw new IncorrectUserNameException("Username already in use");
          setLdT(newUser);
          setRoleUser(newUser);
          if(saveUser(newUser))return new ResponseEntity(HttpStatus.OK);
      }
      catch (IncorrectUserNameException e)
      {
          e.printStackTrace();
          return ErrorMessage.getResponceError("Username already in use");
      }


        return ErrorMessage.getResponceError("Unknown error");
    }

    private void setLdT(UserModel newUser)
    {
        if(newUser != null)
        {
            newUser.setCreatedata(LocalDateTime.now());
            newUser.setLastEnterdata(LocalDateTime.now());
        }

    }

    private void setRoleUser(UserModel newUser)
    {
        if(newUser != null)
            newUser.setMyrole("ROLE_USER");
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
    public boolean findExistByname(String name) {
        return userModelRepository.findExistByname(name);
    }

    @Override
    public ResponseEntity<Object> findByIdTWeb(long id) {

        try
        {
            UserModel user = findById(id);
            IsNull(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceError("Not found user exception");
        }

    }

    private void IsNull(UserModel user) throws NotFoundUserException {
        if(user == null) throw new NotFoundUserException("Not found user exception");
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
