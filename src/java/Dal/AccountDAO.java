/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Account;
import Model.CV;
import Model.Candidate;
import Model.Company;
import Model.Employer;
import Model.hashByMD5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author admin
 */
public class AccountDAO extends DBContext {

    public Account login(String username, String password) {
        String sql = "Select * from Account "
                + "where username = '" + username + "' "
                + "and password = '" + password + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                );
                return a;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Account getAccountById(String id) {
        String sql = "select * from Account where a_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                );
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertAccount(Account c) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([a_id]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[role]\n"
                + "           ,[accImg]\n"
                + "           ,[email]\n"
                + "           ,[Q1]\n"
                + "           ,[ansQ1]\n"
                + "           ,[Q2]\n"
                + "           ,[ansQ2])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getA_id());
            st.setString(2, c.getUsername());
            st.setString(3, c.getPassword());
            st.setString(4, c.getRole());
            st.setString(5, c.getAccImg());
            st.setString(6, c.getEmail());
            st.setString(7, c.getQ1());
            st.setString(8, c.getAnQ1());
            st.setString(9, c.getQ2());
            st.setString(10, c.getAnQ2());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSecurityQForAccountById(String id, String Q1, String ansQ1, String Q2, String ansQ2) {
        String sql = "update Account set Q1 = " + Q1 + ", ansQ1 = " + ansQ1
                + ", set Q2 = " + Q2 + ", ansQ2 = " + ansQ2 + " where a_id like '" + id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account();
                p.setA_id(rs.getString(1));
                p.setUsername(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setRole(rs.getString(4));
                p.setAccImg(rs.getString(5));
                p.setEmail(rs.getString(6));
                p.setQ1(rs.getString(7));
                p.setAnQ1(rs.getString(8));
                p.setQ2(rs.getString(9));
                p.setAnQ2(rs.getString(10));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertCV(CV c) {
        String sql = "INSERT INTO [dbo].[CV]\n"
                + "           ([cv_id]\n"
                + "           ,[name]\n"
                + "           ,[dob]\n"
                + "           ,[gender]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[cv_link]\n"
                + "           ,[c_id]\n"
                + "           ,[post_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getCv_id());
            st.setString(2, c.getName());
            st.setString(3, c.getDob());
            st.setString(4, c.getGender());
            st.setString(5, c.getEmail());
            st.setString(6, c.getPhone());
            st.setString(7, c.getCv_link());
            st.setString(8, c.getC_id());
            st.setString(9, c.getPost_id());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public CV getCVbyCandidateId(String c_id) {
        String sql = "select * from CV where c_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CV a = new CV(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CV getCVbyId(String cv_id) {
        String sql = "select * from CV where cv_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cv_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CV a = new CV();
                a.setCv_id(rs.getString(1));
                a.setC_id(rs.getString(8));
                a.setName(rs.getString(2));
                a.setDob(rs.getString(3));
                a.setGender(rs.getString(4));
                a.setEmail(rs.getString(5));
                a.setPhone(rs.getString(6));
                a.setCv_link(rs.getString(7));
                a.setPost_id(rs.getString(9));

                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CV> getAllCVbyPost_id(String post_id) {
        List<CV> list = new ArrayList<>();
        String sql = "select * from CV where post_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, post_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CV a = new CV();
                a.setCv_id(rs.getString(1));
                a.setC_id(rs.getString(8));
                a.setName(rs.getString(2));
                a.setDob(rs.getString(3));
                a.setGender(rs.getString(4));
                a.setEmail(rs.getString(5));
                a.setPhone(rs.getString(6));
                a.setCv_link(rs.getString(7));
                a.setPost_id(rs.getString(9));
                list.add(a);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateCandidateProfileByC_id(Candidate c, String c_id) {
        String sql = "UPDATE [dbo].[Candidate]\n"
                + "   SET [c_id] = '" + c.getC_id() + "'\n"
                + "      ,[c_name] = '" + c.getC_name() + "'\n"
                + "      ,[c_address] = '" + c.getC_address() + "'\n"
                + "      ,[c_phone] = '" + c.getC_phone() + "'\n"
                + "      ,[c_dob] = '" + c.getC_dob() + "'\n"
                + "      ,[tax] = '" + c.getTax() + "'\n"
                + "      ,[a_id] = '" + c.getAccount().getA_id() + "'\n"
                + " WHERE c_id like '" + c_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateEmployerProfileByE_id(Employer c, String e_id) {
        String sql = "UPDATE [dbo].[Employer]\n"
                + "   SET [e_id] = '" + c.getE_id() + "'\n"
                + "      ,[e_name] = '" + c.getE_name() + "'\n"
                + "      ,[e_address] = '" + c.getE_address() + "'\n"
                + "      ,[e_phone] = '" + c.getE_phone() + "'\n"
                + "      ,[tax] = '" + c.getTax() + "'\n"
                + "      ,[update_status] = '" + c.getUpdate_status() + "'\n"
                + "      ,[a_id] = '" + c.getAccount().getA_id() + "'\n"
                + " WHERE e_id like '" + e_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCompanyProfileByCom_id(Company c, String com_id) {
        String sql = "UPDATE [dbo].[Company]\n"
                + "   SET [com_id] = '" + c.getCom_id() + "'\n"
                + "      ,[com_name] = '" + c.getCom_name() + "'\n"
                + "      ,[com_address] = '" + c.getCom_address() + "'\n"
                + "      ,[com_phone] = '" + c.getCom_phone() + "'\n"
                + "      ,[tax] = '" + c.getTax() + "'\n"
                + "      ,[a_id] = '" + c.getAccount().getA_id() + "'\n"
                + " WHERE com_id like '" + com_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatePassword(String newPass, String a_id) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET \n"
                + "      [password] = \n" + newPass
                + "    \n"
                + " WHERE [a_id] = " + a_id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Account> getAllAccountID() {
        List<Account> list = new ArrayList<>();
        String sql = "select a_id from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account();
                p.setA_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomAccID() {
        String accId = "";
        Random r = new Random();
        AccountDAO a = new AccountDAO();
        List<Account> acc = a.getAllAccountID();
        accId = "A" + String.format("%04d", r.nextInt(10000));

        for (Account accID : acc) {
            while (accID.getA_id() == accId) {
                accId = "A" + String.format("%04d", r.nextInt(10000));
            }
        }

        return accId;
    }

    public List<Employer> getAllEmpRequest() {
        List<Employer> e = new ArrayList<>();
        String sql = "select \n"
                + "	*\n"
                + "from Account as A\n"
                + "right join Employer as E on A.a_id = E.a_id\n"
                + "where e.update_status = 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employer emp = new Employer();
                emp.setAccount(getAccountById(rs.getString(1)));
                emp.setE_address(rs.getString(13));
                emp.setE_id(rs.getString(11));
                emp.setE_name(rs.getString(12));
                emp.setE_phone(rs.getString(14));
                emp.setTax(rs.getString(15));
                emp.setUpdate_status(rs.getString(16));
                e.add(emp);
            }
            return e;
        } catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public List<Company> getAllComRequest() {
        List<Company> e = new ArrayList<>();
        String sql = "select \n"
                + "	*\n"
                + "from Account as A\n"
                + "right join Company as E on A.a_id = E.a_id\n"
                + "where e.update_status = 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Company com = new Company();
                com.setAccount(getAccountById(rs.getString(1)));
                com.setCom_address(rs.getString(13));
                com.setCom_id(rs.getString(11));
                com.setCom_name(rs.getString(12));
                com.setCom_phone(rs.getString(14));
                com.setTax(rs.getString(15));
                com.setUpdate_status(rs.getString(16));
                e.add(com);
            }
            return e;
        } catch (Exception err) {
            System.out.println(err);
        }
        return null;
    }

    public void approveEmpAcc(String e_id) {
        String sql = "update Employer set update_status = 1 where e_id = N'" + e_id + "'\n"
                + "update Account set role = 1 where a_id =\n"
                + "(select a_id from Employer where e_id = '" + e_id + "') ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void approveComAcc(String c_id) {
        String sql = "update Company set update_status = 1 where e_id = N'" + c_id + "'\n"
                + "update Account set role = 1 where a_id =\n"
                + "(select a_id from Company where com_id = '" + c_id + "') ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void denyEmpAcc(String e_id, String a_id) {
        String sql = "delete from Employer where e_id like '" + e_id + "' \n"
                + "delete from Account where a_id like '" + a_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void denyCommAcc(String com_id, String a_id) {
        String sql = "delete from Company where com_id like '" + com_id + "' \n"
                + "delete from Account where a_id like '" + a_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account checkPassForChangePass(String a_id, String password) {
        String sql = "Select * from Account "
                + "where a_id like N'" + a_id + "' "
                + "and password like N'" + password + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                );
                return a;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public void changePass(String a_id, String newPass) {
        String sql = "update Account "
                + "set password = N'" + newPass + "' where a_id like N'" + a_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account checkAccountForRecoverPass(String username) {
        String sql = "Select * from Account "
                + "where username like N'" + username + "' ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                );
                return a;
            }
        } catch (SQLException e) {
        }
        return null;
    }

}
