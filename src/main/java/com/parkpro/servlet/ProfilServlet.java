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
@WebServlet(name = "ProfilServlet", urlPatterns = {"/profil"})
public class ProfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String noTelepon = (String) session.getAttribute("phone");

        if (noTelepon == null || noTelepon.isEmpty()) {
            response.sendRedirect("/login.jsp");
            return;
        }

        try {
            PenggunaDAO penggunaDAO = new PenggunaDAO();
            Pengguna pengguna = penggunaDAO.getPengguna(noTelepon);

            request.setAttribute("pengguna", pengguna);
            request.getRequestDispatcher("/profil.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
