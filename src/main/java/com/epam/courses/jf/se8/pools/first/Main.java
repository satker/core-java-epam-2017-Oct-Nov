package com.epam.courses.jf.se8.pools.first;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance("org.gjt.mm.mysql.Driver", "jdbc:mysql://127.0.0.1/test", "root", "123456", 5);
        try (Connection con = pool.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS")){
            while (rs.next()) {
                System.out.println(rs.getInt("Name") + " " + rs.getString("Surname") + " " + rs.getInt("qwe"));
            }
            pool.freeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.release();
        }
    }
}

