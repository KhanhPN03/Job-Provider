/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ManagerDAO extends DBContext {
    
    
    public void accountVerification(String id) {
        String sql;
        if (id.contains("E")) {
            sql = "UPDATE Company "
                    + "SET update_status = " + 1 
                    + " where com_id like '" + id + "'";
        } else {
            sql = "UPDATE Candidate "
                    + "SET update_status = " + 1 
                    + " where c_id like '" + id + "'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }   
    }
    
    public void postVerification(String id) {
        String sql = "UPDATE PostDetail "
                + "SET update_status = " + 1 
                + " where postD_id like '" + id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
//    public void postDelete(String id) {
//        String sql = "DELETE PostDetai where postD_id like '" + id + "'";
//    }
    
   
   
}
