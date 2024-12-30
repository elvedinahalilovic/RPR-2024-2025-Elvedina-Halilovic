package com.example.lv07;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    //private static final String DB_URL = "jdbc:sqlite:baza.db";
    private static final String DB_URL = "jdbc:sqlite:src/main/resources/baza.db";


    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Povezano s bazom podataka!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
