package com.likelion.springprac.user.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> database = new HashMap<>();

    @Override
    public void save(User user) {
        database.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return database.get(id);
    }

    @Override
    public List<User> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public void updateById(Long id, User user) {
        database.put(id, user);
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }
}
