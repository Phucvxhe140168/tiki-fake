/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.BillDetail;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vu X Phuc
 */
public class viewBillDetailControl extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();
        String bid = request.getParameter("bid");
        List<BillDetail> list = dao.getAllBillDetailByBid(bid);
        out.println("<div class=\"col-sm-12\">\n"
                + "                                <table class=\"table table-striped table-hover\">"
                + "<tr>\n"
                + "                                        <th>Name Product</th>\n"
                + "                                        <th>Quantity</th>\n"
                + "                                        <th>Price</th>\n"
                + "                                    </tr>");
        for (BillDetail o : list) {
            String pid = o.getPid();
            Product p = dao.getProductById(pid);
            out.println(" <tr>\n"
                    + "                                            <td>" + p.getName() + "</td>\n"
                    + "                                            <td>" + o.getQuantity() + "</td>\n"
                    + "                                            <td>" + o.getPrice() + "</td>\n"
                    + "                                        </tr>");
        }
        out.println("</table>\n"
                + "                            </div>");

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
