/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Customer;
import entity.ProductSale;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vu X Phuc
 */
public class ChangeInformationControl extends HttpServlet {

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
            String fname = request.getParameter("fname");
            String phone = request.getParameter("phone");
            String addre = request.getParameter("address");
            if (fname.isEmpty() || phone.isEmpty() || addre.isEmpty()) {
                DAO dao = new DAO();
            HttpSession session = request.getSession();
            Customer c = (Customer) session.getAttribute("acc");
            String Cid = String.valueOf(c.getCid());
            List<ProductSale> sale = dao.getProductSaleByCustomerID(Cid);
            request.setAttribute("name", c.getcUserName());
            request.setAttribute("fullName", c.getFullName());
            request.setAttribute("phone", c.getPhone());
            request.setAttribute("addre", c.getAddress());
            request.setAttribute("money", c.getMoney());
            request.setAttribute("listP", sale);
            request.setAttribute("mess", "<div class=\"alert alert-danger\">\n"
                        + "                        Enter your information \n"
                        + "                    </div>");
            request.getRequestDispatcher("ViewCustomer.jsp").forward(request, response);
            } else {
                DAO dao = new DAO();
                HttpSession session = request.getSession();
                Customer c = (Customer) session.getAttribute("acc");
                String Cid = String.valueOf(c.getCid());
                dao.UpdateCustomer(fname, phone, addre, Cid);
                String uName = c.getcUserName();
                String uPass = c.getcPassWord();
                Customer C = dao.login(uName, uPass);
                session.setAttribute("acc", C);
                response.sendRedirect("Customer");
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
