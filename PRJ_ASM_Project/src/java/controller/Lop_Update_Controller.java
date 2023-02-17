/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.HDTDAO;
import DAO.KhoaDAO;
import DAO.KhoaHocDAO;
import DAO.LopDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HeDT;
import model.Khoa;
import model.KhoaHoc;
import model.Lop;

/**
 *
 * @author admin
 */
@WebServlet(name = "Lop_Update_Controller", urlPatterns = {"/lop_update"})
public class Lop_Update_Controller extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lop_Update_Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Lop_Update_Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        KhoaDAO kdao = new KhoaDAO();
        KhoaHocDAO khdao = new KhoaHocDAO();
        HDTDAO hdao = new HDTDAO();
        String id = request.getParameter("lid");
        LopDAO dao = new LopDAO();
        Lop l = dao.getLopByMaLop(id);
        
        ArrayList<Khoa> listMaKhoa = kdao.getMaKhoaTenKhoa();
        ArrayList<KhoaHoc> listMaKhoaHoc = khdao.getMaKhoaHocTenKhoaHoc();
        ArrayList<HeDT> listMaHDT = hdao.getMaHDTTenHDT();
        
        request.setAttribute("listMaKhoa", listMaKhoa);
        request.setAttribute("listMaKhoaHoc", listMaKhoaHoc);
        request.setAttribute("listMaHDT", listMaHDT);
        request.setAttribute("l", l);
        request.getRequestDispatcher("Lop_Update.jsp").forward(request, response);
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String maLop = request.getParameter("maLop");
        String tenLop = request.getParameter("tenLop");
        String maKhoa = request.getParameter("maKhoa");
        String maHDT = request.getParameter("maHDT");
        String maKhoaHoc = request.getParameter("maKhoaHoc");
        
        LopDAO dao = new LopDAO();
        dao.updateLop(maLop, tenLop, maKhoa, maHDT, maKhoaHoc);
        request.getRequestDispatcher("lop?lindex=1").forward(request, response);
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
