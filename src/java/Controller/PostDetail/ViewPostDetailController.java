/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.PostDetail;

import Dal.CandidateDAO;
import Dal.CompanyDAO;
import Dal.EmployerDAO;
import Dal.PostDAO;
import Model.Candidate;
import Model.Company;
import Model.Employer;
import Model.Feedback;
import Model.Post;
import Model_Data.FeedbackData;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.PostDetail;
import Model_Data.PostData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ViewPostDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String post_id_g;
    String postDetail_id_g;
    String a_id_g;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            post_id_g = (String) request.getAttribute("post_id");
            postDetail_id_g = (String) request.getAttribute("postD_id");
            a_id_g = (String) request.getAttribute("a_id");
            doGet(request, response);

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

        String postD_id = request.getParameter("postD_id") == null
                ? postDetail_id_g
                : request.getParameter("postD_id");

        String post_id = request.getParameter("post_id") == null
                ? post_id_g
                : request.getParameter("post_id");

        request.setAttribute("postD_id", postD_id);
        request.setAttribute("post_id", post_id);

        String a_id = request.getParameter("a_id") == null
                ? a_id_g
                : request.getParameter("a_id");
        
        request.setAttribute("a_id", a_id);

        PostDAO pDAO = new PostDAO();
        CandidateDAO cDAO = new CandidateDAO();
        EmployerDAO eDAO = new EmployerDAO();
        CompanyDAO comDAO = new CompanyDAO();

        Candidate candidate = cDAO.getCandidateByAccountId(a_id);
        request.setAttribute("candidate", candidate);

        PostDetail postDetail = pDAO.getPostDetailById(postD_id);
        List<Feedback> listFB = pDAO.getAllFeedBackByPost(post_id);
        Post post = pDAO.getPostById(post_id);

        List<FeedbackData> listFBdata = new ArrayList<>();

        for (int i = 0; i < listFB.size(); i++) {
            Candidate c = cDAO.getCandidateById(listFB.get(i).getC_id());
            FeedbackData fbData = new FeedbackData(listFB.get(i), c);
            listFBdata.add(fbData);
        }

        PostData data = new PostData(postDetail, listFBdata, post.getDate_start());

        Employer e = eDAO.getEmployerById(data.getPostDetail().getEmp_id());
        Company com = comDAO.getCompanyById(data.getPostDetail().getCom_id());

        request.setAttribute("post", data);
        request.setAttribute("employer", e);
        request.setAttribute("company", com);
        request.getRequestDispatcher("PostDetail.jsp").forward(request, response);

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
