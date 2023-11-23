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

    <div class="container-fluid d-flex justify-content-center align-items-center">
      <div class="row g-2 justify-content-between align-items-center"
        style="height: calc(100vh - 40px); margin-top: 40px;">
        <div class="col-12">
          <label for="lantai" class="visually-hidden">Lantai</label>
          <select class="form-select" id="lantai" style="height: 58px;">
            <option selected>Lantai</option>
            <option value="B">Lantai B</option>
            <option value="G">Lantai G</option>
            <option value="1">Lantai 1</option>
            <option value="2">Lantai 2</option>
            <option value="3">Lantai 3</option>
          </select>
          <div class="p-2 mt-2">
            <div class="d-flex align-items-center justify-content-start g-2">
              <div class="parkir-box-small parkir-red"></div>
              <div class="ms-2">
                Lahan Penuh
              </div>
            </div>
            <div class="d-flex align-items-center justify-content-start g-2">
              <div class="parkir-box-small parkir-green"></div>
              <div class="ms-2">
                Lahan Tersedia
              </div>
            </div>
            <div class="d-flex align-items-center justify-content-start g-2">
              <div class="parkir-box-small parkir-blue"></div>
              <div class="ms-2">
                Lahan Terpilih
              </div>
            </div>
          </div>
        </div>
        <div class="col-12">
          <div class="row row-cols-auto bg-body-secondary p-2 gap-1 row-gap-4">
            <div class="parkir-box parkir-gray">F1</div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-gray">F2</div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-blue"></div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-gray">F3</div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-gray">F4</div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-red"></div>
          </div>
        </div>

        <div class="col-12 d-grid">
          <button type="submit" class="btn btn-primary btn-lg">Next</button>
        </div>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
