package com.parkpro.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parkpro.Database;
import com.parkpro.LahanParkir;

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
@WebServlet(name = "Pesan2Servlet", urlPatterns = {"/Pesan2Servlet"})
public class Pesan2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_lahan = request.getParameter("id_lahan");

        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            session.setAttribute("errorMessage", "Anda harus login terlebih dahulu");
            response.sendRedirect("login.jsp");
            return;
        }

        if (
            session.getAttribute("datein") == null ||
            session.getAttribute("timein") == null ||
            session.getAttribute("dateout") == null ||
            session.getAttribute("timeout") == null
        ) {
            session.setAttribute("errorMessage", "Semua input harus diisi");
            response.sendRedirect("pesan.jsp");
            return;
        }

        if (id_lahan == null || id_lahan.isEmpty()) {
            session.setAttribute("errorMessage", "Lahan parkir harus dipilih");
            response.sendRedirect("pesan2.jsp");
            return;
        }

        Database DB;
        try {
            DB = new Database();
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("pesan2.jsp");
            return;
        }

        try {
            ResultSet rs = DB.executeQuery("SELECT * FROM lahan_parkir WHERE id = ?", id_lahan);
            if (!rs.next()) {
                session.setAttribute("errorMessage", "Lahan parkir tidak ditemukan");
                response.sendRedirect("pesan2.jsp");
                return;
            }

            LahanParkir lahan = new LahanParkir(rs.getInt("id"), rs.getString("lantai"), rs.getString("lokasi"), rs.getInt("nomor"), rs.getBoolean("tersedia"));
            session.setAttribute("lahan", lahan);
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("pesan2.jsp");
            return;
        }

        response.sendRedirect("pesan3.jsp");
    }
}
