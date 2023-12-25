package com.parkpro.servlet;

import com.parkpro.BarcodeCreator;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author khusyasy
 */
@WebServlet(name = "BarcodeServlet", urlPatterns = {"/barcode"})
public class BarcodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String T = (String) request.getParameter("T");
        String L = (String) request.getParameter("L");
        
        if (T == null || L == null) {
            return;
        }
        
        String code = "T"+T+"L"+L;
        String filename = BarcodeCreator.path + code + ".png";

        try (InputStream in = new FileInputStream(filename); ServletOutputStream out = response.getOutputStream()) {
            response.setContentType("image/png");

            byte[] buffer = new byte[512];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        }
    }
}
