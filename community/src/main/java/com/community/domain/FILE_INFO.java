package com.community.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@IdClass(FILEINFO_ID.class)
public class FILE_INFO {
    @Id
    @Column(name = "FILE_NO")
    @OneToMany(mappedBy = "FILE_NO")
    private Long FILE_NO;

    @Id
    @Column(name = "SEQ_NO")
    private Long SEQ_NO;

    @Column(name ="UUID")
    private String UUID;

    @Column(name = "ORG_FILE_NM")
    private String ORG_FILE_NM;

    @Column(name = "FILE_PATH")
    private String FILE_PATH;
}
