package com.tiagovieira.apiTodoSimple.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public final static String TABLE_NAME = "user";

    public interface createUsername{}
    public interface updateUser{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "username", length = 60, nullable = false, unique = true)
    @NotNull(groups = createUsername.class)
    @NotEmpty(groups = createUsername.class)
    @Size(groups = createUsername.class, min = 5, max = 60)
    private String username;

    
    @Column(name = "password", length = 60, nullable = false, unique = true)
    @NotNull(groups = {createUsername.class, updateUser.class})
    @NotEmpty(groups = {createUsername.class, updateUser.class})
    @Size(groups = {createUsername.class, updateUser.class}, min = 8, max = 50)
    private String password;


    public User() {
    }


    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



   

    




    


}

