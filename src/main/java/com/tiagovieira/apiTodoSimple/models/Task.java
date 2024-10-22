package com.tiagovieira.apiTodoSimple.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name = Task.TABLE_TASK)
public class Task {
    final static String TABLE_TASK = "task";

    @Id
    @Column(name = "task", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", length = 255, nullable = false)
    @NotBlank
    @Size(min = 2, max = 255)
    private Long descricao;

     @ManyToOne
     @JoinColumn(name = "user_id", nullable = false, unique = false)
    private User user;




    public Task() {
    }


    public Task(Long id, Long descricao, User user) {
        this.id = id;
        this.descricao = descricao;
        this.user = user;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDescricao() {
        return this.descricao;
    }

    public void setDescricao(Long descricao) {
        this.descricao = descricao;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    


    

    
    
}
