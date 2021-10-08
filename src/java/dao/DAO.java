/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Bill;
import entity.BillDetail;
import entity.Category;
import entity.Customer;
import entity.Product;
import entity.ProductSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vu X Phuc
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllproduct() {
        List<Product> list = new ArrayList<>();
        String quenry = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getAllproduct" + e);
        }
        return list;
    }

    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        String quenry = "select * from Customer\n"
                + "except \n"
                + "select * from Customer\n"
                + "where Cid = 0";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("error getAllCustomer" + e);
        }

        return list;
    }

    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String quenry = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("error getCategory" + e);
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String quenry = "select top 9 * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getAllProduct" + e);
        }
        return list;
    }

    public List<Product> getNextAllProduct(int number) {
        List<Product> list = new ArrayList<>();
        String quenry = "SELECT * from Product\n"
                + "ORDER BY Pid \n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT 9 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setInt(1, number);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getNextAllProduct" + e);
        }
        return list;
    }

    public List<Product> getTopProduct() {
        List<Product> list = new ArrayList<>();
        String quenry = "select top 3 * from Product \n"
                + "order by quantity desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getTopProduct" + e);
        }
        return list;
    }

    public List<Product> getProductByCid(String cid) {
        List<Product> list = new ArrayList<>();
        String quenry = "select * from Product \n"
                + "where CaId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getProductByCid" + e);
        }
        return list;
    }

    public List<ProductSale> getProductSaleByCustomerID(String cid) {
        List<ProductSale> list = new ArrayList<>();
        String quenry = "select Product.pUserName, Product.quantity, BillDetail.quantity, BillDetail.price, Product.Pid\n"
                + "from Product, BillDetail\n"
                + "where Product.Pid=BillDetail.Pid and Product.Cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductSale(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println("error getProductSaleByCustomerID" + e);
        }
        return list;
    }
    
    public List<BillDetail> getAllBillDetailByBid(String Bid){
        String quenry = "select * from BillDetail where Bid = ? ";
        List<BillDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, Bid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new BillDetail(rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4)));
            }
            
        } catch (Exception e) {
             System.out.println("error getProductSaleByCustomerID" + e);
        }
        return list;
    }
    
    public List<Product> getProductByCid4(String cid) {
        List<Product> list = new ArrayList<>();
        String quenry = "select top 4 * from Product \n"
                + "where CaId = ?\n"
                + "order by  quantity desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getProductByCid4" + e);
        }
        return list;
    }

    public List<Product> getSearchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String quenry = "select  * from Product \n"
                + "where pUserName like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getSearchByName" + e);
        }
        return list;
    }

    public Product getProductById(String id) {
        String quenry = "select * from Product where Pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("error getProductById" + e);
        }
        return null;
    }
    
    public List<Bill> getAllBill(){
        List<Bill> list = new ArrayList<>();
        String quenry = "select * from Bill ";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Bill(rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("error getAllBill" + e);
        }
        return list;
    }

    public Product getProductIdTop() {
        String quenry = "select Top 1 * from Product order by Pid desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("error getProductIdTop" + e);
        }
        return null;
    }

    public Category getCategoryById(String id) {

        String quenry = "select * from Category \n"
                + "where CaId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Category(rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("error getCategoryById" + e);
        }
        return null;
    }

    public List<Category> getCategoryById() {
        List<Category> list = new ArrayList<>();
        String quenry = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("error getCategoryById" + e);
        }
        return list;
    }

    public Customer login(String user, String pass) {
        String quenry = "select  * from Customer\n"
                + "where cUserName = ?\n"
                + "and cPassWord = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("error login" + e);
        }
        return null;
    }

    public Customer FindCustomerByCid(String Cid) {
        String quenry = "select * from Customer\n"
                + "where [Cid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, Cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("error FindCustomerByCid" + e);
        }
        return null;
    }

    public Customer checkCustomer(String user) {
        String quenry = "select  * from Customer\n"
                + "where cUserName = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("error checkCustomer" + e);
        }
        return null;
    }

    public Customer checkUser() {
        String quenry = "select top 1 * from Customer\n"
                + "order by Cid desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("error checkUser" + e);
        }
        return null;
    }

    public BillDetail getBid() {
        String quenry = "select top 1 * from BillDetail order by Bid desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new BillDetail(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("error getBid" + e);
        }
        return null;
    }

    public void UpdatePass(String pass, String user) {
        String quenry = "update Customer\n"
                + "set  cPassWord = ? \n"
                + "where cUserName = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error UpdatePass" + e);
        }
    }
    
    public void deleteCustomerByCid(String id) {
        String quenry = "delete from Customer\n"
                + "where Cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error deleteCustomerByCid" + e);
        }
    }
    
    public void deleteProductByCid(String id) {
        String quenry = "delete from Product\n"
                + "where Cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error deleteProductByCid" + e);
        }
    }

    
    public void deleteProduct(String id) {
        String quenry = "delete from Product\n"
                + "where Pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error deleteProduct" + e);
        }
    }

    public void SingUp(String user, String pass, String fname, String phone, String address, String num) {
        String quenry = "insert into Customer\n"
                + "values(?, ?, ?, ?, ?, 0, ?, ?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, fname);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, num);
            ps.setString(7, num);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error SingUp" + e);
        }
    }

    public void UpdateCustomer(String fName, String phone, String address, String Cid) {
        String quenry = "update Customer\n"
                + "set [FullName] = ?,\n"
                + "[phone] = ?,\n"
                + "[address] = ?\n"
                + "where [Cid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, fName);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, Cid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error UpdateCustomer" + e);
        }
    }

    public void TakeMoney(double money, String Cid) {
        String quenry = "update Customer\n"
                + "set [money] = ?\n"
                + "where [Cid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setDouble(1, money);
            ps.setString(2, Cid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error TakeMoney" + e);
        }
    }

    public void updateProductWithImage(String pUserName, String image, String price, String quantity, String pDescription, String CaID, String Pid) {
        String quenry = "update Product \n"
                + "set  [pUserName] = ?,\n"
                + " [image] = ?,\n"
                + " [price] = ?,\n"
                + " [quantity] = ?,\n"
                + " [pDescription] = ?,\n"
                + " [CaId] = ?\n"
                + " where [Pid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, pUserName);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, quantity);
            ps.setString(5, pDescription);
            ps.setString(6, CaID);
            ps.setString(7, Pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error updateProductWithImage" + e);
        }
    }

    public void updateProduct(String pUserName, String price, String quantity, String pDescription, String CaID, String Pid) {
        String quenry = "update Product \n"
                + "set  [pUserName] = ?,\n"
                + " [price] = ?,\n"
                + " [quantity] = ?,\n"
                + " [pDescription] = ?,\n"
                + " [CaId] = ?\n"
                + " where [Pid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setString(1, pUserName);
            ps.setString(2, price);
            ps.setString(3, quantity);
            ps.setString(4, pDescription);
            ps.setString(5, CaID);
            ps.setString(6, Pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error updateProduct" + e);
        }
    }

    public void UpdateQuantityProductByPid(int quantity, int Pid) {
        String quenry = "update Product\n"
                + "set [quantity] = ?\n"
                + "where [Pid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setInt(1, quantity);
            ps.setInt(2, Pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error UpdateQuantityProductByPid" + e);
        }
    }

    public void UpdateMoneyCustomerbyCid(double price, int Cid) {
        String quenry = "update Customer\n"
                + "set [money] = ?\n"
                + "where [Cid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setDouble(1, price);
            ps.setInt(2, Cid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error UpdateMoneyCustomerbyCid" + e);
        }
    }

    public void addProduct(int Pid, String pUserName, String image, String price, String quantity, String pDescription, int Cid, String CaID) {
        String quenry = "insert into Product\n"
                + "values(?, ?, ?, ?, ?, 0, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setInt(1, Pid);
            ps.setString(2, pUserName);
            ps.setString(3, image);
            ps.setString(4, price);
            ps.setString(5, quantity);
            ps.setString(6, pDescription);
            ps.setInt(7, Cid);
            ps.setString(8, CaID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error addProduct" + e);
        }
    }

    public void addBillDetail(int Bid, int Pid, int quantity, double price) {
        String quenry = "insert into BillDetail\n"
                + "values(?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setInt(1, Bid);
            ps.setInt(2, Pid);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error addBillDetail" + e);
        }
    }

    public void addBill(int Bid, String dateCreate, double total, String buyName, String buyAddress, String buyPhone) {
        String quenry = "insert into Bill\n"
                + "values(?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setInt(1, Bid);
            ps.setString(2, dateCreate);
            ps.setDouble(3, total);
            ps.setString(4, buyName);
            ps.setString(5, buyAddress);
            ps.setString(6, buyPhone);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error addBill" + e);
        }
    }

    public List<Product> getProductUserByCid(int cid) {
        List<Product> list = new ArrayList<>();
        String quenry = "select * from Product\n"
                + "where Cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql
            ps = conn.prepareStatement(quenry);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("error getProductUserByCid" + e);
        }
        return list;
    }

}
