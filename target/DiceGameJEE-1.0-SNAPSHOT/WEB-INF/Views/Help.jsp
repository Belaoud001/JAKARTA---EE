<%@ page import="com.game.RawMaterials.User" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/13/2022
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/homeStyle.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <ul class="nav-links">
        <div class="flex-container">
            <div>
                <li class="forward adjust">
                    <box-icon name='user-circle' class="icon" animation='fade-left' color='#ad810b' ></box-icon>
                    <a href="#">
                        Welcome <%=((User) request.getSession().getAttribute("currentUser")).getLastName()%>
                    </a>
                </li>
            </div>
            <div class="center-nav">
                <li class="forward adjust">
                    <box-icon name='home-smile' class='icon' color='#ad810b'></box-icon>
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li class="forward adjust">
                    <box-icon name='flag-checkered' class='icon' type='solid' color='#ad810b' ></box-icon>
                    <a href="${pageContext.request.contextPath}/leaderboard">LeaderBoard</a>
                </li>
                <li class="forward adjust">
                    <box-icon name='help-circle' class='icon' animation='tada' color='#ad810b' ></box-icon>
                    <a href="${pageContext.request.contextPath}/help">Help</a>
                </li>
            </div>
            <div>
                <li class="forward adjust">
                    <box-icon name='log-out' class='icon' color='#ad810b'></box-icon>
                    <a href="${pageContext.request.contextPath}/WEB-INF/Views/loginPage.jsp">Log out</a>
                </li>
            </div>
        </div>
    </ul>

    <h1>Help</h1>
</div>

<script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
</body>
</html>