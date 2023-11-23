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
            My Ticket
          </h2>
        </div>
        <hr class="m-0 lh-1">
        <div class="col-12">
          <div class="pb-2">
            <img src="/images/barcode.png" alt="Barcode XYZ" class="img-fluid">
            <div class="text-body-secondary text-center">
              1234567890
            </div>
          </div>
        </div>
        <hr class="m-0 lh-1">
        <div class="col-12 p-2">
          <div class="text-body-secondary">
            Lokasi Parkir:
            <span class="fw-bold">
              Lantai 1 - F2 - 3
            </span>
          </div>
          <div class="text-body-secondary">
            Dipesan:
            <span class="fw-bold">
              Rabu, 21 Desember 2022, 8:35
            </span>
          </div>
          <div class="text-body-secondary">
            Masuk:
            <span class="fw-bold">
              Rabu, 21 Desember 2022, 10:00
            </span>
          </div>
          <div class="text-body-secondary">
            Keluar:
            <span class="fw-bold">
              Rabu, 21 Desember 2022, 12:00
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
      <div class="col-12 d-grid mt-4">
        <a href="#" class="btn btn-primary">Kembali</a>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
