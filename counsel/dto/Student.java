package com.example.counsel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {
    //학번
    private Long STDNT_NO;
    //학생성명
    private String STDNT_NAME;
    //GENDER
    private String GNDR;
    //Email
    private String EMAIL;
    //전화번호
    private String MBL_TELNO;
    //우편번호
    private int ZIP;
    //주소
    private String ADDR;
    //상세주소
    private String DADDR;
    //사용자 번호
    private String USER_NO;

    //DTO에 학번, 학생명, 전화번호, 주소 등 학생들의 정보를 포함한 변수를 생성하고 기본 생성자로 클래스의 인스턴스를 초기화한다.
    public Student(Long STDNT_NO, String STDNT_NAME, String GNDR, String MBL_TELNO, int ZIP, String ADDR,
                   String DADDR, String USER_NO){
        super();
        //학번
        this.STDNT_NO = STDNT_NO;
        //학생서명
        this.STDNT_NAME= STDNT_NAME;
        //GENDER
        this.GNDR = GNDR;
        //Email
        this.EMAIL = EMAIL;
        //전화번호
        this.MBL_TELNO = MBL_TELNO;
        //우편번호
        this.ZIP = ZIP;
        //주소
        this.ADDR =ADDR;
        //상세주소
        this.DADDR = DADDR;
        //사용자 번호
        this.USER_NO = USER_NO;
    }

}