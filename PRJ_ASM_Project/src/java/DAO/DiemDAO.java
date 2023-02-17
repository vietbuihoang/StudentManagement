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
import model.Diem;
import model.Lop;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author admin
 */
public class DiemDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Diem> getDiemList() {
        try {
            ArrayList<Diem> list = new ArrayList<>();
            String sql = "select * from Diem";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem(new SinhVien(rs.getString(1)),
                        new MonHoc(rs.getString(2)), rs.getInt(3), rs.getInt(4),
                        rs.getInt(5));
                list.add(diem);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Diem> getDiemListByAccountID(int id) {
        try {
            ArrayList<Diem> list = new ArrayList<>();
            String sql = "SELECT dbo.Diem.MaSV, dbo.Diem.MaMH, dbo.Diem.HocKy, dbo.Diem.DiemLan1, dbo.Diem.DiemLan2\n"
                    + "FROM dbo.Diem INNER JOIN\n"
                    + "dbo.SinhVien ON dbo.Diem.MaSV = dbo.SinhVien.MaSV\n"
                    + "WHERE(dbo.SinhVien.accountId = ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem(new SinhVien(rs.getString(1)),
                        new MonHoc(rs.getString(2)), rs.getInt(3), rs.getInt(4),
                        rs.getInt(5));
                list.add(diem);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Diem getDiemByMaSVandMaMH(String maSV, String maMH) {
        try {
            String sql = "select * from Diem where MaSV = ? and MaMH = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, maMH);
            rs = ps.executeQuery();
            while (rs.next()) {
                Diem d = new Diem(new SinhVien(rs.getString(1)),
                        new MonHoc(rs.getString(2)),
                        rs.getInt(3), rs.getInt(4), rs.getInt(5));
                return d;
            }

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateDiem(String maSV, String maMH, int hocky, int diem1, int diem2) {
        try {
            String sql = "Update Diem\n"
                    + "Set HocKy=?, DiemLan1=?, DiemLan2 = ?\n"
                    + "Where MaSV=? and MaMH = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hocky);
            ps.setInt(2, diem1);
            ps.setInt(3, diem2);
            ps.setString(4, maSV);
            ps.setString(5, maMH);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDiem(String maSV, String maMH, int hocKy, int diem1, int diem2) {
        try {
            String sql = "insert into Diem(MaSV,MaMH,HocKy,DiemLan1,DiemLan2)\n"
                    + "values (?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, maMH);
            ps.setInt(3, hocKy);
            ps.setInt(4, diem1);
            ps.setInt(5, diem2);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDiem(String maSV, String maMH) {
        try {
            String sql = "Delete from Diem where MaSV = ? and MaMH = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, maMH);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int count(String search) {
        try {
            String query = "select COUNT(*) from Diem where MaSV LIKE ? or MaMH LIKE ? ";
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

    public ArrayList<Diem> getSearchDiem(String search, int index, int size) {

        try {
            ArrayList<Diem> list = new ArrayList<>();
            String sql = "with x as(select ROW_NUMBER() over (order by MaSV ASC) as r\n"
                    + ",* from Diem where MaSV LIKE ? or MaMH LIKE ?)\n"
                    + "select * from x where r between ?*4-3 and ?*4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setInt(3, index);
            ps.setInt(4, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem(new SinhVien(rs.getString(2)),
                        new MonHoc(rs.getString(3)), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6));
                list.add(diem);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        DiemDAO dao = new DiemDAO();
//        for (Diem o : dao.getDiemList()) {
//            System.out.println(o);
//        }
//        dao.insertDiem("0241060218", "SQL", 2, 5, 1);
//        System.out.println(dao.getDiemByMaSVandMaMH("111111","A1"));
//        dao.deleteDiem("H6");
//        int count = dao.count("S");
//        System.out.println(count);
//        for (Diem o : dao.getSearchDiem("S", 1, 3)) {
//            System.out.println(o);
//        }
        System.out.println(dao.getDiemListByAccountID(10));
    }
}
