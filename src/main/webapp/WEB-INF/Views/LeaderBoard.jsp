<%@ page import="com.game.RawMaterials.User" %>
<%@ page import="com.game.Web.DataManagementSupplies.IGameSupply" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/13/2022
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/leaderboardStyle.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%
    IGameSupply storageSupply = (IGameSupply) request.getServletContext().getAttribute("storageSupply");

    User currentUser = (User) request.getSession().getAttribute("currentUser");
%>
<div class="container">
    <ul class="nav-links">
        <div class="flex-container">
            <div>
                <li class="forward adjust">
                    <box-icon name='user-circle' class="icon" animation='fade-left' color='#ad810b' ></box-icon>
                    <a href="#">
                        Welcome <%=currentUser.getLastName()%>
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
                    <a href="${pageContext.request.contextPath}/login">Log out</a>
                </li>
            </div>
        </div>
    </ul>

    <div class="internal-container">
        <div class="decorate-title">LeaderBoard</div>
        <div class="display-table">
            <div class="table-holder">
                <table>
                    <thead>
                        <tr>
                            <th>Rank</th>
                            <th>Last Name</th>
                            <th>Score</th>
                        </tr>
                    </thead>

                    <tbody>
                    <%
                        int counter = 1;
                        String[] colors = {"#ffd700", "#D3D3D3", "#CD7F32"};

                        for(User user: storageSupply.getAllUsers()) {
                    %>
                    <tr>
                        <td>
                            <div class="adjust">
                                <div class="adjust" style="width: 40%">
                                    <%
                                        if(counter <= 3) {
                                    %>
                                    <box-icon name='medal' class="icon" animation='tada' color='<%=colors[counter-1]%>' ></box-icon>
                                    <%
                                        }
                                    %>
                                </div>
                                <div style="width: 60%">
                                    <%=counter++%>
                                </div>
                            </div>
                        </td>
                        <td><%=user.equals(currentUser) ? "<b>You</b>" : user.getLastName()%></td>
                        <td><%=user.getBestScore() == -2 ? "Haven't played yet" : user.getBestScore()%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
</body>
</html>
