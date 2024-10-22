package com.tiagovieira.apiTodoSimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagovieira.apiTodoSimple.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    

    
} 
