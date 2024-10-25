package services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagovieira.apiTodoSimple.models.User;
import com.tiagovieira.apiTodoSimple.repositories.TaskRepository;
import com.tiagovieira.apiTodoSimple.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    
    public User findById(Long id) {
        //Pode ou receber o objeto, e caso não tenha nada, retorna vazio ao invés de null, evitando o erro de nullPointerExeption
        Optional<User> user = this.userRepository.findById(id);

        //Retorna o usuario se ele tiver preenchido, mas se estiver vazio lança uma exceção 
        return user.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id:  " + id + ", Tipo: " + User.class.getName()
        ));
        


    }

    @Transactional
    public User create(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        this.taskRepository.saveAll(obj.getTasks());
        return obj;
        

    }

    @Transactional
    public User updade(User obj) {
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);


    }

    public void delete(Long id) {
        findById(id);

        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois há entidades relacionadas!");

        }

    }








}
