/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import DAO.AccountDAO;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.SinhVien;

/**
 *
 * @author admin
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/khoa","/diem","/lop","/monhoc","/sinhvien","/admin/*"})
public class AuthenticationFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute("acc");
        if(acc !=null){
            chain.doFilter(request, response);
        }else{
            Cookie[] cok = req.getCookies();
        String username = null;
        String password = null;
        for (Cookie cooky : cok) {
            if (cooky.getName().equals("username")) {
                username = cooky.getValue();
            }
            if (cooky.getName().equals("password")) {
                password = cooky.getValue();
            }
            if (username != null && password != null) {
                break;
            }
        }
        if (username != null && password != null) {
            Account accLogin = new AccountDAO().getAcc(username, password);
            if (acc != null) {
                session.setAttribute("acc", acc);
                chain.doFilter(request, response);
                return;
            }
        }
        res.sendRedirect("http://localhost:8080/PRJ_ASM_Project/login");
        }
    }
    @Override
    public void destroy() {        
    }
    @Override
    public void init(FilterConfig filterConfig) {
    }

    
}
