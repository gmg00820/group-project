package com.example.counsel.controller.admin;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class UserRepository {
    // Mock 데이터베이스
    private static final Map<Long, UserEntity> database = new HashMap<>();

    static {
        database.put(1L, new UserEntity(1L, "김진마", "0264", "wlsdyd0264", "010-1234-5678", "서울시 강남구"));
    }
    /**
     * 사용자 정보 조회
     * @param id 사용자 ID
     * @return User 객체
     */
    public UserEntity findById(Long id) {
        return database.get(id);
    }
    /**
     * 사용자 정보 저장
     * @param user 저장할 사용자 객체
     */
    public void save(UserEntity user) {
        database.put(user.getId(), user);
    }
}

