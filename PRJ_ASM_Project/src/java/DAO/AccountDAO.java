/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author admin
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account getAcc(String user, String pass) {

        try {
            String sql = "select * from Account where username = ? and password = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertAcc(String user, String pass, String display, String email, String phone, String role) {
        try {
            String sql = "insert into Account\n"
                    + "values(?,?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, display);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, role);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAcc(String username, String password, String displayname, String email,
            String phone, String role, int id) {
        try {
            String sql = "Update Account\n"
                    + "Set username = ?, password = ?, displayname = ?, email = ?, phone = ?, role = ?\n"
                    + "where Id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, displayname);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, role);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAcc(int id) {
        try {
            String sql = "Delete from Account where Id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
//        System.out.println(dao.getAllListAcc());
        //dao.updateAcc("mra", "123", "MR ASAP", "mra@gmail.com", "0912391238", "ADMIN", 7);
        System.out.println(dao.getAcc("viet02", "viet01abc"));
    }

    public ArrayList<Account> getListAcc() {
        try {
            ArrayList<Account> list = new ArrayList<>();
            String sql = "select * from Account where role = 'USER'";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(acc);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getAccByID(int id) {
        try {
            String sql = "select * from Account where Id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                return acc;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Account> getAllListAcc() {
        try {
            ArrayList<Account> list = new ArrayList<>();
            String sql = "select * from Account";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(acc);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int count(String search) {
        try {
            String query = "select COUNT(*) from Account where username LIKE ? or role LIKE ? ";
            DBContext db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public ArrayList<Account> getSearchAccount(String search, int index, int size) {

        try {
            ArrayList<Account> list = new ArrayList<>();
            String sql = "with x as(select ROW_NUMBER() over (order by ID ASC) as r\n"
                    + ",* from Account where username LIKE ? or role LIKE ?)\n"
                    + "select * from x where r between ?*4-3 and ?*4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setInt(3, index);
            ps.setInt(4, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                list.add(acc);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    

}
