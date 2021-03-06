<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*"
         errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <%-- aqui, chama o ficheiro jsp que contem os comandos para acessar os CSS e JQuery--%>
    <%@include file="/WEB-INF/jsp/common/libs.jsp" %>

    <title>My CookBook</title>
</head>
<body>
<%--inicio do cabeçalho--%>
<div class="container-narrow">

    <div class="masthead">

        <h3 class="muted" style="color: orange">My CookBook</h3>

        <%-- aqui, chama o ficheiro jsp que contem os links do menu--%>
        <%@include file="/WEB-INF/jsp/common/menu.jsp" %>

    </div>
    <%--fim do cabeçalho--%>

    <br>
    <br>
    <br>


</div>

<%--inicio da imagem--%>
<div class="container" align="center">

    <h4>My CookBook - The recipe for each problem</h4>

    <img src="<c:url value="/resources/cookbook-color1.JPG" />" align="center"/>
    <br>
    <br>
    <h5 class="masthead"> ${currentTime} </h5>

</div>


</body>
<footer>
	<div class="modal-footer">My Cookbook Inc.</div>
</footer>

</html>