<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%-- aqui, chama o ficheiro jsp que contem os comandos para acessar os CSS e JQuery--%>     
        <%@include file="/WEB-INF/jsp/common/libs.jsp" %>     

        <title>CookBook</title>
    </head>
    <body>  
         <%--inicio do cabeçalho--%>
        <div class="container-narrow">

            <div class="masthead">
                <ul class="nav nav-pills pull-right">

                    <li> <form class="navbar-search pull-left">
                            <input type="text" class="search-query" placeholder="Procura">
                        </form></li>
                </ul>
                <h3 class="muted">My CookBook</h3>
                
                <%-- aqui, chama o ficheiro jsp que contem os links do menu--%>
                <%@include file="/WEB-INF/jsp/common/menu.jsp" %>

            </div>
             <%--fim do cabeçalho--%>

            <br>
            <br>
            <br>
            <br>

        </div>
             
         <%--inicio da imagem--%>     
        <div class="container" align="center">
            
            <legend>Seja Bem vindo ao My CookBook Repositório Git</legend>  
            
            <img src="../../resources/cookbook-color1.JPG" align="center">
            <br>
            <br>
            <h5 class="masthead"> ${currentTime} </h5>

        </div> 
        <%--fim da imagem--%>

    </body>
</html>