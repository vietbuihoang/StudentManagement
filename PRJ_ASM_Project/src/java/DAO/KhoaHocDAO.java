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
import model.Khoa;
import model.KhoaHoc;

/**
 *
 * @author admin
 */
public class KhoaHocDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<KhoaHoc> getMaKhoaHocTenKhoaHoc() {
        try {
            ArrayList<KhoaHoc> list = new ArrayList<>();
            String sql = "select MaKhoaHoc,TenKhoaHoc from KhoaHoc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc(rs.getString(1), rs.getString(2));
                list.add(kh);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        KhoaHocDAO dao = new KhoaHocDAO();
        for (KhoaHoc o : dao.getMaKhoaHocTenKhoaHoc()) {
            System.out.println(o);
        }
    }
    
}
