<%@ page import="com.parkpro.LahanParkir" %>
<%
    if (session == null || session.getAttribute("id") == null) {
        response.sendRedirect("login.jsp");
    }
    if (session == null || session.getAttribute("lahan") == null) {
        response.sendRedirect("pesan2.jsp");
    }
    LahanParkir lahan = (LahanParkir) session.getAttribute("lahan");
%>
<!doctype html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ParkPro</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/main.css">
  </head>

  <body>
    <jsp:include page="navbar.jsp" />

    <div class="container-fluid d-flex justify-content-center align-items-center " style="height: 100vh;">
      <div class="row g-2 justify-content-center align-items-center">
        <div class="col-12 mb-2 justify-content-center align-items-center">
            <% if (session.getAttribute("errorMessage") != null) { %>
                <div class="alert alert-danger">
                    <%= session.getAttribute("errorMessage") %>
                </div>
                <% session.removeAttribute("errorMessage"); %>
            <% } %>
            <% if (session.getAttribute("successMessage") != null) { %>
                <div class="alert alert-success">
                    <%= session.getAttribute("successMessage") %>
                </div>
                <% session.removeAttribute("successMessage"); %>
            <% } %>
          <h2 class="text-center">
            Konfirmasi Pesanan
          </h2>
        </div>
        <div class="col-12">
          <form class="row g-2 align-items-center" action="Pesan3Servlet" method="post">
            <div class="col-12">
              <div class="fs-6 text-body-secondary">Tanggal / Waktu Masuk</div>
              <div>
                <span class="fw-bold">
                  <%= session.getAttribute("datein") %>
                </span>
                /
                <span class="fw-bold">
                  <%= session.getAttribute("timein") %>
                </span>
              </div>
            </div>
            <div class="col-12">
              <div class="fs-6 text-body-secondary">Tanggal / Waktu Keluar</div>
              <div>
                <span class="fw-bold">
                  <%= session.getAttribute("dateout") %>
                </span>
                /
                <span class="fw-bold">
                  <%= session.getAttribute("timeout") %>
                </span>
              </div>
            </div>
            <div class="col-6">
              <div class="fs-6 text-body-secondary">Lantai</div>
              <div>
                <span class="fw-bold">Lantai <%= lahan.getLantai() %></span>
              </div>
            </div>
            <div class="col-6">
              <div class="fs-6 text-body-secondary">Lahan Parkir</div>
              <div>
                <span class="fw-bold"><%= lahan.getLokasi() %> - <%= lahan.getNomor() %></span>
              </div>
            </div>
            <div class="col-12 mt-4">
              <div class="d-grid">
                <button type="submit" class="btn btn-primary">Konfirmasi</button>
              </div>
              <div class="d-grid mt-2">
                <a href="/pesan2.jsp" class="btn btn-outline-primary">Kembali</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
