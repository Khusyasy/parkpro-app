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
import java.time.LocalDateTime;

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

        response.sendRedirect("pesan2.jsp");
    }
}
