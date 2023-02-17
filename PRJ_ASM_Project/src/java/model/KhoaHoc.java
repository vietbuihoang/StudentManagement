/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class KhoaHoc {
    private String maKH;
    private String tenKH;

    public KhoaHoc() {
    }

    public KhoaHoc(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
    }

    public KhoaHoc(String maKH) {
        this.maKH = maKH;
    }
    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    @Override
    public String toString() {
        return "KhoaHoc{" + "maKH=" + maKH + ", tenKH=" + tenKH + '}';
    }
 
    
    
}
