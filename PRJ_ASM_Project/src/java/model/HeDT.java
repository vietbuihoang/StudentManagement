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
public class HeDT {

    private String maHDT;
    private String tenHDT;

    public HeDT() {
    }
    
    public HeDT(String maHDT) {
        this.maHDT = maHDT;
    }

    public HeDT(String maHDT, String tenHDT) {
        this.maHDT = maHDT;
        this.tenHDT = tenHDT;
    }

    public String getMaHDT() {
        return maHDT;
    }

    public void setMaHDT(String maHDT) {
        this.maHDT = maHDT;
    }

    public String getTenHDT() {
        return tenHDT;
    }

    public void setTenHDT(String tenHDT) {
        this.tenHDT = tenHDT;
    }

    @Override
    public String toString() {
        return "HeDT{" + "maHDT=" + maHDT + ", tenHDT=" + tenHDT + '}';
    }

}
