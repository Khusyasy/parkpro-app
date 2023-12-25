<%@ page import="com.parkpro.Tiket" %>
<%@ page import="com.parkpro.LahanParkir" %>
<%@ page import="com.google.gson.Gson" %>
<%
  Gson gson = new Gson();
  Tiket[] arrTiket = gson.fromJson((String) request.getAttribute("arrTiket"), Tiket[].class);
  LahanParkir[] arrLahan = gson.fromJson((String) request.getAttribute("arrLahan"), LahanParkir[].class);
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
      <div class="row g-0 justify-content-center align-items-center border rounded">
        <div class="col-12">
          <h2 class="text-center m-4">
            Riwayat Tiket
          </h2>
        </div>
        <hr class="m-0 lh-1">
        <div class="col-12">
          <div class="list-group">
            <% if (arrTiket==null) { %>
              <span class="list-group-item disabled text-center">
                Anda belum memiliki tiket
              </span>
              <% } else { %>
                <% for (int i=0; i < arrTiket.length; i++) { %>
                  <%
                    Tiket tiket = arrTiket[i];
                    LahanParkir lahan = arrLahan[i];
                  %>
                  <a class="list-group-item list-group-item-action" href="/tiket?id=<%= tiket.getId() %>">
                    Tiket <%= tiket.getId() %>
                    |
                    <%= tiket.getTanggalMasuk() %>
                    <%= tiket.getJamMasuk() %>
                  </a>
                <% } %>
              <% } %>
          </div>
        </div>
      </div>
      <div class="col-12 d-grid mt-4">
        <a href="/" class="btn btn-primary">Kembali</a>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
