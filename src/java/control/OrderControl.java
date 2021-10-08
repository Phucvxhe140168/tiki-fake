/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.BillDetail;
import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vu X Phuc
 */
public class OrderControl extends HttpServlet {

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
        Cookie arr[] = request.getCookies();
        DAO dao = new DAO();
        PrintWriter out = response.getWriter();
        List<Product> list = new ArrayList<>();
        HttpSession session = request.getSession();
        Customer c = (Customer) session.getAttribute("acc");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        BillDetail bd = dao.getBid();
        int dib = Integer.parseInt(bd.getBid()) + 1;
        request.setAttribute("billid", dib);
        request.setAttribute("date", formatter.format(date));
        if(c != null){
            
            request.setAttribute("Name", c.getFullName());
            request.setAttribute("Add", c.getAddress());
            request.setAttribute("Phone", c.getPhone());
        } else{
            request.setAttribute("Name", "");
            request.setAttribute("Add", "");
            request.setAttribute("Phone", "");
        }
        for (Cookie o : arr) {
            if (o.getName().equals("pid")) {
                String txt[] = o.getValue().split(",");
                for (String s : txt) {
                    list.add(dao.getProductById(s));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getId() == list.get(j).getId()){
                    count++;
                    list.remove(j);
                    j--;
                    list.get(i).setWillsale(count);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getWillsale()==0){
                list.get(i).setWillsale(1);
            }
        }
        double total = 0;
        for (Product o : list) {
            total = total + o.getWillsale()* o.getPrice();
        }
        int size = list.size();
        if(size == 0){
            response.sendRedirect("homeControl");
        } else{
        request.setAttribute("list", list);
        request.setAttribute("vat", 0.1 * total);
        request.setAttribute("sum", 1.1 * total);
        request.getRequestDispatcher("CheckOut.jsp").forward(request, response);}
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
