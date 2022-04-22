/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediateur;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enpei
 */
public class Mediateur {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
      
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /**
     * @param args the command line arguments
     */
        // Create and display the form 
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inter().setVisible(true);
            }
        });
       /* Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost/s1?"+"user=s1&password=0797308298123");
        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost/s2?"+"user=s2&password=0797308298123");
        Connection conn3 = DriverManager.getConnection("jdbc:mysql://localhost/s3?"+"user=s3&password=0797308298123");
        Statement stmt = conn1.createStatement();
        ResultSet rs = stmt.executeQuery(
         "select * from emp "
        );
        while(rs.next())
        {
            System.out.print(rs.getString(1) +" "+rs.getString(2) +"\n");
        }
        conn1.close();
        conn2.close();
        conn3.close();*/
     
    }
    
}
