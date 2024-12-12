package com.example.counsel.controller.admin;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<Long, UserEntity> database = new HashMap<>();

    static {
        database.put(1L, new UserEntity(1L, "김진마", "password123", "wlsdyd0264@naver.com", "010-3413-3883", "용인시 어친구"));
    }

    public UserEntity findById(Long id) {
        return database.get(id);
    }

    public void save(UserEntity user) {
        database.put(user.getId(), user);
    }

    public UserEntity findByEmail(String email) {
        return database.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
