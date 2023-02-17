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
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private String diaChi;
    private String dienThoai;

    public Khoa() {
    }

    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public Khoa(String maKhoa, String tenKhoa, String diaChi, String dienThoai) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public Khoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
    
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Override
    public String toString() {
        return "Khoa{" + "maKhoa=" + maKhoa + ", tenKhoa=" + tenKhoa + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + '}';
    }

    
    
    
}
