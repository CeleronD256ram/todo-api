package com.tiagovieira.apiTodoSimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagovieira.apiTodoSimple.models.Task;
import java.util.List;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findByUser(Long id);

    
} 
