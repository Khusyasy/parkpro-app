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
    <div class="container-fluid d-flex justify-content-center align-items-center " style="height: 100vh;">
      <div class="row g-2 justify-content-center align-items-center">
        <div class="col-12 mb-2 justify-content-center align-items-center" style="width: 68px;">
          <img src="/images/logo.png" class="img-fluid rounded-top" alt="ParkPro Logo">
          <div class="text-center">
            ParkPro
          </div>
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
            <form class="row g-3 align-items-center" action="LoginServlet" method="post">
            <div class="col-12">
              <div class="form-floating">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Nomor Telepon">
                <label for="phone">Nomor Telepon</label>
              </div>
            </div>
            <div class="col-12">
              <div class="form-floating">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                <label for="password">Password</label>
              </div>
            </div>
            <div class="col-12 d-grid">
              <button type="submit" class="btn btn-primary btn-lg">Login</button>
            </div>
            <div class="col-12 text-center">
              Belum punya akun? <a href="/register.jsp">Register</a>
            </div>
          </form>
        </div>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
  </body>

</html>
