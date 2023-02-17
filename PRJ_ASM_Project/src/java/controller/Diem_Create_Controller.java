/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DiemDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author admin
 */
@WebServlet(name = "Diem_Create_Controller", urlPatterns = {"/diem_create"})
public class Diem_Create_Controller extends HttpServlet {

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
            out.println("<title>Servlet Diem_Create_Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Diem_Create_Controller at " + request.getContextPath() + "</h1>");
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
        MonHocDAO mhdao = new MonHocDAO();
        SinhVienDAO svdao = new SinhVienDAO();
        ArrayList<MonHoc> listMaMH = mhdao.getMaMonHoc();
        ArrayList<SinhVien> listMaSV = svdao.getMaSinhVien();
        
        request.setAttribute("listMaMH", listMaMH);
        request.setAttribute("listMaSV", listMaSV);
        
        request.getRequestDispatcher("Diem_form.jsp").forward(request, response);
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
        String maSV = request.getParameter("maSV");
        String maMH = request.getParameter("maMH");
        int hocKy = Integer.parseInt(request.getParameter("hocky"));
        int diem1 = Integer.parseInt(request.getParameter("diem1"));
        int diem2 = Integer.parseInt(request.getParameter("diem2"));
        
        DiemDAO dao = new DiemDAO();
        dao.insertDiem(maSV, maMH, hocKy, diem1, diem2);
        request.getRequestDispatcher("diem?dindex=1").forward(request, response);
        
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
