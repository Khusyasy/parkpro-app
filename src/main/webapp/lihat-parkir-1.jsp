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
    <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">ParkPro</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Features</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid d-flex justify-content-center align-items-center " style="height: 100vh;">
      <div class="row g-2 justify-content-center align-items-center">
        <div class="col-12 mb-2 justify-content-center align-items-center">
          <h2 class="text-center">
            Pesan Parkir
          </h2>
        </div>
        <div class="col-12">
          <form class="row g-3 align-items-center">
            <div class="col-12">
              <label for="datein" class="mb-1">Tanggal / Waktu Masuk</label>
              <div class="input-group" style="height: 58px;">
                <input type="date" class="form-control" id="datein">
                <input type="time" class="form-control" id="timein">
              </div>
            </div>
            <div class="col-12">
              <label for="dateout" class="mb-1">Tanggal / Waktu Keluar</label>
              <div class="input-group" style="height: 58px;">
                <input type="date" class="form-control" id="dateout">
                <input type="time" class="form-control" id="timeout">
              </div>
            </div>
            <div class="col-12 d-grid">
              <button type="submit" class="btn btn-primary btn-lg">Next</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
