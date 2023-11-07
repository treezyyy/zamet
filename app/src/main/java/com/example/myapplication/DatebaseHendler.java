package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatebaseHendler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"
                +dbPost+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString,dbUser,
                dbPass);
        return dbConnection;
    }
    public String getName(int idusers) throws SQLException, ClassNotFoundException {
        System.out.println("1");
        Connection conn = getDbConnection();
        System.out.println("2");

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + " = ?");
        stmt.setInt(1, idusers);
        ResultSet rs = stmt.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("name");
        }
        conn.close();
        return name;
    }

    public String getOpis(int idusers) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + " = ?");
        stmt.setInt(1, idusers);
        ResultSet rs = stmt.executeQuery();
        String opis = null;
        if (rs.next()) {
            opis = rs.getString("opis");
        }
        conn.close();
        return opis;
    }
}
