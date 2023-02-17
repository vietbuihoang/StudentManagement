/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lop;
import model.SinhVien;

/**
 *
 * @author admin
 */
public class SinhVienDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<SinhVien> getAllSinhVien() {

        try {
            ArrayList<SinhVien> list = new ArrayList<>();
            String sql = "select * from SinhVien";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getDate(4), rs.getString(5),
                        new Lop(rs.getString(6)), rs.getString(7), rs.getString(8));
                list.add(sv);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<SinhVien> getSinhVienByAccountID(int id) {

        try {
            ArrayList<SinhVien> list = new ArrayList<>();
            String sql = "select * from SinhVien where accountId = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getDate(4), rs.getString(5),
                        new Lop(rs.getString(6)), rs.getString(7), rs.getString(8));
                list.add(sv);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int count(String search) {
        try {
            String query = "select COUNT(*) from SinhVien where MaSV LIKE ? or TenSV LIKE ? or QueQuan LIKE ?";
            DBContext db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public ArrayList<SinhVien> getSearchSinhVien(String search, int index, int size) {

        try {
            ArrayList<SinhVien> list = new ArrayList<>();
            String sql = "with x as(select ROW_NUMBER() over (order by MaSV ASC) as r\n"
                    + ",* from SinhVien where MaSV LIKE ? or TenSV LIKE ? or QueQuan LIKE ? or MaLop LIKE ?)\n"
                    + "select * from x where r between ?*4-3 and ?*4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setString(4, "%" + search + "%");
            ps.setInt(5, index);
            ps.setInt(6, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getDate(5), rs.getString(6),
                        new Lop(rs.getString(7)), rs.getString(8), rs.getString(9));
                list.add(sv);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SinhVien getSinhVienByMaSV(String maSV) {
        try {
            String sql = "select * from SinhVien where MaSV = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getDate(4), rs.getString(5),
                        new Lop(rs.getString(6)), rs.getString(7), rs.getString(8));
                return sv;
            }

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<SinhVien> getMaSinhVien() {
        try {
            ArrayList<SinhVien> list = new ArrayList<>();
            String sql = "select MaSV from SinhVien";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1));
                list.add(sv);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertSinhVien(String maSV, String tenSV, int gioiTinh,
            String ngaysinh, String quequan, String maLop, String sdt, String email) {
        try {
            String sql = "insert into SinhVien(MaSV,TenSV,GioiTinh,NgaySinh,QueQuan,MaLop,SDT,Email)\n"
                    + "values(?,?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, tenSV);
            ps.setInt(3, gioiTinh);
            ps.setString(4, ngaysinh);
            ps.setString(5, quequan);
            ps.setString(6, maLop);
            ps.setString(7, sdt);
            ps.setString(8, email);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSinhVien(String maSV, String tenSV, int gioitinh,
            String ngaysinh, String quequan, String maLop, String sdt, String email) {
        try {
            String sql = "Update SinhVien\n"
                    + "Set TenSV = ?, GioiTinh=?, NgaySinh=?, QueQuan = ?, MaLop = ?, SDT = ?, Email = ?\n"
                    + "Where MaSV=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenSV);
            ps.setInt(2, gioitinh);
            ps.setString(3, ngaysinh);
            ps.setString(4, quequan);
            ps.setString(5, maLop);
            ps.setString(6, sdt);
            ps.setString(7, email);
            ps.setString(8, maSV);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteSinhVien(String maSV) {
        try {
            String sql = "Delete from SinhVien where MaSV = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int TongSoSinhVien() {
        try {
            String query = "select COUNT(*) from SinhVien";
            DBContext db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }
    
    public static void main(String[] args) {
        SinhVienDAO dao = new SinhVienDAO();
        
//        for (SinhVien o : dao.getSearchSinhVien("H", 1, 3)) {
//            System.out.println(o);
//        }
//        int count = dao.count("Ha Noi");
//        System.out.println(count);
//        dao.deleteSinhVien("0241060218");
//        System.out.println(dao.getAcc("mra", "123"));
//        System.out.println(dao.getListAcc());
//        System.out.println(dao.TongSoSinhVien());
            System.out.println(dao.getSinhVienByAccountID(2));
        
    }
}
