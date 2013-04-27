<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
                <li><a href="/">Home</a></li>
                <li><a href="#">Criar Receita</a></li>
                <li><a href="/recipes.html">Listar Receitas</a></li>
                <li class="active"><a href="#">Detalhes Receita</a></li>
            </ul>                     
        </div> 
    </div>
    <%--fim  do cabeçalho--%>
      
    
    <%--Inicio da Listagem --%>
    
         <br>
          <legend>Listar Receitas</legend>  
        <table border="1">
            <th>ID</th>
            <th>Titulo da Receita</th>
            <th>Descrição do problema</th>
            <th>Descrição da solução</th>
            <th>Autor</th>
            <th>Data da criação</th>

            <!--parte refernte a listagem-->
            <c:forEach items="${receitaList}" var="receita">
                <tr>
                    <td>${receita.id}</td>
                    <td>${receita.titulo}</td>
                    <td>${receita.desc_prob}</td>
                    <td>${receita.desc_soluc}</td>
                    <td>${receita.autor}</td>
                    <td>${receita.rec_criada}</td>
                </tr>
            </c:forEach>
        </table>
      
      
</body>
</html>