package model;

import model.Khoa;
import model.KhoaHoc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Lop {

    private String maLop;
    private String tenLop;
    private Khoa khoa;
    private HeDT heDT;
    private KhoaHoc khoahoc;

    public Lop() {
    }
    
    public Lop(String maLop) {
        this.maLop = maLop;
    }

    public Lop(String maLop, String tenLop,HeDT heDT, Khoa khoa, KhoaHoc khoahoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoa = khoa;
        this.heDT = heDT;
        this.khoahoc = khoahoc;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public HeDT getHeDT() {
        return heDT;
    }

    public void setHeDT(HeDT heDT) {
        this.heDT = heDT;
    }

    public KhoaHoc getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(KhoaHoc khoahoc) {
        this.khoahoc = khoahoc;
    }

    @Override
    public String toString() {
        return "Lop{" + "maLop=" + maLop + ", tenLop=" + tenLop + ", khoa=" + khoa + ", heDT=" + heDT + ", khoahoc=" + khoahoc + '}';
    }
}
