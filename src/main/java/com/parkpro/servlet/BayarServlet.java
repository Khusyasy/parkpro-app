package com.parkpro.servlet;

import com.parkpro.Database;
import com.parkpro.Pembayaran;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.parkpro.Pengguna;
import com.parkpro.PenggunaDAO;
import com.parkpro.Tiket;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 *
 * @author khusyasy
 */
@WebServlet(name = "BayarServlet", urlPatterns = {"/BayarServlet"})
public class BayarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tiketID = request.getParameter("id");

        if (tiketID == null) {
            response.sendRedirect("/tiket");
            return;
        }

        HttpSession session = request.getSession();

        Database DB;
        try {
            DB = new Database();
        } catch (SQLException ex) {
            session.setAttribute("errorMessage", "Terjadi kesalahan pada database");
            response.sendRedirect("/tiket?id=" + tiketID);
            return;
        }

        try {
            ResultSet rs = DB.executeQuery("SELECT * FROM tiket WHERE id = ?", tiketID);
            if (!rs.next()) {
                session.setAttribute("errorMessage", "Tiket tidak ditemukan");
                response.sendRedirect("/tiket?id=" + tiketID);
                return;
            }
            
            Tiket tiket = new Tiket(rs.getInt("id"), rs.getInt("id_pengguna"), rs.getInt("id_lahan_parkir"),
                    rs.getTimestamp("waktu_masuk"), rs.getTimestamp("waktu_keluar"));

            Timestamp now = new Timestamp(System.currentTimeMillis());
            Pembayaran pembayaran = new Pembayaran(-1, tiket, null, "online", now, -1);
            pembayaran.hitungTarif();

            DB.executeUpdate("INSERT INTO pembayaran (id_tiket, id_pengguna, total_bayar, id_tarif, metode, waktu_bayar) VALUES (?, ?, ?, ?, ?, ?)",
                tiket.getId(),
                tiket.getPengguna(),
                pembayaran.getTotalPembayaran(),
                1,
                pembayaran.getMetodePembayaran(),
                pembayaran.getWaktuBayar());

            DB.executeUpdate("UPDATE lahan_parkir SET tersedia=1 WHERE id = ?", tiket.getLahan());

            session.setAttribute("successMessage", "Pembayaran berhasil dengan total Rp." + pembayaran.getTotalPembayaran());
            response.sendRedirect("/tiket?id=" + tiketID);
        } catch (SQLException ex) {
            throw new ServletException("Database access error", ex);
        }
    }
}
