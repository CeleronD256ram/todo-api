package com.tiagovieira.apiTodoSimple.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    final static String TABLE_NAME = "user";

    public interface createUsername {}
    public interface update {}

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 60, nullable = false, unique = true)
    @NotBlank
    @Size(min = 5, max = 25)
    private String username;

    @Column(name = "password", length = 60, nullable = false, unique = true)
    @NotBlank
    @Size(min = 5, max = 25)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks; // Mudança aqui para List<Task>

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

    public List<Task> getTasks() { // Aqui também alterado para List<Task>
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) { // Aqui também alterado para List<Task>
        this.tasks = tasks;
    }
}
