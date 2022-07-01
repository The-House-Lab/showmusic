package br.com.showmusic.app.model;

import br.com.showmusic.app.enums.EnumUserType;


import javax.persistence.*;

@Entity
public class UserLogin {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private EnumUserType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EnumUserType type() {
        return type;
    }

    public void setType(EnumUserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", type=" + type +
                '}';
    }


}

