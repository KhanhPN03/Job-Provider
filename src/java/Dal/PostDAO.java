/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.CV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Feedback;
import Model.Post;
import Model.PostDetail;
import Model_Data.SectorData;
import java.util.Random;

/**
 *
 * @author admin
 */
public class PostDAO extends DBContext {

    public PostDetail getPostDetailById(String postD_id) {
        String sql = "select * from PostDetail where postD_id like '" + postD_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                PostDetail p = new PostDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15)
                );
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Post getPostByPostDetailId(String postD_id) {
        String sql = "select * from Post where postD_id like '" + postD_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Post p = new Post(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        getPostDetailById(rs.getString(4))
                );
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Post getPostById(String post_id) {
        String sql = "select * from Post where post_id like '" + post_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Post p = new Post(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        getPostDetailById(rs.getString(4))
                );
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<>();
        String sql = "select * from Post order by date_start desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPost_id(rs.getString(1));
                p.setDate_start(rs.getString(2));
                p.setDate_end(rs.getString(3));
                p.setPostDetail(
                        getPostDetailById(rs.getString(4))
                );
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Feedback> getAllFeedBackByPost(String post_id) {
        List<Feedback> list = new ArrayList<>();
        String sql = "select * from Feedback where post_id like '" + post_id + "' order by fb_date desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<SectorData> getAllSector() {
        List<SectorData> list = new ArrayList<>();
        String sql = "with temp as (select PostDetail.sector, COUNT(PostDetail.sector) as NumberOfPost\n"
                + "from PostDetail\n"
                + "group by PostDetail.sector)\n"
                + "select * from temp order by sector";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new SectorData(
                        rs.getString(1),
                        rs.getString(2)
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<String> getAllCity() {
        List<String> list = new ArrayList<>();
        String sql = "with temp as (select PostDetail.city as city\n"
                + "from PostDetail\n"
                + "group by PostDetail.city)\n"
                + "select * from temp order by city";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<String> getAllWorkingHours() {
        List<String> list = new ArrayList<>();
        String sql = "with temp as (select PostDetail.workingHours as wh\n"
                + "from PostDetail\n"
                + "group by PostDetail.workingHours)\n"
                + "select * from temp order by wh";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<String> getAllSalary() {
        List<String> list = new ArrayList<>();
        String sql = "with temp as (select PostDetail.salary\n"
                + "from PostDetail\n"
                + "group by PostDetail.salary)\n"
                + "select * from temp";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Post> getAllPendingRequest() {
        List<Post> list = new ArrayList<>();
        String sql = "select * from Post p\n"
                + "right join PostDetail pD on p.postD_id=pD.postD_id\n"
                + "where (pD.post_status = 0 and pD.update_status = 1) "
                + "or (pD.post_status = 1 and pD.update_status = 1) order by p.date_start desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPost_id(rs.getString(1));
                p.setDate_start(rs.getString(2));
                p.setDate_end(rs.getString(3));
                p.setPostDetail(
                        getPostDetailById(rs.getString(5))
                );
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertPostDetail(PostDetail c) {
        String sql = "INSERT INTO [dbo].[PostDetail]\n"
                + "           ([postD_id]\n"
                + "           ,[job_name]\n"
                + "           ,[description]\n"
                + "           ,[salary]\n"
                + "           ,[sector]\n"
                + "           ,[workingHours]\n"
                + "           ,[e_id]\n"
                + "           ,[com_id]\n"
                + "           ,[contact_phone]\n"
                + "           ,[contact_address]\n"
                + "           ,[contact_email]\n"
                + "           ,[update_status]\n"
                + "           ,[post_status]\n"
                + "           ,[city]\n"
                + "           ,[numberOfRecure])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getPostD_id());
            st.setString(2, c.getJob_name());
            st.setString(3, c.getDesciption());
            st.setString(4, c.getSalary());
            st.setString(5, c.getSector());
            st.setString(6, c.getWorkingHours());
            st.setString(7, c.getEmp_id());
            st.setString(8, c.getCom_id());
            st.setString(9, c.getContact_phone());
            st.setString(10, c.getContact_address());
            st.setString(11, c.getContact_email());
            st.setString(12, c.getUpdate_status());
            st.setString(13, c.getPost_status());
            st.setString(14, c.getCity());
            st.setString(15, c.getNumberOfRecure());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertPost(Post c) {
        String sql = "INSERT INTO [dbo].[Post]\n"
                + "           ([post_id]\n"
                + "           ,[date_start]\n"
                + "           ,[date_end]\n"
                + "           ,[postD_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getPost_id());
            st.setString(2, c.getDate_start());
            st.setString(3, c.getDate_end());
            st.setString(4, c.getPostDetail().getPostD_id());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateApprovePostDetail(String id) {
        String sql = "update PostDetail "
                + "set update_status = '0', post_status = '1' "
                + "where postD_id like '" + id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<PostDetail> getPostDetailByEmpComId(String id) {
        List<PostDetail> list = new ArrayList<>();
        String sql = "select * from PostDetail where e_id like ? or com_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PostDetail pD = new PostDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15)
                );
                list.add(pD);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertFeedbackByPost(Feedback c) {
        String sql = "INSERT INTO [dbo].[Feedback]\n"
                + "           ([f_id]\n"
                + "           ,[c_id]\n"
                + "           ,[post_id]\n"
                + "           ,[fb_detail]\n"
                + "           ,[fb_date])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getF_id());
            st.setString(2, c.getC_id());
            st.setString(3, c.getPost_id());
            st.setString(4, c.getFb_detail());
            st.setString(5, c.getFb_date());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
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

    public List<Post> getAllPostID() {
        List<Post> list = new ArrayList<>();
        String sql = "select post_id from Post";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPost_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomPostID() {
        String postId = "";
        Random r = new Random();
        PostDAO a = new PostDAO();
        List<Post> acc = a.getAllPostID();
        postId = "P" + String.format("%04d", r.nextInt(10000));

        for (Post accID : acc) {
            while (accID.getPost_id() == postId) {
                postId = "P" + String.format("%04d", r.nextInt(10000));
            }
        }

        return postId;
    }

    public List<PostDetail> getAllPostDetailID() {
        List<PostDetail> list = new ArrayList<>();
        String sql = "select postD_id from PostDetail";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PostDetail p = new PostDetail();
                p.setPostD_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomPostDetailID() {
        String postDetailId = "";
        Random r = new Random();
        PostDAO a = new PostDAO();
        List<PostDetail> acc = a.getAllPostDetailID();
        postDetailId = "PD" + String.format("%04d", r.nextInt(10000));

        for (PostDetail accID : acc) {
            while (accID.getPostD_id() == postDetailId) {
                postDetailId = "PD" + String.format("%04d", r.nextInt(10000));
            }
        }

        return postDetailId;
    }

    public List<Feedback> getAllFeedBackID() {
        List<Feedback> list = new ArrayList<>();
        String sql = "select f_id from Feedback";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback p = new Feedback();
                p.setF_id(rs.getString(1));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String randomFbID() {
        String fbId = "";
        Random r = new Random();
        PostDAO a = new PostDAO();
        List<Feedback> acc = a.getAllFeedBackID();
        fbId = "F" + String.format("%04d", r.nextInt(10000));

        for (Feedback accID : acc) {
            while (accID.getF_id() == fbId) {
                fbId = "F" + String.format("%04d", r.nextInt(10000));
            }
        }

        return fbId;
    }

    public List<CV> getAllCvByC_id(String c_id) {
        List<CV> list = new ArrayList<>();
        String sql = "SELECT [cv_id]\n"
                + "      ,[name]\n"
                + "      ,[dob]\n"
                + "      ,[gender]\n"
                + "      ,[email]\n"
                + "      ,[phone]\n"
                + "      ,[cv_link]\n"
                + "      ,[c_id]\n"
                + "      ,[post_id]\n"
                + "  FROM [dbo].[CV]\n"
                + "  WHERE c_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CV cv = new CV();
                cv.setCv_id(rs.getString(1));
                cv.setName(rs.getString(2));
                cv.setDob(rs.getString(3));
                cv.setGender(rs.getString(4));
                cv.setEmail(rs.getString(5));
                cv.setPhone(rs.getString(6));
                cv.setCv_link(rs.getString(7));
                cv.setC_id(rs.getString(8));
                cv.setPost_id(rs.getString(9));
                list.add(cv);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Post> getPostBySalary(String start, String end) {
        List<Post> list = new ArrayList<>();
        String sql = "select * from Post B "
                + "inner join PostDetail A "
                + "on a.postD_id = b.postD_id "
                + "where A.salary > N'" + start + "' and A.post_status = N'1' and A.salary < N'" + end + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post pD = new Post(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        getPostDetailById(rs.getString(4))
                );
                list.add(pD);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void denyPost(String postD_id) {
        String sql = "update PostDetail set update_status = NULL where postD_id = N'" + postD_id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Post> getPostDetailFilter(String city, String wh, String salary_start, String salary_end) {
        String start, end;
        if (salary_start.equals("")) {
            start = "0";
        } else {
            start = salary_start;
        }
        if (salary_end.equals("")) {
            end = "100000000";
        } else {
            end = salary_end;
        }
        List<Post> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM Post p\n"
                + "LEFT JOIN PostDetail pd ON p.postD_id = pd.postD_id\n"
                + "WHERE\n"
                + " (pd.city LIKE N'%" + city + "%')\n"
                + " AND (pd.workingHours LIKE N'%" + wh + "%')\n"
                + " AND (\n"
                + "    (pd.salary LIKE N'Thỏa thuận' or pd.salary >= " + start + " AND pd.salary < " + end + ")\n"
                + ")\n"
                + " AND pD.post_status = '1'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPost_id(rs.getString(1));
                p.setDate_start(rs.getString(2));
                p.setDate_end(rs.getString(3));
                p.setPostDetail(
                        getPostDetailById(rs.getString(4))
                );
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
