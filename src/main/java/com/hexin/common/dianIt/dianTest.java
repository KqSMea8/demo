package com.hexin.common.dianIt;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class dianTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        jdbcTest();
        scannerTest();
    }
    public static void jdbcTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shenxiaojie";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM USER");
        while (result.next()){
            System.out.println(result.getInt(1));
            System.out.println(result.getString(2));
        }
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("username");
        String str = scanner.nextLine();
        System.out.println(str);
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));
    }

}
