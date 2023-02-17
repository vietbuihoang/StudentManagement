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
import model.HeDT;
import model.Khoa;
import model.KhoaHoc;
import model.Lop;

/**
 *
 * @author admin
 */
public class LopDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Lop> getLopList() {
        try {
            ArrayList<Lop> list = new ArrayList<>();
            String sql = "SELECT lop.MaLop,lop.TenLop, HeDT.MaHeDT,HeDT.TenHeDT,Khoa.MaKhoa,khoa.TenKhoa,KhoaHoc.MaKhoaHoc,KhoaHoc.TenKhoaHoc\n"
                    + "FROM dbo.HeDT INNER JOIN\n"
                    + "dbo.Lop ON dbo.HeDT.MaHeDT = dbo.Lop.MaHeDT INNER JOIN\n"
                    + "dbo.Khoa ON dbo.Lop.MaKhoa = dbo.Khoa.MaKhoa INNER JOIN\n"
                    + "dbo.KhoaHoc ON dbo.Lop.MaKhoaHoc = dbo.KhoaHoc.MaKhoaHoc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lop lp = new Lop(rs.getString(1), rs.getString(2),
                        new HeDT(rs.getString(3), rs.getString(4)),
                        new Khoa(rs.getString(5), rs.getString(6)),
                        new KhoaHoc(rs.getString(7), rs.getString(8)));
                list.add(lp);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Lop> getLopListByAccountID(int id) {
        try {
            ArrayList<Lop> list = new ArrayList<>();
            String sql = "SELECT dbo.Lop.MaLop, dbo.Lop.TenLop , dbo.HeDT.TenHeDT , dbo.Lop.MaKhoa , dbo.Khoa.TenKhoa , dbo.KhoaHoc.MaKhoaHoc,dbo.KhoaHoc.TenKhoaHoc ,dbo.HeDT.MaHeDT\n"
                    + "FROM dbo.HeDT INNER JOIN\n"
                    + "dbo.Lop ON dbo.HeDT.MaHeDT = dbo.Lop.MaHeDT INNER JOIN\n"
                    + "dbo.Khoa ON dbo.Lop.MaKhoa = dbo.Khoa.MaKhoa INNER JOIN\n"
                    + "dbo.KhoaHoc ON dbo.Lop.MaKhoaHoc = dbo.KhoaHoc.MaKhoaHoc INNER JOIN\n"
                    + "dbo.SinhVien ON dbo.Lop.MaLop = dbo.SinhVien.MaLop\n"
                    + "WHERE (dbo.SinhVien.accountId = ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lop lp = new Lop(rs.getString(1), rs.getString(2),
                        new HeDT(rs.getString(3), rs.getString(4)),
                        new Khoa(rs.getString(5), rs.getString(6)),
                        new KhoaHoc(rs.getString(7), rs.getString(8)));
                list.add(lp);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Lop> getMaLop() {
        try {
            ArrayList<Lop> list = new ArrayList<>();
            String sql = "select MaLop from Lop";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lop lp = new Lop(rs.getString(1));
                list.add(lp);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Lop getLopByMaLop(String maLop) {
        try {
            String sql = "select MaLop,TenLop,MaHeDT,MaKhoa,MaKhoaHoc from Lop where MaLop = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLop);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lop l = new Lop(rs.getString(1), rs.getString(2),
                        new HeDT(rs.getString(3)),
                        new Khoa(rs.getString(4)),
                        new KhoaHoc(rs.getString(5)));
                return l;
            }

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateLop(String maLop, String tenLop, String maKhoa, String maHDT,
            String maKhoaHoc) {
        try {
            String sql = "Update Lop\n"
                    + "Set TenLop= ?, MaKhoa= ?, MaHeDT = ?,MaKhoaHoc = ?\n"
                    + "Where MaLop = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tenLop);
            ps.setString(2, maKhoa);
            ps.setString(3, maHDT);
            ps.setString(4, maKhoaHoc);
            ps.setString(5, maLop);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertLop(String maLop, String tenLop, String maKhoa, String maHDT, String maKhoaHoc) {
        try {
            String sql = "insert into Lop(MaLop,TenLop,MaKhoa,MaHeDT,MaKhoaHoc)\n"
                    + "values (?,?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLop);
            ps.setString(2, tenLop);
            ps.setString(3, maKhoa);
            ps.setString(4, maHDT);
            ps.setString(5, maKhoaHoc);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLop(String maLop) {
        try {
            String sql = "Delete from Lop where MaLop = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLop);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int count(String search) {
        try {
            String query = "select COUNT(*) from Lop where MaLop LIKE ? or TenLop LIKE ? ";
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

    public ArrayList<Lop> getSearchLop(String search, int index, int size) {

        try {
            ArrayList<Lop> list = new ArrayList<>();
            String sql = "with x as(select ROW_NUMBER() over (order by MaLop ASC) as r\n"
                    + ",lop.MaLop,lop.TenLop,HeDT.TenHeDT,Khoa.MaKhoa,khoa.TenKhoa,KhoaHoc.MaKhoaHoc,KhoaHoc.TenKhoaHoc, HeDT.MaHeDT\n"
                    + "from dbo.HeDT INNER JOIN\n"
                    + "dbo.Lop ON dbo.HeDT.MaHeDT = dbo.Lop.MaHeDT INNER JOIN\n"
                    + "dbo.Khoa ON dbo.Lop.MaKhoa = dbo.Khoa.MaKhoa INNER JOIN\n"
                    + "dbo.KhoaHoc ON dbo.Lop.MaKhoaHoc = dbo.KhoaHoc.MaKhoaHoc\n"
                    + " where lop.MaLop LIKE ? or lop.TenLop LIKE ? or HeDT.TenHeDT LIKE ? or Khoa.TenKhoa LIKE ?)\n"
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
                Lop lp = new Lop(rs.getString(2), rs.getString(3),
                        new HeDT(rs.getString(5), rs.getString(4)),
                        new Khoa(rs.getString(7), rs.getString(6)),
                        new KhoaHoc(rs.getString(9), rs.getString(8)));
                list.add(lp);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int TongSoLop() {
        try {
            String query = "select COUNT(*) from Lop";
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
        LopDAO dao = new LopDAO();
//        for (Lop o : dao.getMaLop()) {
//            System.out.println(o);
//        }
//        dao.insertLop("KT4", "Kinh te 4", "KT", "D01", "K2");
//        System.out.println(dao.getLopByMaLop("KT1"));
//        dao.updateLop("KT1","Kinh te" , "A2", "C01", K10");
//        dao.deleteLop("MD");
//        int count = dao.count("M");
//        System.out.println(count);
//        for (Lop o : dao.getSearchLop("M", 1, 3)) {
//            System.out.println(o);
//        }
        System.out.println(dao.getLopListByAccountID(11));
    }
}
