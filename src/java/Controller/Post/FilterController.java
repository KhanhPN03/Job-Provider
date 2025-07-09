/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Post;

import Dal.CompanyDAO;
import Dal.EmployerDAO;
import Dal.PostDAO;
import Model.Company;
import Model.Employer;
import Model.Post;
import Model.PostDetail;
import Model_Data.SectorData;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class FilterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        List<Post> listVerifiedPost = new ArrayList<>();
        for (int i = 0; i < listPost.size(); i++) {
            if (listPost.get(i).getPostDetail().getPost_status().equals("1")) {
                listVerifiedPost.add(listPost.get(i));
            }
        }

        for (int i = 0; i < listVerifiedPost.size(); i++) {
            PostDetail postDetail = listVerifiedPost.get(i).getPostDetail();
            if (!postDetail.getCity().equalsIgnoreCase(key)
                    || !postDetail.getSector().equalsIgnoreCase(key)
                    || !postDetail.getWorkingHours().equalsIgnoreCase(key)) {
                listVerifiedPost.remove(i);
            }
        }


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
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

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
