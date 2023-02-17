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
public class Diem {
    private SinhVien sinhvien;
    private MonHoc monhoc;
    private int hocKy;
    private int diem1;
    private int diem2;

    public Diem() {
    }

    public Diem(SinhVien sinhvien, MonHoc monhoc, int hocKy, int diem1, int diem2) {
        this.sinhvien = sinhvien;
        this.monhoc = monhoc;
        this.hocKy = hocKy;
        this.diem1 = diem1;
        this.diem2 = diem2;
    }

    public SinhVien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(SinhVien sinhvien) {
        this.sinhvien = sinhvien;
    }

    public MonHoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MonHoc monhoc) {
        this.monhoc = monhoc;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getDiem1() {
        return diem1;
    }

    public void setDiem1(int diem1) {
        this.diem1 = diem1;
    }

    public int getDiem2() {
        return diem2;
    }

    public void setDiem2(int diem2) {
        this.diem2 = diem2;
    }

    @Override
    public String toString() {
        return "Diem{" + "sinhvien=" + sinhvien + ", monhoc=" + monhoc + ", hocKy=" + hocKy + ", diem1=" + diem1 + ", diem2=" + diem2 + '}';
    }

    
    
    
}
