package com.likelion.springprac.user.domain;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    void updateById(Long id, User user);
    void deleteById(Long id);
}
