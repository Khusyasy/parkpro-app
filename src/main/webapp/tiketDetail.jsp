<%@ page import="com.parkpro.Tiket" %>
<%@ page import="com.parkpro.LahanParkir" %>
<%
    Tiket tiket = (Tiket) request.getAttribute("tiket");
    LahanParkir lahan = (LahanParkir) request.getAttribute("lahan");
    Boolean dibayar = (Boolean) request.getAttribute("dibayar");
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

    <div class="container-fluid d-flex flex-column justify-content-center align-items-center " style="height: 100vh;">
      <div class="row g-0 justify-content-center align-items-center border rounded">
        <div class="col-12">
          <h2 class="text-center m-2">
            Detail Tiket
          </h2>
        </div>
        <hr class="m-0 lh-1">
        <div class="col-12">
          <div class="text-center">
            <img src="/barcode?T=<%= tiket.getId() %>&L=<%= tiket.getLahan() %>"
                 alt="Barcode T<%= tiket.getId() %>L<%= tiket.getLahan() %>" class="img-fluid w-100" style="max-width: 40rem">
          </div>
        </div>
        <hr class="m-0 lh-1">
        <div class="col-12 p-2">
          <div class="text-body-secondary">
            Lahan Parkir:
            <span class="fw-bold">
              <%= lahan.getLantai() %>
              -
              <%= lahan.getLokasi() %>
              -
              <%= lahan.getNomor() %>
            </span>
          </div>
          <div class="text-body-secondary">
            Masuk:
            <span class="fw-bold">
              <%= tiket.getWaktuMasuk() %>
            </span>
          </div>
          <div class="text-body-secondary">
            Keluar:
            <span class="fw-bold">
              <%= tiket.getWaktuKeluar() %>
            </span>
          </div>
          <div class="text-body-secondary">
            Status pembayaran:
            <span class="fw-bold">
              <%= dibayar ? "Sudah dibayar" : "Belum dibayar" %>
            </span>
          </div>
        </div>
        <hr class="m-0 lh-1">
        <div class="col-12 p-2 text-center">
          <div class="text-body-secondary">
            Scan barcode ini ketika memasuki dan meninggalkan area parkir
          </div>
          <div class="text-body-secondary">
            <span class="fw-bold">
              ParkPro
            </span>
          </div>
        </div>
      </div>
      <% if (!dibayar) { %>
      <form class="col-12 d-grid mt-2" action="BayarServlet" method="post">
        <input type="hidden" name="id" id="id" value="<%= tiket.getId() %>">
        <div class="d-grid">
          <button type="submit" class="btn btn-primary">Bayar</button>
        </div>
      </form>
      <% } %>
    <% if (session.getAttribute("errorMessage") != null) { %>
        <div class="alert alert-danger mt-2">
            <%= session.getAttribute("errorMessage") %>
        </div>
        <% session.removeAttribute("errorMessage"); %>
    <% } %>
    <% if (session.getAttribute("successMessage") != null) { %>
        <div class="alert alert-success mt-2">
            <%= session.getAttribute("successMessage") %>
        </div>
        <% session.removeAttribute("successMessage"); %>
    <% } %>
      <div class="col-12 d-grid mt-2">
        <a href="/tiket" class="btn btn-outline-primary">Kembali</a>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
