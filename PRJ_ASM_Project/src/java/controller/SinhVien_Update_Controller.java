/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SinhVienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SinhVien;

/**
 *
 * @author admin
 */
@WebServlet(name = "SinhVien_Update_Controller", urlPatterns = {"/sinhvien_update"})
public class SinhVien_Update_Controller extends HttpServlet {

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
            out.println("<title>Servlet SinhVien_Update_Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SinhVien_Update_Controller at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("sid");
        SinhVienDAO dao = new SinhVienDAO();
        SinhVien s = dao.getSinhVienByMaSV(id);
        request.setAttribute("s", s);
        request.getRequestDispatcher("SinhVien_Update.jsp").forward(request, response);
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
        String tenSV = request.getParameter("tenSV");
        int gioitinh = Integer.parseInt(request.getParameter("gioitinh"));
        String ngaysinh = request.getParameter("ngaysinh");
        String quequan = request.getParameter("quequan");
        String maLop = request.getParameter("maLop");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");

        SinhVienDAO dao = new SinhVienDAO();
        dao.updateSinhVien(maSV, tenSV, gioitinh, ngaysinh, quequan, maLop, sdt, email);
        request.getRequestDispatcher("sinhvien?index=1").forward(request, response);
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
