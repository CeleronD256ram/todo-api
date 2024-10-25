package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagovieira.apiTodoSimple.models.User;
import com.tiagovieira.apiTodoSimple.repositories.TaskRepository;
import com.tiagovieira.apiTodoSimple.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    
    public User findById(Long id)








}
