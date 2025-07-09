/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Account;
import Model.Candidate;
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
public class CandidateDAO extends DBContext {

    public Candidate getCandidateById(String c_id) {
        String sql = "select * from Candidate where c_id like '" + c_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            if (rs.next()) {
                Candidate c = new Candidate(
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

    public void insertCandidate(Candidate c) {
        String sql = "INSERT INTO [dbo].[Candidate]\n"
                + "           ([c_id]\n"
                + "           ,[c_name]\n"
                + "           ,[c_address]\n"
                + "           ,[c_phone]\n"
                + "           ,[c_dob]\n"
                + "           ,[tax])\n"
                + "           ,[a_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getC_id());
            st.setString(2, c.getC_name());
            st.setString(3, c.getC_address());
            st.setString(4, c.getC_phone());
            st.setString(5, c.getC_dob());
            st.setString(6, c.getTax());
            st.setString(7, c.getAccount().getA_id());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    public List<Candidate> getAllCandidate() {
//        List<Candidate> list = new ArrayList<>();
//        String sql = "select * from Account";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Candidate p = new Candidate();
//                p.setA_id(rs.getString(1));
//                p.setUsername(rs.getString(2));
//                p.setPassword(rs.getString(3));
//                p.setRole(rs.getString(4));
//                p.setAccImg(rs.getString(5));
//                p.setEmail(rs.getString(6));
//                p.setQ1(rs.getString(7));
//                p.setAnQ1(rs.getString(8));
//                p.setQ2(rs.getString(9));
//                p.setAnQ2(rs.getString(10));
//                list.add(p);
//            }
//            return list;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
    public Candidate getCandidateByAccountId(String a_id) {
        String sql = "select * from Candidate where a_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a_id);
            ResultSet rs = st.executeQuery();
            AccountDAO aDAO = new AccountDAO();
            if (rs.next()) {
                String accountId = rs.getString(7);
                Account account = aDAO.getAccountById(accountId);
                if (account != null) {
                    Candidate e = new Candidate(
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

    public List<Candidate> getAllCandidateID() {
        List<Candidate> list = new ArrayList<>();
        String sql = "select c_id from Candidate";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Candidate p = new Candidate();
                p.setC_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomCanID() {
        String canId = "";
        Random r = new Random();
        CandidateDAO a = new CandidateDAO();
        List<Candidate> can = a.getAllCandidateID();
        canId = "U" + String.format("%04d", r.nextInt(10000));

        for (Candidate canID : can) {
            while (canID.getC_id() == canId) {
                canId = "U" + String.format("%04d", r.nextInt(10000));
            }
        }

        return canId;
    }

}
