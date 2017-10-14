

<%-- 
    Document   : login
    Created on : Sep 17, 2017, 6:36:06 PM
    Author     : 742227
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoppingggg!!!</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <c:if test="${userName == null}">
            <form  action="ShoppingList" name= "ageCal" method="get">
                <p>Username:  <input type ="text" name="userName" value="${userName}"></p>
                <input type ="submit" value="Register name" >
                <input type="hidden" name="action" 
                       value="register">
            </form>
        </c:if>

        <c:if test="${userName != null}">
            <p>Hello ${userName} <a href="ShoppingList?action=logout"> Logout</a></p>


            <c:import url="/shoppingList.jsp" />
            <c:if test="${item != null}">
                <form  action="ShoppingList" name= "ageCal" method="get">
                    <c:forEach var="item1" items="${item}">
                        <input type="radio" name="item" value="${item1}">${item1} </br>
                    </c:forEach>
                    <input type="hidden" name="action" 
                           value="delete">
                    <input type ="submit" value="Delete">
                </form>
            </c:if>

        </c:if>




    </body>
</html>
