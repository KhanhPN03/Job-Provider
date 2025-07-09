/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.PostDetail;

import Dal.CompanyDAO;
import Dal.EmployerDAO;
import Dal.PostDAO;
import Model.Company;
import Model.Employer;
import Model.Post;
import Model.PostDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 *
 * @author admin
 */
public class UploadJobController extends HttpServlet {

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
            out.println("<title>Servlet UploadJobController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadJobController at " + request.getContextPath() + "</h1>");
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
//    String a_id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
        String a_id = request.getParameter("id");
        request.setAttribute("a_id", a_id);
        request.getRequestDispatcher("UploadJobForm.jsp").forward(request, response);
    }

//    static Post p = new Post();
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

//        HttpSession session = request.getSession();
//        String a_id = (String) session.getAttribute("a_id");
        String a_id = request.getParameter("a_id");

        String job_name = request.getParameter("job_name");
        String Sector = request.getParameter("Sector");
        String Salary = request.getParameter("Salary");
        String workingHours = request.getParameter("workingHours");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("calc_shipping_provinces");
        String numberOfRecruit = request.getParameter("number");
        String description = request.getParameter("description");
        String date_end = request.getParameter("date_end");

        Random rand = new Random();
        PostDAO pDAO = new PostDAO();
        EmployerDAO eDAO = new EmployerDAO();
        CompanyDAO comDAO = new CompanyDAO();

        String pD_id = pDAO.randomPostDetailID();

        PostDetail pDetail = new PostDetail(
                pD_id,
                job_name,
                description,
                Salary,
                Sector,
                workingHours,
                null,
                null,
                phone,
                address,
                email,
                "1",
                "0",
                city,
                numberOfRecruit
        );

        Employer e = eDAO.getEmployerByAccountId(a_id);
        if (e != null) {
            pDetail.setEmp_id(e.getE_id());
        } else {
            pDetail.setEmp_id(null);
        }

        Company c = comDAO.getCompanyByAccountId(a_id);
        if (c != null) {
            pDetail.setCom_id(c.getCom_id());
        } else {
            pDetail.setCom_id(null);
        }

        pDAO.insertPostDetail(pDetail);

        String p_id = pDAO.randomPostID();

        LocalDate lt = LocalDate.now();
        String date_start = lt.toString();

        Post p = new Post(
                p_id,
                date_start,
                date_end,
                pDetail
        );

        pDAO.insertPost(p);

        response.sendRedirect("viewpostcontroller");
//        request.getRequestDispatcher("viewpostcontroller").forward(request, response);

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

//    public static void main(String[] args) {
//        EmployerDAO eDAO = new EmployerDAO();
//        CompanyDAO comDAO = new CompanyDAO();
//        Random rand = new Random();
//        String p_id;   
//        int randomPid = rand.nextInt(10000);
//        p_id = "PD" + String.format("%04d", randomPid);
//        LocalDate lt = LocalDate.now();
//        
//    }
}
