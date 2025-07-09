/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Post;

import Dal.CompanyDAO;
import Dal.EmployerDAO;
import Dal.PostDAO;
import Model.Account;
import Model.Company;
import Model.Employer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import Model.Post;
import Model.PostDetail;
import Model_Data.SectorData;
import jakarta.servlet.http.HttpSession;
import static java.lang.System.out;

/**
 *
 * @author admin
 */
public class ViewPostController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Account a = new Account();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        a = (Account) request.getAttribute("account");
        doGet(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        HttpSession session = request.getSession();
//        Account a = (Account) session.getAttribute("account") ? null : a_g;
//        session.setAttribute("account", a);
//        String logout = request.getParameter("logout");
//        if (logout != null) {
//            request.setAttribute("logout", logout);
//        }
//        a = (Account) request.getAttribute("account");


        if (request.getParameter("logout") != null) {
            a = new Account();
            request.setAttribute("account", a);
        }
        
        request.setAttribute("account", a);

        String key = request.getParameter("key");
        String a_id = request.getParameter("a_id");
        request.setAttribute("a_id", a_id);

        PostDAO pDAO = new PostDAO();
        EmployerDAO eDAO = new EmployerDAO();
        CompanyDAO comDAO = new CompanyDAO();

        List<Post> listPost = pDAO.getAllPost();
        List<Employer> listEmp = eDAO.getAllEmp();
        List<Company> listCom = comDAO.getAllCom();
        List<SectorData> listSector = pDAO.getAllSector();
        List<String> listCity = pDAO.getAllCity();
        List<String> listWorkingHours = pDAO.getAllWorkingHours();

        // Tạo list chứa những bài post đã được duyệt
        List<Post> listVerifiedPost = new ArrayList<>();

        String code = request.getParameter("code");

        for (int i = 0; i < listPost.size(); i++) {
            if (listPost.get(i).getPostDetail().getPost_status().equals("1")) {
                listVerifiedPost.add(listPost.get(i));
            }
            if (key != null && code != null && !code.equals("salary")) {
                for (int j = 0; j < listVerifiedPost.size(); j++) {
                    PostDetail postDetail = listVerifiedPost.get(j).getPostDetail();
                    switch (code) {
                        case "sector":
                            if (!postDetail.getSector().equals(key)) {
                                listVerifiedPost.remove(j);
                            }
                            break;
                        case "city":
                            if (!postDetail.getCity().equals(key)) {
                                listVerifiedPost.remove(j);
                            }
                            break;

                        case "wh":
                            if (!postDetail.getWorkingHours().equals(key)) {
                                listVerifiedPost.remove(j);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }

//        if (key!=null && code!=null && code.equals("salary")) {
//            switch (key) {
//                case "Ít hơn 5tr":
//                    listVerifiedPost = pDAO.getPostBySalary("10", "5000000");
//                    break;
//                case "5tr-10tr":
//                    listVerifiedPost = pDAO.getPostBySalary("5000000", "10000000");
//                    break;
//                case "10tr-20tr":
//                    listVerifiedPost = pDAO.getPostBySalary("10000000", "20000000");
//                    break;
//                case "20tr-30tr":
//                    listVerifiedPost = pDAO.getPostBySalary("20000000", "30000000");
//                    break;
//                case "Lớn hơn 30tr":
//                    listVerifiedPost = pDAO.getPostBySalary("30000000", "50000000");
//                    break;
//            }
//        }

        List<String> listSalary = new ArrayList<>();

        listSalary.add("Ít hơn 5tr");
        listSalary.add("5tr-10tr");
        listSalary.add("10tr-20tr");
        listSalary.add("20tr-30tr");
        listSalary.add("Lớn hơn 30tr");

        request.setAttribute("listPost", listVerifiedPost);
        request.setAttribute("listEmp", listEmp);
        request.setAttribute("listCom", listCom);
        request.setAttribute("listSector", listSector);
        request.setAttribute("listCity", listCity);
        request.setAttribute("listWorkingHours", listWorkingHours);
        request.setAttribute("listSalary", listSalary);

        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
