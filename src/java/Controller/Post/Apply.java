/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Post;

import Dal.CandidateDAO;
import Dal.PostDAO;
import Model.CV;
import Model.Candidate;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 *
 * @author admin
 */
public class Apply extends HttpServlet {

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
            out.println("<title>Servlet Apply</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Apply at " + request.getContextPath() + "</h1>");
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

        String p_id = request.getParameter("p_id");
        String pD_id = request.getParameter("pD_id");
        String a_id = request.getParameter("a_id");

        request.setAttribute("a_id", a_id);
        request.setAttribute("p_id", p_id);
        request.setAttribute("pD_id", pD_id);

        request.getRequestDispatcher("Apply.jsp").forward(request, response);
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

//        String a_id = (String) request.getAttribute("a_id");
//        String p_id = (String) request.getAttribute("p_id");
//        String pD_id = (String) request.getAttribute("pD_id");
        String a_id = request.getParameter("a_id");
        String p_id = request.getParameter("p_id");
        String pD_id = request.getParameter("pD_id");
        request.setAttribute("a_id", a_id);
        request.setAttribute("post_id", p_id);
        request.setAttribute("postD_id", pD_id);

        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String link = request.getParameter("link");

        Random rand = new Random();
        String cv_id;
        int randomCv_id = rand.nextInt(10000);
        cv_id = "CV" + String.format("%04d", randomCv_id);

        CandidateDAO cDAO = new CandidateDAO();
        Candidate c = cDAO.getCandidateByAccountId(a_id);

        CV cv = new CV(
                cv_id,
                c.getC_id(),
                name,
                dob,
                gender,
                email,
                phone,
                link,
                p_id);

        PostDAO pDAO = new PostDAO();
        pDAO.insertCV(cv);

        request.getRequestDispatcher("ViewPostDetailController").forward(request, response);

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
