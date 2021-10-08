/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vu X Phuc
 */
public class RegisterControl extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            String fName = request.getParameter("r_fName");
            String Phone = request.getParameter("r_phone");
            String Address = request.getParameter("r_address");
            String Username = request.getParameter("r_user");
            String Password = request.getParameter("r_pass");
            String re_Password = request.getParameter("r_repass");
            if (!Password.equals(re_Password)) {
                request.setAttribute("mess", "<div class=\"alert alert-danger\">\n"
                        + "                        Wrong  Re-PassWord\n"
                        + "                    </div>");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                DAO dao = new DAO();
                Customer c = dao.checkCustomer(Username);
                if (c == null) {
                    Customer cu = dao.checkUser();
                    int n = cu.getCid() + 1;
                    dao.SingUp(Username, Password, fName, Phone, Address, String.valueOf(n));
                    request.getRequestDispatcher("homeControl").forward(request, response);
                } else {
                    request.setAttribute("mess", "<div class=\"alert alert-danger\">\n"
                            + "                        User already exist \n"
                            + "                    </div>");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }

            }

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
        processRequest(request, response);
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
