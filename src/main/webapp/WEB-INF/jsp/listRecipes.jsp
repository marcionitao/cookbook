<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
       
         <%--fim  do cabeçalho--%>

        <br>
        <br>
        <br>
        <br>
       
         <%--inicio da lista de itens--%>
      <%--Inicio da Listagem --%>

      <legend>Listar Receitas</legend>  
      <table width=80% height=20%>
          <tr>
          <thead>

          <td><strong>Id</strong></td>
          <td><strong>Titulo da Receita</strong></td>
          </thead>

          </tr>
          <!--parte refernte a listagem-->
          <c:forEach items="${receitaList}" var="receita">
             

              <tr>
                  <td>${receita.id}</td>
                  <td>${receita.titulo}</td>

                  

              </tr>
          </c:forEach>
      </table>
      <%--fim da lista de itens--%>
        </div>
    </body>
</html>