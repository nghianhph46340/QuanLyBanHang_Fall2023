/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ChucNangBanHang;

import java.sql.*;
/**
 *
 * @author admin
 */
public class DBConnect {

    static String url = "jdbc:sqlserver://;serverName=localhost;databaseName=XUONGFA23";
    static String username = "sa";
    static String password = "12345678";
    public static void main(String[] args) throws SQLException {
        getConnection();
    }
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
}
