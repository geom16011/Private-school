/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutils;

import cmdutils.Command;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Assignment;
import models.Student;
import models.Trainer;
import models.Course;

/**
 *
 * @author George.Pasparakis
 */
public class Database {

    private  static String username;
    private static String password;
    private static String database;

    private  static Connection con;
    //private static Statement statement;


    public static Connection getConnection() throws SQLException{
        String server=("jdbc:mysql://localhost/" + database + "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Athens");
        con = DriverManager.getConnection(server, username, password);
        return con;
    }

    public static void setUsername(String username) {
        Database.username = username;
    }

    public static void setPassword(String password) {
        Database.password = password;
    }

    public static void setDatabase(String database) {
        Database.database = database;
    }
}
