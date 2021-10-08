/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vu X Phuc
 */
public class DoneBillControl extends HttpServlet {

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
        int billID = Integer.parseInt(request.getParameter("billid"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String dateC = request.getParameter("date");
        if(name.isEmpty()||address.isEmpty()||phone.isEmpty()){
            response.sendRedirect("Order");
        } else{
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
        dao.addBill(billID, dateC, total, name, address, phone);
        
        for (int i = 0; i < list.size(); i++) {
            String Cid = list.get(i).getCid();
            Customer customer = dao.FindCustomerByCid(Cid);
            int Pid = list.get(i).getId();
            int willshare = list.get(i).getWillsale();
            double price = list.get(i).getPrice();
            double money = price - price*0.1 + customer.getMoney();
            int quaniry = list.get(i).getQuantity() - willshare;
            dao.UpdateMoneyCustomerbyCid(money, Integer.parseInt(Cid));
            dao.UpdateQuantityProductByPid(quaniry, Pid);
            dao.addBillDetail(billID, Pid, willshare, price);
        }

        for (Cookie o : arr) {
            o.setMaxAge(0);
            response.addCookie(o);
        }
        
        response.sendRedirect("Blank.jsp");
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
