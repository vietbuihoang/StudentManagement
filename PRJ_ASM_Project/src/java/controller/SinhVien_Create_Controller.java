/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LopDAO;
import DAO.SinhVienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Lop;

/**
 *
 * @author admin
 */
@WebServlet(name = "SinhVien_Create_Controller", urlPatterns = {"/sinhvien_create"})
public class SinhVien_Create_Controller extends HttpServlet {

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
            out.println("<title>Servlet SinhVien_Create_Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SinhVien_Create_Controller at " + request.getContextPath() + "</h1>");
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
        LopDAO ldao = new LopDAO();
        ArrayList<Lop> listMaLop = ldao.getMaLop();
        request.setAttribute("listMaLop", listMaLop);
        request.getRequestDispatcher("SinhVien_form.jsp").forward(request, response);
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
        LopDAO ldao = new LopDAO();
        ArrayList<Lop> listMaLop = ldao.getMaLop();
        String maSV = request.getParameter("maSV");
        String tenSV = request.getParameter("tenSV");
        int gioitinh = Integer.parseInt(request.getParameter("gioitinh"));
        String ngaysinh = request.getParameter("ngaysinh");
        String quequan = request.getParameter("quequan");
        String maLop = request.getParameter("maLop");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");

        Pattern ps = Pattern.compile("^[0-9]{10}$");
        Pattern pe = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
        SinhVienDAO dao = new SinhVienDAO();
        if (ps.matcher(sdt).find() && pe.matcher(email).find()) {
            dao.insertSinhVien(maSV, tenSV, gioitinh, ngaysinh, quequan, maLop, sdt, email);
            request.getRequestDispatcher("sinhvien?index=1").forward(request, response);
        } else {
            request.setAttribute("mess1", "Số điện thoại phải gồm 10 ký tự");
            request.setAttribute("mess2", "Email phải đúng định dạng");
            request.setAttribute("listMaLop", listMaLop);
            request.getRequestDispatcher("SinhVien_form.jsp").forward(request, response);
        }
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
