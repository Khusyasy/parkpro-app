<%
    if (session == null || session.getAttribute("phone") == null) {
        response.sendRedirect("login.jsp");
    }
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

    <div class="container-fluid d-flex justify-content-center align-items-center" style="height: 100vh;">
      <div class="row">
        <div class="col-12">
          <a href="/profil.jsp" class="card text-decoration-none mb-3">
            <div class="row g-0">
              <div class="col-2 d-flex justify-content-center align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                  stroke="currentColor" class="ms-2">
                  <path stroke-linecap="round" stroke-linejoin="round"
                    d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z" />
                </svg>

              </div>
              <div class="col-10">
                <div class="card-body">
                  <h5 class="card-title">
                    Lihat Profil
                  </h5>
                  <p class="card-text">
                    Lihat profil anda dan ubah data diri anda
                  </p>
                </div>
              </div>
            </div>
          </a>
        </div>
        <div class="col-12">
          <a href="/tiket.jsp" class="card text-decoration-none mb-3">
            <div class="row g-0">
              <div class="col-2 d-flex justify-content-center align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                  stroke="currentColor" class="ms-2">
                  <path stroke-linecap="round" stroke-linejoin="round"
                    d="M16.5 6v.75m0 3v.75m0 3v.75m0 3V18m-9-5.25h5.25M7.5 15h3M3.375 5.25c-.621 0-1.125.504-1.125 1.125v3.026a2.999 2.999 0 010 5.198v3.026c0 .621.504 1.125 1.125 1.125h17.25c.621 0 1.125-.504 1.125-1.125v-3.026a2.999 2.999 0 010-5.198V6.375c0-.621-.504-1.125-1.125-1.125H3.375z" />
                </svg>
              </div>
              <div class="col-10">
                <div class="card-body">
                  <h5 class="card-title">
                    Lihat Tiket
                  </h5>
                  <p class="card-text">
                    Lihat tiket parkir yang sudah dipesan dan lihat detailnya
                  </p>
                </div>
              </div>
            </div>
          </a>
        </div>
        <div class="col-12">
          <a href="/pesan.jsp" class="card text-decoration-none">
            <div class="row g-0">
              <div class="col-2 d-flex justify-content-center align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                  stroke="currentColor" class="ms-2">
                  <path stroke-linecap="round" stroke-linejoin="round" d="M15 10.5a3 3 0 11-6 0 3 3 0 016 0z" />
                  <path stroke-linecap="round" stroke-linejoin="round"
                    d="M19.5 10.5c0 7.142-7.5 11.25-7.5 11.25S4.5 17.642 4.5 10.5a7.5 7.5 0 1115 0z" />
                </svg>
              </div>
              <div class="col-10">
                <div class="card-body">
                  <h5 class="card-title">
                    Pesan Parkir
                  </h5>
                  <p class="card-text">
                    Lihat lahan parkir yang tersedia dan pesan sekarang juga
                  </p>
                </div>
              </div>
            </div>
          </a>
        </div>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
