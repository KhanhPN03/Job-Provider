/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Post;

import Dal.CandidateDAO;
import Dal.PostDAO;
import Model.Candidate;
import Model.Feedback;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author admin
 */
public class AddFeedbackController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddFeedbackController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddFeedbackController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String a_id = request.getParameter("a_id");
        String p_id = request.getParameter("p_id");
        String pD_id = request.getParameter("pD_id");
        request.setAttribute("a_id", a_id);
        request.setAttribute("post_id", p_id);
        request.setAttribute("postD_id", pD_id);
        
        String fb_detail = request.getParameter("feedback_detail");
//        String postD_id = request.getParameter("postD_id");
         
        CandidateDAO cDAO = new CandidateDAO();
        Candidate c = cDAO.getCandidateByAccountId(a_id);
        
        PostDAO pDAO = new PostDAO();
        
        Random rand = new Random();
        String fb_id = pDAO.randomFbID();
      
        
        LocalDate lt = LocalDate.now();
        String date = lt.toString();
        
        Feedback fb = new Feedback(
                fb_id,
                c.getC_id(),
                p_id,
                fb_detail,
                date
        );
        pDAO.insertFeedbackByPost(fb);
        
        request.getRequestDispatcher("ViewPostDetailController").forward(request, response);
//response.sendRedirect("ViewPostDetailController");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
