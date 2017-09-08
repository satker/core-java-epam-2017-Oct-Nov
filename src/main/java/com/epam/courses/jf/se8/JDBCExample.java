package com.epam.courses.jf.se8;

import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            try (Connection connection = openConnection()) {
                String query = "SELECT * FROM UNIVERSITY.DEPARTMENTS WHERE ACRONYM=?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, args[0]);
                    try (ResultSet result = statement.executeQuery()) {
                        while (result.next()) {
                            System.out.println("Training program \"" + result.getString("ACRONYM") + "\"");
                        }
                    }
                }
//                injectionCode(args[0], connection);
//                selectAndPrintAllDepartments(connection);
//                insertGroup1307(connection);
//                removeGroup1307(connection);
//                updateGroup1307to1308(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    private static void injectionCode(String id, Connection connection) throws SQLException {
        try (Statement getDepartments = connection.createStatement()) {
            String query = "SELECT TRAINING_PROGRAM FROM UNIVERSITY.GROUPS WHERE ID=" + id;
            try (ResultSet result = getDepartments.executeQuery(query)) {
                while (result.next()) {
                    System.out.println("Training program \"" + result.getString("TRAINING_PROGRAM") + "\"");
                }
            }

        }
    }

    private static void updateGroup1307to1308(Connection connection) throws SQLException {
        try (Statement getDepartments = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
             ResultSet result = getDepartments.executeQuery("SELECT * FROM UNIVERSITY.GROUPS")) {
            while (result.next()) {
                int id = result.getInt("ID");
                if (id == 1307) {
                    result.updateInt("ID", 1308);
                    result.updateString("TRAINING_PROGRAM", "qwerty");
                    result.updateRow();
                }
            }
        }
    }

    private static void removeGroup1307(Connection connection) throws SQLException {
        try (Statement addDepartment = connection.createStatement()) {
            String insertQuery = "DELETE FROM UNIVERSITY.GROUPS WHERE ID = 1307";
            if (addDepartment.executeUpdate(insertQuery) != 1) {
                throw new IllegalStateException();
            }
        }
    }

    private static void insertGroup1307(Connection connection) throws SQLException {
        try (Statement addDepartment = connection.createStatement()) {
            String insertQuery = "INSERT INTO UNIVERSITY.GROUPS (ID, DEPARTMENT_ID, TRAINING_PROGRAM) VALUES (1307, 0, 'Программная инженерия')";
            if (addDepartment.executeUpdate(insertQuery) != 1) {
                throw new IllegalStateException();
            }
        }
    }

    private static void selectAndPrintAllDepartments(Connection connection) throws SQLException {
        try (Statement getDepartments = connection.createStatement();
             ResultSet result = getDepartments.executeQuery("SELECT * FROM UNIVERSITY.DEPARTMENTS")) {
            while (result.next()) {
                System.out.print("ID = " + result.getInt(DEPARTMENTS_FIELDS.ID.toString()));
                System.out.print(", Name = " + result.getString(DEPARTMENTS_FIELDS.NAME.toString()));
                System.out.println(", Acronym = " + result.getString(DEPARTMENTS_FIELDS.ACRONYM.toString()));
            }
        }
    }

    private static Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
    }

    public enum DEPARTMENTS_FIELDS {
        ID,
        NAME,
        ACRONYM
    }
}
