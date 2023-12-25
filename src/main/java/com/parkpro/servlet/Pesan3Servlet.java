package com.parkpro.servlet;

import java.io.IOException;
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
@WebServlet(name = "Pesan3Servlet", urlPatterns = {"/Pesan3Servlet"})
public class Pesan3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        if (session.getAttribute("lahan") == null) {
            session.setAttribute("errorMessage", "Lahan parkir harus dipilih");
            response.sendRedirect("pesan2.jsp");
            return;
        }

        String datein = (String) session.getAttribute("datein");
        String timein = (String) session.getAttribute("timein");
        String dateout = (String) session.getAttribute("dateout");
        String timeout = (String) session.getAttribute("timeout");
        LahanParkir lahan = (LahanParkir) session.getAttribute("lahan");

        Database DB;
        try {
            DB = new Database();
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("pesan3.jsp");
            return;
        }

        try {   
            DB.executeUpdate("UPDATE lahan_parkir SET tersedia=0 WHERE id = ?", lahan.getId());
            DB.executeUpdate("INSERT INTO tiket (id_pengguna, id_lahan_parkir, waktu_masuk, waktu_keluar) VALUES (?, ?, ?, ?)",
                    session.getAttribute("id"),
                    lahan.getId(),
                    datein + " " + timein + ":00",
                    dateout + " " + timeout + ":00");
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database" + session.getAttribute("id") + " " + lahan.getId());
            response.sendRedirect("pesan3.jsp");
            return;
        }

        response.sendRedirect("/tiket");
    }
}
