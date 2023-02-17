/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SinhVienDAO;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.SinhVien;

/**
 *
 * @author admin
 */
@WebServlet(name = "SinhVienController", urlPatterns = {"/sinhvien"})
public class SinhVienController extends HttpServlet {

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
        try {
            SinhVienDAO dao = new SinhVienDAO();
            String search = request.getParameter("search");
            String indexstr = request.getParameter("index");
            int index = 1;
            if (indexstr != null) {
                index = Integer.parseInt(indexstr);
            }
            if (search == null) {
                search = "";
            }
            int endPage = 0;
            int pageSize = 5;
            int count = dao.count(search);
            endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }
            Account acc = (Account) request.getSession().getAttribute("acc");
            ArrayList<SinhVien> listSinhVienByUsername = dao.getSinhVienByAccountID(acc.getId());
            ArrayList<SinhVien> listSinhVien = dao.getSearchSinhVien(search, index, pageSize);
            if (listSinhVien.isEmpty()) {
                request.setAttribute("mess", "Không tìm thấy kết quả");
            }
            request.setAttribute("listSinhVienByUsername", listSinhVienByUsername);
            request.setAttribute("search", search);
            request.setAttribute("index", index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("listSV", listSinhVien);
            request.getRequestDispatcher("sinhvien.jsp").forward(request, response);
        } catch (Exception e) {
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
