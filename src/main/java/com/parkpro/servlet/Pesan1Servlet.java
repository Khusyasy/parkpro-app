package com.parkpro.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
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
@WebServlet(name = "Pesan1Servlet", urlPatterns = {"/Pesan1Servlet"})
public class Pesan1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String datein = request.getParameter("datein");
        String timein = request.getParameter("timein");
        String dateout = request.getParameter("dateout");
        String timeout = request.getParameter("timeout");

        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            session.setAttribute("errorMessage", "Anda harus login terlebih dahulu");
            response.sendRedirect("login.jsp");
            return;
        }
        
        if (datein == null || datein.isEmpty() || timein == null || timein.isEmpty() || dateout == null || dateout.isEmpty() || timeout == null || timeout.isEmpty()) {
            session.setAttribute("errorMessage", "Semua input harus diisi");
            response.sendRedirect("pesan.jsp");
            return;
        }
        
        LocalDateTime inDateTime = LocalDateTime.parse(datein + "T" + timein);
        LocalDateTime outDateTime = LocalDateTime.parse(dateout + "T" + timeout);
        LocalDateTime now = LocalDateTime.now();

        if (inDateTime.isBefore(now) || outDateTime.isBefore(now)) {
            session.setAttribute("errorMessage", "Tanggal dan waktu tidak boleh di masa lalu");
            response.sendRedirect("pesan.jsp");
            return;
        }
        
        session.setAttribute("datein", datein);
        session.setAttribute("timein", timein);
        session.setAttribute("dateout", dateout);
        session.setAttribute("timeout", timeout);
        
        Database DB;
        try {
            DB = new Database();
        } catch (SQLException ex) {
            Logger.getLogger(Pesan1Servlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        ArrayList<LahanParkir> arrLahan = new ArrayList<>();
        ResultSet rs;
        try {
            rs = DB.executeQuery("SELECT * FROM lahan_parkir");
            while (rs.next()) {
                LahanParkir lahan = new LahanParkir(rs.getInt("id"), rs.getString("lantai"), rs.getString("lokasi"), rs.getInt("nomor"), rs.getBoolean("tersedia"));
                arrLahan.add(lahan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pesan1Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // lantai dan lokasi yang unik
        ArrayList<String> arrLantai = new ArrayList<>();
        ArrayList<String> arrLokasi = new ArrayList<>();
        for (int i = 0; i < arrLahan.size(); i++) {
            if (!arrLantai.contains(arrLahan.get(i).getLantai())) {
                arrLantai.add(arrLahan.get(i).getLantai());
            }
            if (!arrLokasi.contains(arrLahan.get(i).getLokasi())) {
                arrLokasi.add(arrLahan.get(i).getLokasi());
            }
        }
        
        Gson gson = new Gson();

        session.setAttribute("arrLahan", gson.toJson(arrLahan));
        session.setAttribute("arrLantai", arrLantai.toArray(String[]::new));
        session.setAttribute("arrLokasi", gson.toJson(arrLokasi));

        response.sendRedirect("pesan2.jsp");
    }
}
