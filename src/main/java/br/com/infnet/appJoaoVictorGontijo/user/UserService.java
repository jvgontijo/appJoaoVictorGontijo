package br.com.infnet.appJoaoVictorGontijo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void add(User user) {
        this.repository.save(user);
    }

    public void remove(UUID id) {
        Optional<User> user = this.repository.findById(id);
        user.ifPresent(this.repository::delete);
    }

    public List<User> get() {
        return this.repository.findAll();
    }

    public User getUserById(UUID id) {
        Optional<User> user = this.repository.findById(id);
        return Optional.of(user)
                .get()
                .orElseThrow(() -> new RuntimeException(String.format("User [ ID: '%s' ] not found", id)));
    }
}