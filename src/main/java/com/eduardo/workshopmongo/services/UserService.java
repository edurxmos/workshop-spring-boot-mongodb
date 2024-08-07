package com.eduardo.workshopmongo.services;

import com.eduardo.workshopmongo.domain.User;
import com.eduardo.workshopmongo.dto.UserDTO;
import com.eduardo.workshopmongo.exception.ObjectNotFoundException;
import com.eduardo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void deleteById(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public void upadateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public void update(User obj) {
        User newObj = findById(obj.getId());
        upadateData(newObj, obj);
        repo.save(newObj);
    }

}
