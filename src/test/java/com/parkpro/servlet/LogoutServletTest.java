package com.parkpro.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author khusyasy
 */
public class LogoutServletTest {
    @Test
    public void testLogoutWhenLogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(false)).thenReturn(session);

        LogoutServlet instance = new LogoutServlet();
        instance.doGet(request, response);

        verify(session).invalidate();
        verify(response).sendRedirect("login.jsp");
    }

    @Test
    public void testLogoutWhenNotLogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getSession(false)).thenReturn(null);

        LogoutServlet instance = new LogoutServlet();
        instance.doGet(request, response);

        verify(response).sendRedirect("login.jsp");
    }
}
