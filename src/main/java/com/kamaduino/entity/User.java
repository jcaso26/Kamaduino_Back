package com.kamaduino.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "encryted_password")
    private String passwordEncrypted;

    @Column(name = "enabled")
    private boolean enabled;

    public User(){
    }

    public User(Long id, String userName, String passwordEncrypted, boolean enabled) {
        this.id = id;
        this.userName = userName;
        this.passwordEncrypted = passwordEncrypted;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
