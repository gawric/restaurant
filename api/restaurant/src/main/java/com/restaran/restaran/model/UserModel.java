package com.restaran.restaran.model;



import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String myrole;


    //hibernate игнорирует поле
    @Transient
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

    @Column(name = "createdata", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdata;

    public LocalDateTime getCreatedata() {
        return createdata;
    }

    public void setGrantedAuthoritiesList(Collection<GrantedAuthority> grantedAuthoritiesList) {
        this.grantedAuthoritiesList = grantedAuthoritiesList;
    }

    public void setCreatedata(LocalDateTime createdata) {
        this.createdata = createdata;
    }

    public String getMyrole() {
        return myrole;
    }

    public void setMyrole(String myrole) {
        this.myrole = myrole;
    }


    public Collection<GrantedAuthority> getGrantedAuthoritiesList() {
        return grantedAuthoritiesList;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
