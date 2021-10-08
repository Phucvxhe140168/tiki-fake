/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Customer;
import entity.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;




/**
 *
 * @author Vu X Phuc
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddProductControl extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    private static final String  UPLOAD_DIR = "img";
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("pname");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");
        String CaId = request.getParameter("category");
        String filename = uploadFile(request);
        HttpSession session = request.getSession();
        Customer c = (Customer) session.getAttribute("acc");
        int Cid = c.getCid();
        DAO dao = new DAO();
        Product pr = dao.getProductIdTop();
        int Pid = pr.getId() + 1;
           dao.addProduct(Pid, name, filename, price, quantity, description, Cid, CaId);
           response.sendRedirect("manageProduct");
    }

    private String uploadFile(HttpServletRequest request) throws IOException, ServletException{
        String fileName="";
        try{
            Part filePart = request.getPart("image");
            fileName = (String) getFileName(filePart);
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new  File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes =  new  byte[1024];
                while((read = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            }finally{
                if(inputStream != null){
                    inputStream.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            }
            
        }catch(Exception e){
            fileName = "";
        }
        return fileName;
    }
    private String  getFileName(Part part){
        final String  partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :"+ partHeader);
        for(String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf('=')+1).trim().replace("\"", "" );
            }
        }
        
        return null;
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
