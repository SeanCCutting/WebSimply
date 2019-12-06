<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
  <div class="header">
    <div class="banner">
      <div class="banner-desc">WebSimply</div>
    </div>
    <div class="nav">
      <div class="nav-user">
        <div class="nav-desc">
        Logged in as <% out.println(session.getAttribute("user")); %>
        </div>
      </div>
    </div>
  </div>
</body>
