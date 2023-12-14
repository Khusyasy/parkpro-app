package com.parkpro.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parkpro.Database;
import com.parkpro.LahanParkir;
import com.parkpro.Tiket;

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
@WebServlet(name = "TiketServlet", urlPatterns = {"/TiketServlet"})
public class TiketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            session.setAttribute("errorMessage", "Anda harus login terlebih dahulu");
            response.sendRedirect("login.jsp");
            return;
        }

        Database DB;
        try {
            DB = new Database();
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("index.jsp");
            return;
        }
        
        try {
            ResultSet rs = DB.executeQuery("SELECT * FROM tiket WHERE id_pengguna = ? ORDER BY id DESC LIMIT 1", session.getAttribute("id"));
            if (!rs.next()) {
                session.setAttribute("errorMessage", "Belum ada tiket yang dipesan");
                response.sendRedirect("index.jsp");
                return;
            }
            Tiket tiket = new Tiket(rs.getInt("id"), rs.getInt("id_pengguna"), rs.getInt("id_lahan_parkir"), rs.getTimestamp("waktu_masuk"), rs.getTimestamp("waktu_keluar"));
            request.setAttribute("tiket", tiket);

            rs = DB.executeQuery("SELECT * FROM lahan_parkir WHERE id = ?", tiket.getLahan());
            if (!rs.next()) {
                session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
                response.sendRedirect("index.jsp");
                return;
            }
            LahanParkir lahan = new LahanParkir(rs.getInt("id"), rs.getString("lantai"), rs.getString("lokasi"), rs.getInt("nomor"), rs.getBoolean("tersedia"));
            request.setAttribute("lahan", lahan);
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("index.jsp");
            return;
        }
        
        request.getRequestDispatcher("tiket.jsp").forward(request, response);
    }
}
