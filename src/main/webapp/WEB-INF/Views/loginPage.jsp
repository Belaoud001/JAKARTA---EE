<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/12/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/Style.css">
        <!-- Fontawesome CDN Link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body>
        <div class="container">
            <input type="checkbox" id="flip">
            <div class="cover">
                <div class="front">
                    <img class="diceImg" src="${pageContext.request.contextPath}/Images/Dice.jpg" alt="">
                </div>
                <div class="back">
                    <img class="backImg" src="${pageContext.request.contextPath}/Images/Dice.jpg" alt="">
                    <div class="text">
                        <span class="text-1">Complete miles of journey <br> with one step</span>
                        <span class="text-2">Let's get started</span>
                    </div>
                </div>
            </div>
            <div class="forms">
                <div class="form-content">
                    <div class="login-form">
                        <div class="title">Login</div>
                        <form action="${pageContext.request.contextPath}/login-servlet" method="post">
                            <%
                                if(request.getParameter("failed") != null) {
                            %>
                            <div class="alert">Please rectify your login or password !</div>
                            <%
                                }
                            %>
                            <div class="input-boxes">
                                <div class="input-box">
                                    <box-icon class="icon" name='log-in-circle' color='#ad810b' ></box-icon>
                                    <input type="text" placeholder="Enter your login" name="login" required>
                                </div>
                                <div class="input-box">
                                    <box-icon name='lock' color='#ad810b' ></box-icon>

                                    <input type="password" placeholder="Enter your password" name="password" required>
                                </div>
                                <div class="text"><a href="#">Forgot password?</a></div>
                                <div class="button input-box">
                                    <input type="submit" class="btn" value="Sign in">
                                </div>
                                <div class="text sign-up-text">Don't have an account? <label><a href="${pageContext.request.contextPath}/signup">Sigup now</a></label></div>
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
