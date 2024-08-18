package br.com.infnet.appJoaoVictorGontijo.user;

import java.util.*;

public class UserService {

    private final Map<UUID, User> userMap = new HashMap<>();

    public void add(User user) {
        userMap.put(user.getId(), user);
    }

    public void remove(UUID id) {
        userMap.remove(id);
    }

    public List<User> get() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(UUID id) {
        return userMap.get(id);
    }
}