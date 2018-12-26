package com.mum.edu;
import java.sql.*;

public class DbConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONN_STRING
            = "jdbc:mysql://localhost:3306/entries?verifyServerCertificate=false&useSSL=false&requireSSL=false";
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    public String getDefinitionFromDB(String word) {
        Connection conn = null;
        Statement stmt1 = null;
        String definition1;
        
        try{
            Class.forName(DATABASE_DRIVER);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt1 = (Statement) conn.createStatement();
            String query = "SELECT definition FROM entries.entries WHERE word ='" + word + "'";
            ResultSet rs = stmt1.executeQuery(query);
            definition1 = "";
            while (rs.next()) {
                definition1 += rs.getString("definition") + "||";
            }
        } catch (SQLException e) {
            definition1 = e.getMessage();
            System.err.println(e);
        } finally {   //finally block used to close resources
            try {
                if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                 se.printStackTrace();
                }//end finally try
            }//end try
        return definition1.substring(0, definition1.length()-2);
    }
}


