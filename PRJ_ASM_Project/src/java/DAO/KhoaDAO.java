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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Khoa;

/**
 *
 * @author admin
 */
public class KhoaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Khoa> getKhoaList() {
        try {
            ArrayList<Khoa> list = new ArrayList<>();
            String sql = "select * from Khoa";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Khoa k = new Khoa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(k);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Khoa> getKhoaListByAccountID(int id) {
        try {
            ArrayList<Khoa> list = new ArrayList<>();
            String sql = "SELECT dbo.Khoa.MaKhoa, dbo.Khoa.TenKhoa, dbo.Khoa.DiaChi, dbo.Khoa.DienThoai\n"
                    + "FROM dbo.Khoa INNER JOIN\n"
                    + "dbo.Lop ON dbo.Khoa.MaKhoa = dbo.Lop.MaKhoa INNER JOIN\n"
                    + "dbo.SinhVien ON dbo.Lop.MaLop = dbo.SinhVien.MaLop\n"
                    + "WHERE (dbo.SinhVien.accountId = ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Khoa k = new Khoa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(k);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Khoa> getMaKhoaTenKhoa() {
        try {
            ArrayList<Khoa> list = new ArrayList<>();
            String sql = "select MaKhoa, TenKhoa from khoa";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Khoa k = new Khoa(rs.getString(1), rs.getString(2));
                list.add(k);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Khoa getKhoaByMaKhoa(String maKhoa) {
        try {
            String sql = "select * from khoa where MaKhoa = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maKhoa);
            rs = ps.executeQuery();
            while (rs.next()) {
                Khoa k = new Khoa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return k;
            }

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertKhoa(String maKhoa, String tenKhoa, String diachi, String sdt) {
        try {
            String sql = "insert into Khoa\n"
                    + "values (?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maKhoa);
            ps.setString(2, tenKhoa);
            ps.setString(3, diachi);
            ps.setString(4, sdt);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateKhoa(String maKhoa, String tenKhoa, String diachi, String sdt) {
        try {
            String sql = "Update Khoa\n"
                    + "Set TenKhoa = ?, DiaChi=?, DienThoai=?\n"
                    + "Where MaKhoa=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenKhoa);
            ps.setString(2, diachi);
            ps.setString(3, sdt);
            ps.setString(4, maKhoa);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteKhoa(String maKhoa) {
        try {
            String sql = "Delete from Khoa where MaKhoa = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maKhoa);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int count(String search) {
        try {
            String query = "select COUNT(*) from Khoa where MaKhoa LIKE ? or TenKhoa LIKE ? ";
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

    public ArrayList<Khoa> getSearchKhoa(String search, int index, int size) {

        try {
            ArrayList<Khoa> list = new ArrayList<>();
            String sql = "with x as(select ROW_NUMBER() over (order by MaKhoa ASC) as r\n"
                    + ",* from Khoa where MaKhoa LIKE ? or TenKhoa LIKE ?)\n"
                    + "select * from x where r between ?*4-3 and ?*4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setInt(3, index);
            ps.setInt(4, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                Khoa k = new Khoa(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(k);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int TongSoKhoa() {
        try {
            String query = "select COUNT(*) from Khoa";
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
        KhoaDAO dao = new KhoaDAO();
//        for (Khoa o : dao.getMaKhoaTenKhoa()) {
//            System.out.println(o);
//        }
//        dao.updateKhoa("A1", "Ki thuat", "Tang 5", "1234");
//        dao.deleteKhoa("A1");

//        int count = dao.TongSoKhoa();
//        System.out.println(count);
//        for (Khoa o : dao.getSearchKhoa("K", 1, 3)) {
//            System.out.println(o);
//        }
        System.out.println(dao.getKhoaListByAccountID(10));
    }
}
