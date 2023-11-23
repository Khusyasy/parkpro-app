package com.khusyasy.parkpro.servlet;

import com.khusyasy.parkpro.Pengguna;
import com.khusyasy.parkpro.PenggunaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author khusyasy
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        HttpSession session = request.getSession(true);
        
        try {
            PenggunaDAO penggunaDAO = new PenggunaDAO();
            Pengguna pengguna = new Pengguna(-1, gender, phone, password, dob, "", "");
            
            if (phone == null || phone.isEmpty() || password == null || password.isEmpty() || gender == null || gender.isEmpty() || dob == null || dob.isEmpty()) {
                session.setAttribute("errorMessage", "Semua input harus diisi");
                response.sendRedirect("register.jsp");
                return;
            }

            Pengguna check = penggunaDAO.getPengguna(phone);
            if (check != null) {
                session.setAttribute("errorMessage", "Nomor telepon sudah digunakan");
                response.sendRedirect("register.jsp");
                return;
            }

            if (password.length() < 8) {
                session.setAttribute("errorMessage", "Password minimal 8 karakter");
                response.sendRedirect("register.jsp");
                return;
            }

            if (!gender.equals("male") && !gender.equals("female")) {
                session.setAttribute("errorMessage", "Gender tidak valid");
                response.sendRedirect("register.jsp");
                return;
            }

            penggunaDAO.addPengguna(pengguna);

            session.setAttribute("successMessage", "Sudah berhasil daftar, silahkan login");
            response.sendRedirect("login.jsp");
        } catch (SQLException ex) {
            throw new ServletException("Database access error", ex);
        }
    }
}
