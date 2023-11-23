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
          <h2 class="text-center">
            Konfirmasi Pesanan
          </h2>
        </div>
        <div class="col-12">
          <form class="row g-2 align-items-center">
            <div class="col-12">
              <div class="fs-6 text-body-secondary">Tanggal / Waktu Masuk</div>
              <div>
                <span class="fw-bold">Rabu, 21 Desember 2022</span>
                <span class="fw-bold">10:00</span>
              </div>
            </div>
            <div class="col-12">
              <div class="fs-6 text-body-secondary">Tanggal / Waktu Keluar</div>
              <div>
                <span class="fw-bold">Rabu, 21 Desember 2022</span>
                <span class="fw-bold">12:00</span>
              </div>
            </div>
            <div class="col-6">
              <div class="fs-6 text-body-secondary">Lantai</div>
              <div>
                <span class="fw-bold">Lantai 1</span>
              </div>
            </div>
            <div class="col-6">
              <div class="fs-6 text-body-secondary">Lahan Parkir</div>
              <div>
                <span class="fw-bold">F2 - 3</span>
              </div>
            </div>
            <div class="col-12 d-grid mt-4">
              <button type="submit" class="btn btn-primary btn-lg">Konfirmasi</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
