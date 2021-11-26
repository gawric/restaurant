package com.restaran.restaran.service.impl.user;

import com.restaran.restaran.exception.IncorrectUserNameException;
import com.restaran.restaran.exception.NoAccessEditingUserException;

import com.restaran.restaran.exception.NotFoundUserException;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.service.serviceinterface.IServiceUser;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceUserDb;
import com.restaran.restaran.variable.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
//слой проверки данных и отправка ошибок
@Service("IServiceUser")
public class ServiceUser implements IServiceUser {

    //работа с базой
    @Autowired
    private IServiceUserDb serviceUserDb;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<Object> findByIdTWeb(long id) {

        try
        {
            UserModel user = serviceUserDb.findById(id);
            sNull(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found user exception", HttpStatus.NOT_FOUND);
        }

    }



    @Override
    public ResponseEntity<Object> updUserWeb(UserModel newUser) {
        try
        {
            //проверка что у казан id номер
            sNullId(newUser);

            UserModel user = serviceUserDb.findById(newUser.getId());
            sNull(user);

            serviceUserDb.saveUser(newUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found user exception", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Object> delUserWeb(long id) {
        try
        {
            //проверка что указан id номер
            if(!serviceUserDb.findExistById(id)) throw new NotFoundUserException("Id number not found");
            serviceUserDb.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NotFoundUserException e)
        {
            e.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Id number not found" , HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Object> selfUpdUserWeb(String authUsername , UserModel newUser) {
        try
        {
            UserModel userModel = serviceUserDb.findByUsername(authUsername);
            if(userModel == null) throw new NotFoundUserException("Not found user exception");
            if(!userModel.getUsername().equals(authUsername)) throw  new NoAccessEditingUserException("No access to user editing");
            if(newUser.getId() != userModel.getId()) throw  new NoAccessEditingUserException("No access to user editing");

            serviceUserDb.saveUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
        catch(NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Id number not found" , HttpStatus.NOT_FOUND);
        } catch (NoAccessEditingUserException e) {
            e.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("No access to user editing" , HttpStatus.FORBIDDEN);
        }

    }


    //медленное добавление для вебки
    public ResponseEntity<Object> addUserWeb(UserModel newUser)
    {

        try
        {
            if(serviceUserDb.findExistByname(newUser.getUsername())) throw new IncorrectUserNameException("Username already in use");
            setLdT(newUser);
            setRoleUser(newUser);
            decodePassword(newUser);
            if(serviceUserDb.saveUser(newUser))return new ResponseEntity(HttpStatus.OK);
        }
        catch (IncorrectUserNameException e)
        {
            e.printStackTrace();
            return ErrorMessage.getResponceError("Username already in use");
        }


        return ErrorMessage.getResponceError("Unknown error");
    }


    private void decodePassword(UserModel newUser)
    {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
    }
    private void sNull(UserModel user) throws NotFoundUserException {
        if(user == null) throw new NotFoundUserException("Not found user exception");
    }
    private void sNullId(UserModel user) throws NotFoundUserException {
        if(user.getId() == null) throw new NotFoundUserException("id number not defined");
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
}
