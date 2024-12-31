package com.example.counsel.repository;

import com.example.counsel.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private static final Map<Long, Student> store = new HashMap<>();
    private static long sequence = 0L;

    // 저장
    public Student save(Student student) {
        student.setSTDNT_NO(++sequence);
        store.put(student.getSTDNT_NO(), student);
        return student;
    }

    // 학번으로 찾기
    public Student findById(Long STDNT_NO) {
        return store.get(STDNT_NO);
    }

    // 전체 검색
    public List<Student> findAll(){
        return new ArrayList<Student>(store.values());
    }

    // 수정
    public void update(Long STDNT_NO, Student updateParam) {
        Student findStudent = findById(STDNT_NO);
        findStudent.setSTDNT_NAME(updateParam.getSTDNT_NAME());
        findStudent.setGNDR(updateParam.getGNDR());
        findStudent.setEMAIL(updateParam.getEMAIL());
        findStudent.setMBL_TELNO(updateParam.getMBL_TELNO());
        findStudent.setZIP(updateParam.getZIP());
        findStudent.setADDR(updateParam.getADDR());
        findStudent.setDADDR(updateParam.getDADDR());
        findStudent.setUSER_NO(updateParam.getUSER_NO());

    }

}