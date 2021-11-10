package com.restaran.restaran.model;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;


    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdata;

    public LocalDateTime getCreatedata() {
        return createdata;
    }

    public void setCreatedata(LocalDateTime createdata) {
        this.createdata = createdata;
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
