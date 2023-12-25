package com.parkpro.servlet;

import com.parkpro.Pengguna;
import com.parkpro.PenggunaDAO;
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
        String nama = request.getParameter("nama");

        HttpSession session = request.getSession(true);
            
        if (phone == null || phone.isEmpty()
                || password == null || password.isEmpty()
                || gender == null || gender.isEmpty()
                || dob == null || dob.isEmpty()
                || nama == null || nama.isEmpty()) {
            session.setAttribute("errorMessage", "Semua input harus diisi");
            response.sendRedirect("register.jsp");
            return;
        }

        if (phone.startsWith("0")) {
            phone = "+62" + phone.substring(1);
        } else if (!phone.startsWith("+")) {
            session.setAttribute("errorMessage", "Nomor telepon harus dimulai dengan 0 untuk negara Indonesia atau kode area (contoh +62)");
            response.sendRedirect("register.jsp");
            return;
        }

        if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) {
            session.setAttribute("errorMessage", "Password minimal 8 karakter dan harus mengandung setidaknya satu huruf dan satu angka");
            response.sendRedirect("register.jsp");
            return;
        }
        
        try {
            PenggunaDAO penggunaDAO = new PenggunaDAO();
            Pengguna pengguna = new Pengguna(-1, gender, phone, password, dob, nama, "mobil");

            Pengguna check = penggunaDAO.getPengguna(phone);
            if (check != null) {
                session.setAttribute("errorMessage", "Nomor telepon sudah digunakan");
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
