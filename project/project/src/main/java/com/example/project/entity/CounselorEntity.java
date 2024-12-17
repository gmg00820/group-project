package com.example.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EMP_NO")
public class EmpEntity {

    @Id
    @Column(name = "EMP_NO", nullable = false, length = 10)
    private String empNo;

    @Column(name = "EMP_SE", nullable = false, length = 10)
    private String empSe;

    @Column(name = "EMP_NM", nullable = false, length = 100)
    private String empNm;

    @Column(name = "DEPT_CD", nullable = false, length = 10)
    private String deptCd;

    @Column(name = "GNDR", nullable = false, length = 10)
    private String gndr;

    @Column(name = "EMAIL", nullable = false, length = 320)
    private String email;

    @Column(name = "MBL_TELNO", nullable = false, length = 15)
    private String mblTelNo;

    @Column(name = "ZIP", nullable = false, length = 5)
    private String zip;

    @Column(name = "ADDR", nullable = false, length = 200)
    private String addr;

    @Column(name = "DADDR", nullable = false, length = 200)
    private String daddr;

    @Column(name = "USER_NO", nullable = false, length = 10)
    private String userNo;

    @Column(name = "USER_SE", nullable = false, length = 10)
    private String userSe;

    @Column(name = "LGN_ID", nullable = false, length = 100)
    private String lgnId;

    // 기본 생성자
    public EmpEntity() {}

    // Getter 및 Setter
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpSe() {
        return empSe;
    }

    public void setEmpSe(String empSe) {
        this.empSe = empSe;
    }

    public String getEmpNm() {
        return empNm;
    }

    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getGndr() {
        return gndr;
    }

    public void setGndr(String gndr) {
        this.gndr = gndr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMblTelNo() {
        return mblTelNo;
    }

    public void setMblTelNo(String mblTelNo) {
        this.mblTelNo = mblTelNo;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDaddr() {
        return daddr;
    }

    public void setDaddr(String daddr) {
        this.daddr = daddr;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUse
