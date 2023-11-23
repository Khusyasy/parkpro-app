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
            Pesan Parkir
          </h2>
        </div>
        <div class="col-12">
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
          <form class="row g-3 align-items-center" action="Pesan1Servlet" method="post">
            <div class="col-12">
              <label for="datein" class="mb-1">Tanggal / Waktu Masuk</label>
              <div class="input-group" style="height: 58px;">
                <input type="date" class="form-control" id="datein" name="datein">
                <input type="time" class="form-control" id="timein" name="timein">
              </div>
            </div>
            <div class="col-12">
              <label for="dateout" class="mb-1">Tanggal / Waktu Keluar</label>
              <div class="input-group" style="height: 58px;">
                <input type="date" class="form-control" id="dateout" name="dateout">
                <input type="time" class="form-control" id="timeout" name="timeout">
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
    <script>
        window.onload = function() {
          const now = new Date();
          now.setHours(now.getHours() + 1, 0, 0, 0);

          const satuJam = new Date(now.getTime());
          const tigaJam = new Date(now.getTime() + 2 * 60 * 60 * 1000);

          document.getElementById('datein').valueAsDate = satuJam;
          document.getElementById('timein').value = satuJam.toTimeString().slice(0, 5);

          document.getElementById('dateout').valueAsDate = tigaJam;
          document.getElementById('timeout').value = tigaJam.toTimeString().slice(0, 5);
        };
    </script>
  </body>

</html>
