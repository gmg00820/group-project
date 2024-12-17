package com.community2.community2.domain;

import jakarta.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class FileInfoId implements Serializable {

    @Column(name = "FILE_NO")
    private String fileNo; // 파일 번호

    @Column(name = "SEQ_NO")
    private String seqNo; // 시퀀스 번호

    // 기본 생성자
    public FileInfoId() {}

    // equals() 메서드 오버라이드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileInfoId)) return false;
        FileInfoId that = (FileInfoId) o;
        return Objects.equals(fileNo, that.fileNo) &&
                Objects.equals(seqNo, that.seqNo);
    }

    // hashCode() 메서드 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(fileNo, seqNo);
    }
}
