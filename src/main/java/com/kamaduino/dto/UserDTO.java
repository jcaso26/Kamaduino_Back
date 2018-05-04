package com.kamaduino.dto;

public class UserDTO {

    private Long id;

    private String user;

    private String pass;

    public UserDTO(Long id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public UserDTO(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
