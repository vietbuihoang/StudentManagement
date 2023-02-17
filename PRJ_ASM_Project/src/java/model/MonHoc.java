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
public class MonHoc {
    private int id;
    private String maMH;
    private String tenMH;
    private int tinChi;

    public MonHoc() {
    }

    public MonHoc(String maMH) {
        this.maMH = maMH;
    }

    public MonHoc(int id, String maMH, String tenMH, int tinChi) {
        this.id = id;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.tinChi = tinChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    @Override
    public String toString() {
        return "MonHocDAO{" + "id=" + id + ", maMH=" + maMH + ", tenMH=" + tenMH + ", tinChi=" + tinChi + '}';
    }
    
    
}
