<%@ page import="com.game.RawMaterials.User" %>
<%@ page import="com.game.RawMaterials.GameLogic" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/12/2022
  Time: 4:29 PM
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
    <%
        int diceFace = 5;

        if((request.getServletContext().getAttribute("diceFace") != null))
            diceFace = (int) request.getServletContext().getAttribute("diceFace");

        GameLogic gameLogic = (GameLogic) request.getSession().getAttribute("gameLogic");

        int justStart = (int) request.getSession().getAttribute("justStart");

        List<Integer> previousScores = gameLogic.getPreviousScores();

    %>
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
                        <a href="${pageContext.request.contextPath}/login">Log out</a>
                    </li>
                </div>
            </div>
        </ul>

        <form action="game-servlet" method="post">
            <div class="ring">
                    <div class="<%=gameLogic.isOver() ? "selector" : ""%>">
                        <%
                            if(gameLogic.isOver() && justStart == 0) {
                        %>
                        <div class="brief-box">
                            <%
                                if(previousScores.size() == 3) {
                            %>
                            <div class="adjust">
                                <box-icon name='dice-1' class="icon" animation='spin' color='#888' ></box-icon>
                                <%=previousScores.get(2)%>
                            </div>
                            <div class="adjust">
                                <box-icon name='dice-2' class="icon" animation='spin' color='#888' ></box-icon>
                                <%=previousScores.get(1)%>
                            </div>
                            <div class="adjust">
                                <box-icon name='dice-3' class="icon" animation='spin' color='#888' ></box-icon>
                                <%=previousScores.get(0)%>
                            </div>
                            <%
                                } else if(gameLogic.getCurrentScore() == -1) {
                            %>
                            <div class="adjust text-x">
                                <box-icon class="icon" name='sad' color='#b9b9b9' ></box-icon>
                                <b>A Dice rolled Twice!</b><br/>
                            </div>

                        <%
                            } else {
                        %>
                            <div class="adjust text-x">
                                <box-icon class="icon" name='sad' color='#b9b9b9' ></box-icon>
                                <b>What a bad luck !</b><br/>
                            </div>
                        <%
                            }
                            }
                        %>
                        </div>

                        <h2 style="color: #43434e" class="h2Style">Dice Face</h2>

                        <img src="${pageContext.request.contextPath}/Images/Dice%20Icons/<%=justStart == 1 ? "start" : "Dice"+diceFace%>.png">
                        <span class="choose">Choose Dice</span>

                        <div>
                            <div class="dropdown">
                                <div class="select">
                                    <span>Select Dice</span>
                                    <i class="fa fa-chevron-left"></i>
                                </div>
                                <input type="hidden" name="Dice">
                                <ul class="dropdown-menu">
                                    <li id="dice-1" class="adjust">
                                        <box-icon name='dice-1' class="icon" animation='spin' color='#888' ></box-icon>
                                        First Dice
                                    </li>
                                    <li id="dice-2" class="adjust">
                                        <box-icon name='dice-2' class="icon" animation='spin' color='#888' ></box-icon>
                                        Second Dice
                                    </li>
                                    <li id="dice-3" class="adjust">
                                        <box-icon name='dice-3' class="icon" animation='spin' color='#888' ></box-icon>
                                        Third Dice
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <%
                            if(gameLogic.isOver() && justStart == 0) {
                        %>
                        <div class="toast">
                            <div class="toast-content">
                                <box-icon name='invader' class="smile" type='solid' flip='horizontal' animation='tada' color='#a8a7a7' ></box-icon>
                                <div class="message">
                                    <span class="text-1"><strong>Game Over</strong></span>
                                    <span class="text">Your Score is : <%=gameLogic.getCurrentScore()%></span>
                                </div>
                            </div>

                            <i class="fa-solid fa-xmark close"></i>
                            <div class="progress"></div>
                        </div>
                        <%
                            }
                        %>

                        <div>
                            <button type="submit" class="adjust btn">
                                <box-icon name='game' class='icon' animation='spin' color='#ad810b' ></box-icon>
                                Roll
                            </button>
                        </div>
                    </div>
            </div>
        </form>
    </div>

    <script src="${pageContext.request.contextPath}/JavaScript/comboJs.js"></script>
    <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
    </body>
</html>
