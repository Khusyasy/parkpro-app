package com.parkpro.servlet;

import com.parkpro.PenggunaDAO;
import com.parkpro.Pengguna;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

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

            session.setAttribute("phone", phone);
            response.sendRedirect("index.jsp");
        } catch (SQLException ex) {
            throw new ServletException("Database access error", ex);
        }
    }
}
