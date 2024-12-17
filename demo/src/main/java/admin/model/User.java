package admin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String username;
    private String password;
    private Long id;
    private String email;
    private String pwd;
    private String name;
    private Integer phone;
    //private Date creDate;
    private String carname;
    @Column(nullable = true)
    private Integer count;

    @Enumerated(EnumType.STRING)
    private Role role; // USER, ADMIN 같은 권한 정보
}
