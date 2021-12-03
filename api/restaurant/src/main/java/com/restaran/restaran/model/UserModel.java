package com.restaran.restaran.model;



//import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@ApiModelProperty(notes = "Имя пользователя",name="name",required=true,value="gawric")
    @NotEmpty(message = "username не может быть пустым")
    @Size(min=2, message="username не может быть короче 2 символов")
    private String username;

    @NotEmpty(message = "password не может быть пустым")
    @Size(min=8, message="password не может быть короче 8 символов")
    private String password;

    @NotEmpty(message = "firstname не может быть пустым")
    @Size(min=2, message="firstname не может быть короче 2 символов")
    private String firstname;

    @NotEmpty(message = "lastname не может быть пустым")
    @Size(min=2, message="lastname не может быть короче 2 символов")
    private String lastname;

    @Email
    private String email;

    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;

    //@ApiModelProperty(notes = "Роль пользователя в системе безопасности",name="name",required=true,value="ROLE_USER")
    @NotEmpty(message = "myrole не может быть пустым")
    @Size(min=2, message="myrole не может быть короче 2 символов")
    private String myrole;


   // @ApiModelProperty(notes = "Список ролей пользователя. Не используется из внешних запросов!",name="name",required=true,value="GrantedAuthority")
    //hibernate игнорирует поле
    @Transient
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

    @Column(name = "createdata", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdata;



    @Column(name = "lastenterdata", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastenterdata;

    @Override
    public String toString() {
        return "User [name=" + username + ", firstname=" + firstname + ", myrole=" + myrole + "]";
    }

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
    public LocalDateTime getLastEnterdata() {
        return lastenterdata;
    }

    public void setLastEnterdata(LocalDateTime lastenterdata) {
        this.lastenterdata = lastenterdata;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserModel userEquals = (UserModel) o;
        return id == userEquals.getId() &&
                userEquals.getUsername().equals(username);
    }

    @Override
    public int hashCode() {
        return  (int)id * username.hashCode() * password.hashCode() * firstname.hashCode()* lastname.hashCode()* email.hashCode();
    }


}
