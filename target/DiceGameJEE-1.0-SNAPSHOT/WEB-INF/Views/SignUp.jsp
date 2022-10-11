<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/14/2022
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/Style.css">
  <!-- Fontawesome CDN Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
  <input type="checkbox" id="flip">
  <div class="cover">
    <div class="front">
      <img class="diceImg" src="${pageContext.request.contextPath}/Images/Dice.jpg" alt="">
    </div>
    <div class="back">
      <div class="text">
        <span class="text-1">Complete miles of journey <br> with one step</span>
        <span class="text-2">Let's get started</span>
      </div>
    </div>
  </div>
  <div class="forms">
    <div class="form-content">
      <div class="login-form">
        <div class="title">Register</div>
        <form action="${pageContext.request.contextPath}/sign-up" method="post">
          <%
            if(request.getParameter("exist") != null) {
          %>
          <div class="alert">There's already an user with same login !</div>
          <%
            }
          %>
          <div class="input-boxes">
            <div class="input-box">
              <box-icon class="icon" name='log-in-circle' color='#ad810b' ></box-icon>
              <input type="text" placeholder="Enter your login" name="login" required>
            </div>
            <div class="input-box">
              <box-icon name='user-circle' color='#ad810b' ></box-icon>
              <input type="text" placeholder="Enter your First Name" name="firstName" required>
            </div>
            <div class="input-box">
              <box-icon name='user-circle' color='#ad810b' ></box-icon>
              <input type="text" placeholder="Enter your Last Name" name="lastName" required>
            </div>
            <div class="input-box">
              <box-icon name='lock' color='#ad810b' ></box-icon>
              <input type="password" placeholder="Enter your password" name="password" required>
            </div>
            <div class="button input-box">
              <input type="submit" class="btn" value="Register">
            </div>
            <div class="text sign-up-text">Already have an account? <label><a href="${pageContext.request.contextPath}/login">Login now</a></label></div>
          </div>
        </form>
      </div>
      </form>
    </div>
  </div>
</div>
</div>
<script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
</body>
</html>
