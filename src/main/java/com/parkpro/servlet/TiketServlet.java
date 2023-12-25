package com.parkpro.servlet;

import com.google.gson.Gson;
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
import java.util.ArrayList;

/**
 *
 * @author khusyasy
 */
@WebServlet(name = "TiketServlet", urlPatterns = {"/tiket"})
public class TiketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            session.setAttribute("errorMessage", "Anda harus login terlebih dahulu");
            response.sendRedirect("login.jsp");
            return;
        }

        String tiketID = request.getParameter("id");

        Database DB;
        try {
            DB = new Database();
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("/");
            return;
        }
        
        try {
            if (tiketID != null && !tiketID.isEmpty()) {
                ResultSet rs = DB.executeQuery("SELECT t.*, lp.* FROM tiket t JOIN lahan_parkir lp ON t.id_lahan_parkir = lp.id WHERE t.id = ?", tiketID);
                if (!rs.next()) {
                    session.setAttribute("errorMessage", "Tiket tidak ditemukan");
                    response.sendRedirect("/tiket");
                    return;
                }
                Tiket tiket = new Tiket(rs.getInt("id"), rs.getInt("id_pengguna"), rs.getInt("id_lahan_parkir"), rs.getTimestamp("waktu_masuk"), rs.getTimestamp("waktu_keluar"));
                request.setAttribute("tiket", tiket);

                LahanParkir lahan = new LahanParkir(rs.getInt("id"), rs.getString("lantai"), rs.getString("lokasi"), rs.getInt("nomor"), rs.getBoolean("tersedia"));
                request.setAttribute("lahan", lahan);

                request.getRequestDispatcher("tiketDetail.jsp").forward(request, response);
            } else {
                ResultSet rs = DB.executeQuery("SELECT t.*, lp.* FROM tiket t JOIN lahan_parkir lp ON t.id_lahan_parkir = lp.id WHERE t.id_pengguna = ? ORDER BY t.id DESC LIMIT 5", session.getAttribute("id"));
                ArrayList<Tiket> arrTiket = new ArrayList<>();
                ArrayList<LahanParkir> arrLahan = new ArrayList<>();
                while (rs.next()) {
                    Tiket tiket = new Tiket(rs.getInt("id"), rs.getInt("id_pengguna"), rs.getInt("id_lahan_parkir"), rs.getTimestamp("waktu_masuk"), rs.getTimestamp("waktu_keluar"));
                    LahanParkir lahan = new LahanParkir(rs.getInt("id"), rs.getString("lantai"), rs.getString("lokasi"), rs.getInt("nomor"), rs.getBoolean("tersedia"));
                    arrTiket.add(tiket);
                    arrLahan.add(lahan);
                }

                Gson gson = new Gson();
                request.setAttribute("arrTiket", gson.toJson(arrTiket));
                request.setAttribute("arrLahan", gson.toJson(arrLahan));

                request.getRequestDispatcher("tiket.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("/");
        }
    }
}
