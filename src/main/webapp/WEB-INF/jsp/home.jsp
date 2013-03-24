<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.css"/>"/>
        <link rel="stylesheet" href="<c:url value="resources/css/mystyle.css"/>"/>
        <link rel="stylesheet" href="<c:url value="resources/css/bootstrap-responsive.css"/>"/>

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
                <ul class="nav nav-pills pull-left">
                    <li class="active"><a href="/">Home</a></li>
                    <li><a href="novaReceita.html">Criar Receita</a></li>
                    <li><a href="recipes.html">Listar Receitas</a></li>
                </ul>

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