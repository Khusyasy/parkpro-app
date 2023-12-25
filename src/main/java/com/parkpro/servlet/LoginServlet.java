package com.parkpro.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.parkpro.Pengguna;
import com.parkpro.PenggunaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author khusyasy
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);
            
        if (phone.startsWith("0")) {
            phone = "+62" + phone.substring(1);
        } else if (!phone.startsWith("+")) {
            session.setAttribute("errorMessage", "Nomor telepon harus dimulai dengan 0 untuk negara Indonesia atau kode area (contoh +62)");
            response.sendRedirect("login.jsp");
            return;
        }
        
        try {
            PenggunaDAO penggunaDAO = new PenggunaDAO();
            Pengguna pengguna = penggunaDAO.getPengguna(phone);

            if (pengguna == null) {
                session.setAttribute("errorMessage", "Nomor telepon atau password salah");
                response.sendRedirect("login.jsp");
                return;
            }

            if (!pengguna.checkPassword(password)) {
                session.setAttribute("errorMessage", "Nomor telepon atau password salah");
                response.sendRedirect("login.jsp");
                return;
            }

            session.setAttribute("id", pengguna.getId());
            session.setAttribute("phone", phone);
            response.sendRedirect("/");
        } catch (SQLException ex) {
            throw new ServletException("Database access error", ex);
        }
    }
}
