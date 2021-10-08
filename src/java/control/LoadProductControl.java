/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vu X Phuc
 */
@WebServlet(name = "LoadProductControl", urlPatterns = {"/LoadMore"})
public class LoadProductControl extends HttpServlet {

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
        DAO dao = new DAO();
        String number = request.getParameter("numProduct");
        int numProduct = Integer.parseInt(number);
        List<Product> list = dao.getNextAllProduct(numProduct);
        PrintWriter out = response.getWriter();

        for (Product o : list) {
            out.println("<div class=\" Productnum col-md-4 col-xs-6 \">\n" +
"                                    <div class=\"product\">\n" +
"                                        <div class=\"product-img\">\n" +
"                                            <img src=\"./img/"+o.getImage()+"\" alt=\"\" style=\"width:270px;height:380px;\">\n" +
"                                        </div>\n" +
"                                        <div class=\"product-body\">\n" +
"                                            <h3 class=\"product-name\"><a href=\"detail?pid="+o.getId()+"&Category="+o.getCaID()+"\">"+o.getName()+" </a></h3>\n" +
"                                            <h4 class=\"product-price\">"+o.getPrice()+" $</h4>\n" +
"                                        </div>\n" +
"                                            <div class=\"add-to-cart\">\n" +
"                                                <button id=\""+o.getId()+"\" onclick=\"Addproduct(this.id)\"  class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> add to cart</button>\n" +
"                                            </div>\n" +
"                                    </div>\n" +
"                                </div>");
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
