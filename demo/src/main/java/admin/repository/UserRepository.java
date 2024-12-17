package admin.repository;

import admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // 사용자명으로 사용자 검색
    public User findByEmailAndPwd(String email, String pwd);
    public User findByEmail(String email);
    public User findById(long id);
    //List<User> findByEmailAndNameAndPhone(String email,String name, Integer phone);
}
