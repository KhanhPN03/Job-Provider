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
public class SearchPostController extends HttpServlet {

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
            out.println("<title>Servlet SearchPostController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchPostController at " + request.getContextPath() + "</h1>");
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

        String queryString = request.getQueryString();

        if (queryString != null) {
            // Split the query string into individual parameter-value pairs
            String[] params = queryString.split("&");

            for (String param : params) {
                // Split each parameter-value pair into parameter and value
                String[] paramPair = param.split("=");

                if (paramPair.length == 2) {
                    // Retrieve the parameter name and its value
                    String paramName = paramPair[0];
                    String paramValue = paramPair[1];

                    // URL-decode the value to handle special characters
                    paramValue = java.net.URLDecoder.decode(paramValue, "UTF-8");

                    // If the parameter doesn't exist in the request attributes, set it
                    if (request.getAttribute(paramName) == null) {
                        request.setAttribute(paramName, paramValue);
                    }
                }
            }
        }

        // Now you can access the first value of each parameter like this:
        String firstCity = getFirstParameterValue("city", request);
        String firstSalary = getFirstParameterValue("salary", request);
        String firstWorkingHours = getFirstParameterValue("workingHours", request);
        String a_id = getFirstParameterValue("account", request);

        if (a_id != null && a_id.length() > 0 && a_id.charAt(a_id.length() - 1) == '/') {
            a_id = a_id.substring(0, a_id.length() - 1);
        }

        EmployerDAO eDAO = new EmployerDAO();
        CompanyDAO comDAO = new CompanyDAO();
        List<Employer> listEmp = eDAO.getAllEmp();
        List<Company> listCom = comDAO.getAllCom();

        request.setAttribute("listEmp", listEmp);
        request.setAttribute("listCom", listCom);
        request.setAttribute("a_id", a_id);
        request.setAttribute("firstCity", firstCity);
        request.setAttribute("firstSalary", firstSalary);
        request.setAttribute("firstWorkingHours", firstWorkingHours);

        PostDAO pDAO = new PostDAO();

        List<Post> listPostDetailFilter = pDAO.getPostDetailFilter(firstCity, firstWorkingHours, "", "");

        if (!firstSalary.equals("")) {
            switch (firstSalary) {
                case "Ít hơn 5tr":
                    listPostDetailFilter
                            = pDAO.getPostDetailFilter(firstCity, firstWorkingHours, "0", "5000000");
                    break;
                case "5tr-10tr":
                    listPostDetailFilter
                            = pDAO.getPostDetailFilter(firstCity, firstWorkingHours, "5000000", "10000000");
                    break;
                case "10tr-20tr":
                    listPostDetailFilter
                            = pDAO.getPostDetailFilter(firstCity, firstWorkingHours, "10000000", "20000000");
                    break;
                case "20tr-30tr":
                    listPostDetailFilter
                            = pDAO.getPostDetailFilter(firstCity, firstWorkingHours, "20000000", "30000000");
                    break;
                case "Lớn hơn 30tr":
                    listPostDetailFilter
                            = pDAO.getPostDetailFilter(firstCity, firstWorkingHours, "30000000", "100000000");
                    break;
            }
        }
        request.setAttribute("listPost", listPostDetailFilter);

        // Note code
        request.getRequestDispatcher("ListJobs.jsp").forward(request, response);

    }

    private String getFirstParameterValue(String paramName, HttpServletRequest request) {
        String[] values = request.getParameterValues(paramName);
        if (values != null) {
            String tmp = values[0];
            int num = 0;
            for (String value : values) {
                if (tmp.equals(value)) {
                    num++;
                }
            }
            if (num > 1) {
                if (values != null && values.length > 0) {
                    return tmp;
                }
            } else {
                return "";
            }
        }
        return "";
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
