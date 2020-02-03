package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

 // GETTER FOR USERNAME
    public String getUsername() {
        return username;
    }
// NO ARG CONSTRUCTOR
    public User() {
    }

 // BCRYPT ENCODER

    private static final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

// CONSTRUCTOR -PASSWORD ARGUMENT- ENCODE PASSWORD FIELD
    public User(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }
// METHOD TO CHECK PASSWORDMATCH
    public boolean isMatchingPassword(String password){
        return encoder.matches(password,pwHash);
    }

}
