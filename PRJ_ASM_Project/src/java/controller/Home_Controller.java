/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AccountDAO;
import DAO.KhoaDAO;
import DAO.LopDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author admin
 */
@WebServlet(name = "Home_Controller", urlPatterns = {"/home"})
public class Home_Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        KhoaDAO dao1 = new KhoaDAO();
        MonHocDAO dao2 = new MonHocDAO();
        SinhVienDAO dao3 = new SinhVienDAO();
        LopDAO dao4 = new LopDAO();
        
        int countKhoa = dao1.TongSoKhoa();
        int countMonHoc = dao2.TongSoMonHoc();
        int countSinhVien = dao3.TongSoSinhVien();
        int countLop = dao4.TongSoLop();
        
        AccountDAO dao = new AccountDAO();
        ArrayList<Account> listAcc = dao.getListAcc();
        request.setAttribute("listAcc", listAcc);
        request.setAttribute("countKhoa", countKhoa);
        request.setAttribute("countMonHoc", countMonHoc);
        request.setAttribute("countSinhVien", countSinhVien);
        request.setAttribute("countLop", countLop);
        
        System.out.println(request.getAttribute("countKhoa"));
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
