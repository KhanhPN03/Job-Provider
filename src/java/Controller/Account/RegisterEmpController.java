/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import Dal.AccountDAO;
import Dal.CandidateDAO;
import Dal.EmployerDAO;
import Model.Account;
import Model.Candidate;
import Model.Employer;
import Model.hashByMD5;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class RegisterEmpController extends HttpServlet {

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
            out.println("<title>Servlet RegisterEmpController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterEmpController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String tax = request.getParameter("tax");
        String Q1 = request.getParameter("Q1");
        String ansQ1 = request.getParameter("ansQ1");
        String Q2 = request.getParameter("Q2");
        String ansQ2 = request.getParameter("ansQ2");
        String img = request.getParameter("img");

        AccountDAO aDAO = new AccountDAO();
        EmployerDAO eDAO = new EmployerDAO();

        String a_id = aDAO.randomAccID();

        hashByMD5 md5 = new hashByMD5();
        Account a = new Account(
                a_id,
                username,
                md5.hash(password),
                "2",
                img,
                email,
                Q1,
                ansQ1,
                Q2,
                ansQ2
        );

        request.setAttribute("account", a);

        aDAO.insertAccount(a);

        String e_id = eDAO.randomEmpID();

        Employer e = new Employer(
                e_id,
                name,
                address,
                phone,
                tax,
                "0",
                a
        );

        eDAO.insertEmployer(e);

        request.getRequestDispatcher("login").forward(request, response);
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
