/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Company;
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
public class CompanyDAO extends DBContext {

    public Company getCompanyById(String com_id) {
        String sql = "select * from Company where com_id like '" + com_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            if (rs.next()) {
                Company c = new Company(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        aDAO.getAccountById(rs.getString(7))
                );
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Company> getAllCom() {
        String sql = "select * from Company";
        List<Company> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            while (rs.next()) {
                Company c = new Company(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        aDAO.getAccountById(rs.getString(7))
                );
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Company getCompanyByAccountId(String a_id) {
        String sql = "select * from Company where a_id like '" + a_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            if (rs.next()) {
                Company e = new Company(
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

    public List<Company> getAllCompanyID() {
        List<Company> list = new ArrayList<>();
        String sql = "select com_id from Company";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Company p = new Company();
                p.setCom_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomComID() {
        String comId = "";
        Random r = new Random();
        CompanyDAO a = new CompanyDAO();
        List<Company> acc = a.getAllCompanyID();
        comId = "C" + String.format("%04d", r.nextInt(10000));

        for (Company accID : acc) {
            while (accID.getCom_id() == comId) {
                comId = "C" + String.format("%04d", r.nextInt(10000));
            }
        }

        return comId;
    }

    public void insertCompany(Company c) {
        String sql = "INSERT INTO [dbo].[Company]\n"
                + "           ([com_id]\n"
                + "           ,[com_name]\n"
                + "           ,[com_address]\n"
                + "           ,[com_phone]\n"
                + "           ,[tax]\n"
                + "           ,[update_status]\n"
                + "           ,[a_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getCom_id());
            st.setString(2, c.getCom_name());
            st.setString(3, c.getCom_address());
            st.setString(4, c.getCom_phone());
            st.setString(5, c.getTax());
            st.setString(6, c.getUpdate_status());
            st.setString(7, c.getAccount().getA_id());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
