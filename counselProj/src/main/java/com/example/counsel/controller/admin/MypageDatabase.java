package com.example.counsel.controller.admin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MypageDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/STDNT_INFO"; // 데이터베이스 URL
    private static final String USER = "root"; // 사용자 이름
    private static final String PASSWORD = "wls0264"; // 비밀번호
    private Connection connection;

    public MypageDatabase() {
        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("데이터베이스에 성공적으로 연결되었습니다.");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 오류.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("데이터베이스 연결이 종료되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MypageDatabase mypageDatabase = new MypageDatabase();
        // 데이터베이스 작업 수행
        // 예: mypageDatabase.getConnection()을 사용하여 쿼리 실행

        // 연결 종료
        mypageDatabase.closeConnection();
    }
}