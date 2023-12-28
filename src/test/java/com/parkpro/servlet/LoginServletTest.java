package com.parkpro.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import com.parkpro.Pengguna;
import com.parkpro.PenggunaDAO;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

/**
 *
 * @author khusyasy
 */
public class LoginServletTest {
    @Test
    public void testLoginValid() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("08123456789");
        when(request.getParameter("password")).thenReturn("abc123456");

        LoginServlet instance = new LoginServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("id", 1);
        verify(session).setAttribute("phone", "+628123456789");
        verify(response).sendRedirect("/");
    }

    @Test
    public void testLoginPasswordSalah() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("08123456789");
        when(request.getParameter("password")).thenReturn("321321321");

        LoginServlet instance = new LoginServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("errorMessage", "Nomor telepon atau password salah");
        verify(response).sendRedirect("login.jsp");
    }

    @Test
    public void testLoginPhoneSalah() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("987654321");
        when(request.getParameter("password")).thenReturn("abc123456");

        LoginServlet instance = new LoginServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("errorMessage",
                "Nomor telepon harus dimulai dengan 0 untuk negara Indonesia atau kode area (contoh +62)");
        verify(response).sendRedirect("login.jsp");
    }

    @Test
    public void testLoginPhoneTidakTerdaftar() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("08111111111");
        when(request.getParameter("password")).thenReturn("abc123456");

        LoginServlet instance = new LoginServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("errorMessage", "Nomor telepon atau password salah");
        verify(response).sendRedirect("login.jsp");
    }
}
