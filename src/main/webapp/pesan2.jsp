<%@ page import="com.parkpro.LahanParkir" %>
<%@ page import="com.google.gson.Gson" %>
<%
    if (session == null || session.getAttribute("id") == null) {
        response.sendRedirect("login.jsp");
    }
    if (session == null || session.getAttribute("arrLahan") == null
            || session.getAttribute("arrLantai") == null
            || session.getAttribute("arrLokasi") == null) {
        response.sendRedirect("pesan.jsp");
    }
    Gson gson = new Gson();
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

    <div class="container-fluid d-flex justify-content-center align-items-center">
      <form class="row g-2 justify-content-between align-items-center"
        style="height: calc(100vh - 40px); margin-top: 40px;" action="Pesan2Servlet" method="post">
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
          <label for="lantai" class="visually-hidden">Lantai</label>
          <select class="form-select" id="lantai" style="height: 58px;">
            <option>Pilih Lantai</option>
            <%
                String[] arrLantai = (String[]) session.getAttribute("arrLantai");
            %>
            <% for (String lantai : arrLantai) { %>
                <option value="<%= lantai %>">Lantai <%= lantai %></option>
            <% } %>
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
          <div class="row row-cols-auto bg-body-secondary p-2 gap-1 row-gap-4" id="container-parkir">
            <!-- <div class="parkir-box parkir-gray">F1</div>
            <div class="parkir-box parkir-green"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-red"></div>
            <div class="parkir-box parkir-green"></div> -->
          </div>
          <input type="hidden" name="id_lahan" id="id_lahan" value="-1">
        </div>
        <div>
            <div class="col-12 d-grid">
              <button type="submit" class="btn btn-primary btn-lg">Next</button>
            </div>
            <div class="col-12 d-grid mt-2">
              <a href="/pesan.jsp" class="btn btn-outline-primary">Kembali</a>
            </div>
        </div>
      </form>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
    <script>
      const lantaiEl = document.getElementById("lantai");
      const containerParkirEl = document.getElementById("container-parkir");
      const inputLahanEl = document.getElementById("id_lahan");
      let lahanTerpilihEl = null;

      const arrLahan = <%= session.getAttribute("arrLahan") %>;
      const arrLokasi = <%= session.getAttribute("arrLokasi") %>;

      function renderParkir() {
        containerParkirEl.innerHTML = "";
        if (lantaiEl.value == "Pilih Lantai") {
          containerParkirEl.innerHTML = "pilih lantai terlebih dahulu";
          return;
        }
        const lahanByLantai = arrLahan.filter(lahan => lahan.lantai === lantaiEl.value);
        arrLokasi.forEach(lokasi => {
          const lokasiEl = document.createElement("div");
          lokasiEl.classList.add("parkir-box");
          lokasiEl.classList.add("parkir-gray");
          lokasiEl.innerText = lokasi;
          containerParkirEl.appendChild(lokasiEl);

          const lahanByLokasi = lahanByLantai.filter(lahan => lahan.lokasi === lokasi);
          const sortedLahan = lahanByLokasi.sort((a, b) => a.nomor - b.nomor);
          sortedLahan.forEach(lahan => {
            const parkirEl = document.createElement("div");
            parkirEl.classList.add("parkir-box");
            if (lahan.id == inputLahanEl.value) {
              parkirEl.classList.add("parkir-blue");
            } else if (lahan.tersedia) {
              parkirEl.classList.add("parkir-green");
            } else {
              parkirEl.classList.add("parkir-red");
            }
            parkirEl.innerText = lahan.nomor;
            parkirEl.setAttribute("data-id", lahan.id);
            parkirEl.addEventListener("click", (e) => {
              if (lahan.tersedia) {
                if (inputLahanEl.value != -1) {
                  lahanTerpilihEl.classList.toggle("parkir-blue");
                }
                if (inputLahanEl.value == lahan.id) {
                  inputLahanEl.value = -1;
                  lahanTerpilihEl = null;
                } else {
                  parkirEl.classList.toggle("parkir-blue");
                  inputLahanEl.value = lahan.id;
                  lahanTerpilihEl = parkirEl;
                }
              }
            });
            containerParkirEl.appendChild(parkirEl);
          });
        });
      }

      lantaiEl.addEventListener("change", (e) => {
        renderParkir();
      });
      window.addEventListener("load", (e) => {
        renderParkir();
      });
    </script>
  </body>

</html>
