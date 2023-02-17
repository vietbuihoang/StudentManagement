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
import model.MonHoc;

/**
 *
 * @author admin
 */
public class MonHocDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<MonHoc> getMonHocList() {
        try {
            ArrayList<MonHoc> list = new ArrayList<>();
            String sql = "select id,MaMH,TenMH,SoTrinh from MonHoc order by id ASC";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(mh);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MonHoc> getMonHocListByAccountID(int id) {
        try {
            ArrayList<MonHoc> list = new ArrayList<>();
            String sql = "SELECT dbo.MonHoc.id, dbo.MonHoc.MaMH ,dbo.MonHoc.TenMH, dbo.MonHoc.SoTrinh\n"
                    + "FROM dbo.Diem INNER JOIN\n"
                    + "dbo.MonHoc ON dbo.Diem.MaMH = dbo.MonHoc.MaMH INNER JOIN\n"
                    + "dbo.SinhVien ON dbo.Diem.MaSV = dbo.SinhVien.MaSV\n"
                    + "WHERE (dbo.SinhVien.accountId = ?)"
                    + "order by id ASC";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(mh);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MonHoc> getMaMonHoc() {
        try {
            ArrayList<MonHoc> list = new ArrayList<>();
            String sql = "select MaMH from MonHoc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getString(1));
                list.add(mh);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MonHoc getMonHocById(int id) {
        try {
            String sql = "select id,MaMH,TenMH,SoTrinh from MonHoc where id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return mh;
            }

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateMonHoc(int id, String maMH, String tenMH, int tinchi) {
        try {
            String sql = "Update MonHoc\n"
                    + "Set MaMH = ?, TenMH=?, SoTrinh=?\n"
                    + "Where id=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maMH);
            ps.setString(2, tenMH);
            ps.setInt(3, tinchi);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertMonHoc(String maMH, String tenMH, int tinchi) {
        try {
            String sql = "insert into MonHoc(MaMH,TenMH,SoTrinh)\n"
                    + "values (?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maMH);
            ps.setString(2, tenMH);
            ps.setInt(3, tinchi);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMonHoc(int id) {
        try {
            String sql = "Delete from MonHoc where id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int count(String search) {
        try {
            String query = "select COUNT(*) from MonHoc where MaMH LIKE ? or TenMH LIKE ? ";
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

    public ArrayList<MonHoc> getSearchMonHoc(String search, int index, int size) {

        try {
            ArrayList<MonHoc> list = new ArrayList<>();
            String sql = "with x as(select ROW_NUMBER() over (order by id ASC) as r\n"
                    + ",* from MonHoc where MaMH LIKE ? or TenMH LIKE ?)\n"
                    + "select * from x where r between ?*4-3 and ?*4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setInt(3, index);
            ps.setInt(4, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getInt(5), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(mh);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int TongSoMonHoc() {
        try {
            String query = "select COUNT(*) from MonHoc";
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
        MonHocDAO dao = new MonHocDAO();
//        for (MonHoc o : dao.getMaMonHoc()) {
//            System.out.println(o);
//        }
        System.out.println(dao.getMonHocList());
//        dao.deleteMonHoc(30);
//        int count = dao.count("H");
//        System.out.println(count);
//        for (MonHoc o : dao.getSearchMonHoc("", 1, 4)) {
//            System.out.println(o);
//        }

    }
}
