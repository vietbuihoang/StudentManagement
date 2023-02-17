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
import model.KhoaHoc;
import model.HeDT;

/**
 *
 * @author admin
 */
public class HDTDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<HeDT> getMaHDTTenHDT() {
        try {
            ArrayList<HeDT> list = new ArrayList<>();
            String sql = "select MaHeDT,TenHeDT from HeDT";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HeDT kh = new HeDT(rs.getString(1), rs.getString(2));
                list.add(kh);
            }
            return list;

        } catch (Exception ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        HDTDAO dao = new HDTDAO();
        for (HeDT o : dao.getMaHDTTenHDT()) {
            System.out.println(o);
        }
    }
}
