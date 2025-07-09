/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import Dal.AccountDAO;
import Model.Account;
import Model.hashByMD5;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class RecoverPassController extends HttpServlet {

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
            out.println("<title>Servlet RecoverPassController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecoverPassController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("recoverPass_step1.jsp").forward(request, response);
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

        HttpSession session = request.getSession();

        // Nhận data từ recover step 1
        String username = request.getParameter("username");
        AccountDAO aDAO = new AccountDAO();
        Account a = aDAO.checkAccountForRecoverPass(username);

        // Nhận data từ recover step 2
        String ansQ1 = request.getParameter("ansQ1");
        String ansQ2 = request.getParameter("ansQ2");
        
        // Nhận data từ recover step 3
        String newPass = request.getParameter("new");
        String confirmNewPass = request.getParameter("confirmNew");

        // Nếu data từ step 2 và 3 = null => xử lý riêng step 1
        if (ansQ1 == null && ansQ2 == null 
                && newPass == null && confirmNewPass == null) {
            // Nếu  không tìm thấy account chứa username 
            // được truyền thì gửi lại thông báo lỗi
            if (a == null) {
                request.setAttribute("error", "Username not found.");
                request.getRequestDispatcher("recoverPass_step1.jsp").forward(request, response);
            // Ngược lại thì bước sang step 2
            } else {
                session.setAttribute("a_id", a.getA_id());
                request.setAttribute("Q1", a.getQ1());
                request.setAttribute("Q2", a.getQ2());
                request.getRequestDispatcher("recoverPass_step2.jsp").forward(request, response);
            }
        }

        // Nếu data từ step 2 không null => xử lý step 2
        if (ansQ1 != null && ansQ2 != null) {
            String a_id = (String) session.getAttribute("a_id");
            Account a2 = aDAO.getAccountById(a_id);
            // Nếu user trả lời đúng 2 câu hỏi bảo mật sẽ bước sang step 3
            if (a2.getAnQ1().equalsIgnoreCase(ansQ1) 
                    && a2.getAnQ2().equalsIgnoreCase(ansQ2)) {
                session.setAttribute("a_id", a_id);
                request.getRequestDispatcher("recoverPass_step3.jsp").forward(request, response);
            // Ngược lại thì trả về thông báo lỗi
            } else {
                request.setAttribute("error", "Wrong answer.");
                request.getRequestDispatcher("recoverPass_step2.jsp").forward(request, response);
            }              
        }
        
        
        if (newPass!=null && confirmNewPass!=null) {
            String a_id = (String) session.getAttribute("a_id");
            if (newPass.equalsIgnoreCase(confirmNewPass)) {
                hashByMD5 md5 = new hashByMD5();
                aDAO.changePass(a_id, md5.hash(newPass));
                session.removeAttribute(a_id);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Confirm password incorrect.");
                request.getRequestDispatcher("recoverPass_step3.jsp").forward(request, response);
            }
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

}
