/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import Dal.AccountDAO;
import Dal.CandidateDAO;
import Dal.CompanyDAO;
import Dal.EmployerDAO;
import Dal.PostDAO;
import Model.CV;
import Model.Candidate;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ChangeUserProfile extends HttpServlet {

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
            out.println("<title>Servlet ChangeUserProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeUserProfile at " + request.getContextPath() + "</h1>");
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

        String a_id = request.getParameter("a_id");
        request.setAttribute("a_id", a_id);

        EmployerDAO eDAO = new EmployerDAO();
        CompanyDAO comDAO = new CompanyDAO();
        CandidateDAO cDAO = new CandidateDAO();
        PostDAO pDAO = new PostDAO();

        Employer e = eDAO.getEmployerByAccountId(a_id);
        Company com = comDAO.getCompanyByAccountId(a_id);
        Candidate c = cDAO.getCandidateByAccountId(a_id);

        if (e != null && com == null && c == null) {
            List<PostDetail> pDlist = pDAO.getPostDetailByEmpComId(e.getE_id());
            List<Post> pList = new ArrayList<>();
            for (int i = 0; i < pDlist.size(); i++) {
                Post p = pDAO.getPostByPostDetailId(pDlist.get(i).getPostD_id());
                pList.add(p);
            }
            request.setAttribute("code", "E");
            request.setAttribute("accountInfo", e);
            request.setAttribute("postList", pList);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        } else if (e == null && com != null && c == null) {
            List<PostDetail> pDlist = pDAO.getPostDetailByEmpComId(com.getCom_id());
            List<Post> pList = new ArrayList<>();
            for (int i = 0; i < pDlist.size(); i++) {
                Post p = pDAO.getPostByPostDetailId(pDlist.get(i).getPostD_id());
                pList.add(p);
            }
            request.setAttribute("code", "Com");
            request.setAttribute("accountInfo", com);
            request.setAttribute("postList", pList);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        } else {
            List<CV> cvList = pDAO.getAllCvByC_id(c.getC_id());
            for (int i = 0; i < cvList.size(); i++) {
                Post p = pDAO.getPostById(cvList.get(i).getPost_id());
                String job_name = p.getPostDetail().getJob_name();
                cvList.get(i).setPhone(job_name);
            }
            request.setAttribute("code", "C");
            request.setAttribute("accountInfo", c);
            request.setAttribute("cvList", cvList);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        }

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

        String code = request.getParameter("code");
        String a_id = request.getParameter("a_id");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        AccountDAO aDAO = new AccountDAO();
        CandidateDAO cDAO = new CandidateDAO();
        EmployerDAO eDAO = new EmployerDAO();
        CompanyDAO comDAO = new CompanyDAO();

        Employer e = new Employer();
        Candidate c = new Candidate();
        Company com = new Company();

        Employer eNew = new Employer();
        Candidate cNew = new Candidate();
        Company comNew = new Company();

        switch (code) {
            case "E":
                e = eDAO.getEmployerByAccountId(a_id);
                eNew = new Employer(
                        e.getE_id(),
                        name,
                        address,
                        phone,
                        e.getTax(),
                        e.getUpdate_status(),
                        aDAO.getAccountById(a_id)
                );
                aDAO.updateEmployerProfileByE_id(eNew, e.getE_id());
                response.sendRedirect("viewpostcontroller");
                break;
            case "C":
                c = cDAO.getCandidateByAccountId(a_id);
                cNew = new Candidate(
                        c.getC_id(),
                        name,
                        address,
                        phone,
                        c.getC_dob(),
                        null,
                        aDAO.getAccountById(a_id)
                );
                aDAO.updateCandidateProfileByC_id(cNew, c.getC_id());
                response.sendRedirect("viewpostcontroller");
                break;
            case "Com":
                com = comDAO.getCompanyByAccountId(a_id);
                comNew = new Company(
                        com.getCom_id(),
                        name,
                        address,
                        phone,
                        com.getTax(),
                        com.getUpdate_status(),
                        aDAO.getAccountById(a_id)
                );
                aDAO.updateCompanyProfileByCom_id(comNew, com.getCom_id());
                response.sendRedirect("viewpostcontroller");
                break;
        }

        

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
//        Employer e = eDAO.getEmployerByAccountId("A5001");
//        Company c = comDAO.getCompanyByAccountId("A5001");
//        if (e != null) {
//            System.out.println(e.getE_name());
//        } else {
//            System.out.println(c.getCom_name());
//        }
//    }
}
