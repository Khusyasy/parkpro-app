<%@ page import="com.parkpro.Pengguna" %>
<%
    if (request == null || request.getAttribute("pengguna") == null) {
        response.sendRedirect("/");
    }
    Pengguna pengguna = (Pengguna) request.getAttribute("pengguna");
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
      <div class="row">
        <div class="col-12">
          <h1 class="text-center">Profil</h1>
        </div>
        <div class="col-12">
          <div class="card">
            <div class="card-body">
              <div class="row">
                <div class="col-6 fw-bold">
                  <p>No Telepon</p>
                </div>
                <div class="col-6">
                  <p>
                    <%= pengguna.getNoTelepon() %>
                  </p>
                </div>
              </div>
              <div class="row">
                <div class="col-6 fw-bold">
                  <p>Jenis Kelamin</p>
                </div>
                <div class="col-6">
                  <p>
                    <%= pengguna.getGender() %>
                  </p>
                </div>
              </div>
              <div class="row">
                <div class="col-6 fw-bold">
                  <p>Tanggal Lahir</p>
                </div>
                <div class="col-6">
                  <p>
                    <%= pengguna.getDateOfBirth() %>
                  </p>
                </div>
              </div>
              <div class="row">
                <div class="col-6 fw-bold">
                  <p>Nama</p>
                </div>
                <div class="col-6">
                  <p>
                    <%= pengguna.getNama() %>
                  </p>
                </div>
              </div>
              <div class="row">
                <div class="col-6 fw-bold">
                  <p>Jenis Kendaraan</p>
                </div>
                <div class="col-6">
                  <p>
                    <%= pengguna.getJenisKendaraan() %>
                  </p>
                </div>
              </div>
            </div>
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
