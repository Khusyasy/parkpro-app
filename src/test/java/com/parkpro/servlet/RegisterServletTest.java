package com.parkpro.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.junit.Test;

import com.parkpro.Database;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author khusyasy
 */
public class RegisterServletTest {
    @Test
    public void testRegisterValid() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        Database DB = new Database();
        DB.executeUpdate("DELETE FROM pengguna WHERE no_telepon = '+62123456789'");

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("0123456789");
        when(request.getParameter("password")).thenReturn("password123");
        when(request.getParameter("gender")).thenReturn("male");
        when(request.getParameter("dob")).thenReturn("1990-01-01");
        when(request.getParameter("nama")).thenReturn("John Doe");

        RegisterServlet instance = new RegisterServlet();
        instance.doPost(request, response);

        verify(session, never()).setAttribute(eq("errorMessage"), anyString());
        verify(response, never()).sendRedirect("register.jsp");
    }

    @Test
    public void testRegisterEmptyFields() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        when(request.getParameter("gender")).thenReturn("");
        when(request.getParameter("dob")).thenReturn("");
        when(request.getParameter("nama")).thenReturn("");

        RegisterServlet instance = new RegisterServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("errorMessage", "Semua input harus diisi");
        verify(response).sendRedirect("register.jsp");
    }

    @Test
    public void testRegisterInvalidPhone() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("1234567890"); // no telepon harus dimulai dengan 0
        when(request.getParameter("password")).thenReturn("password123");
        when(request.getParameter("gender")).thenReturn("male");
        when(request.getParameter("dob")).thenReturn("1990-01-01");
        when(request.getParameter("nama")).thenReturn("John Doe");

        RegisterServlet instance = new RegisterServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("errorMessage", "Nomor telepon harus dimulai dengan 0 untuk negara Indonesia atau kode area (contoh +62)");
        verify(response).sendRedirect("register.jsp");
    }

    @Test
    public void testRegisterInvalidPassword() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(true)).thenReturn(session);
        when(request.getParameter("phone")).thenReturn("0123456789");
        when(request.getParameter("password")).thenReturn("password"); // password harus mengandung angka dan huruf
        when(request.getParameter("gender")).thenReturn("male");
        when(request.getParameter("dob")).thenReturn("1990-01-01");
        when(request.getParameter("nama")).thenReturn("John Doe");

        RegisterServlet instance = new RegisterServlet();
        instance.doPost(request, response);

        verify(session).setAttribute("errorMessage", "Password minimal 8 karakter dan harus mengandung setidaknya satu huruf dan satu angka");
        verify(response).sendRedirect("register.jsp");
    }
}
