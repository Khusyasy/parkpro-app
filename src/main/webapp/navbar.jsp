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
        <a class="<%= request.getRequestURI().endsWith("/") ? "nav-link active" : "nav-link" %>" href="/">Home</a>
      </li>
      <li class="nav-item">
        <a class="<%= request.getRequestURI().endsWith("/profil.jsp") ? "nav-link active" : "nav-link" %>" href="/profil.jsp">Profil</a>
      </li>
      <li class="nav-item">
        <a class="<%= request.getRequestURI().endsWith("/TiketServlet") ? "nav-link active" : "nav-link" %>" href="/TiketServlet">Tiket</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/LogoutServlet">Logout</a>
      </li>
    </ul>
    </div>
  </div>
</nav>
