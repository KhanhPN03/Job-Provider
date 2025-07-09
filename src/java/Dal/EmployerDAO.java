/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Account;
import Model.Employer;
import Model.PostDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author admin
 */
public class EmployerDAO extends DBContext {

    public Employer getEmployerById(String e_id) {
        String sql = "select * from Employer where e_id like '" + e_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            if (rs.next()) {
                Employer e = new Employer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        aDAO.getAccountById(rs.getString(7))
                );
                return e;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertEmployer(Employer c) {
        String sql = "INSERT INTO [dbo].[Employer]\n"
                + "           ([e_id]\n"
                + "           ,[e_name]\n"
                + "           ,[e_address]\n"
                + "           ,[e_phone]\n"
                + "           ,[tax]\n"
                + "           ,[update_status]\n"
                + "           ,[a_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getE_id());
            st.setString(2, c.getE_name());
            st.setString(3, c.getE_address());
            st.setString(4, c.getE_phone());
            st.setString(5, c.getTax());
            st.setString(6, c.getUpdate_status());
            st.setString(7, c.getAccount().getA_id());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Employer> getAllEmp() {
        String sql = "select * from Employer";
        List<Employer> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            while (rs.next()) {
                Employer e = new Employer();
                e.setE_id(rs.getString(1));
                e.setE_name(rs.getString(2));
                e.setE_address(rs.getString(3));
                e.setE_phone(rs.getString(4));
                e.setTax(rs.getString(5));
                e.setUpdate_status(rs.getString(6));
                e.setAccount(aDAO.getAccountById(rs.getString(7)));
                list.add(e);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Employer getEmployerByAccountId(String a_id) {
        String sql = "select * from Employer where a_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a_id);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            if (rs.next()) {
                String accountId = rs.getString(7);
                Account account = aDAO.getAccountById(accountId);
                if (account != null) {
                    Employer e = new Employer(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            account
                    );
                    return e;
                } else {
                    // Handle the case where the account is not found
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employer> getAllEmployerID() {
        List<Employer> list = new ArrayList<>();
        String sql = "select e_id from Employer";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employer p = new Employer();
                p.setE_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomEmpID() {
        String empId = "";
        Random r = new Random();
        EmployerDAO a = new EmployerDAO();
        List<Employer> acc = a.getAllEmployerID();
        empId = "E" + String.format("%04d", r.nextInt(10000));

        for (Employer accID : acc) {
            while (accID.getE_id() == empId) {
                empId = "E" + String.format("%04d", r.nextInt(10000));
            }
        }

        return empId;
    }

}
