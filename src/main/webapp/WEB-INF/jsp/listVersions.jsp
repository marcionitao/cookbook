<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                <h3 class="muted" style="color: orange">My CookBook</h3>

                <%-- aqui, chama o ficheiro jsp que contem os links do menu--%>
                <%@include file="/WEB-INF/jsp/common/menu.jsp" %>   

                <%-- aqui, torna activo apenas a opção "Listar Versoes" na barra de menu, e quero que mostre apenas aqui--%>
                <ul class="nav nav-pills pull-left">
                    <li id="menu-listar-versoe" class="active"><a href="#">Listar Versões</a></li>
                </ul>


            </div> 

            <%--fim  do cabeçalho--%>

            <br>
            <br>

            <%--Inicio da Listagem --%>

            <h4 style="align:left">Listar Versões de Receitas</h4>  
            <table class="table">

                <tr id="x" class="info">    

                    <td><strong>Versão</strong></td>
                    <td><strong>Titulo da Receita</strong></td>
                    <td><strong>Data da ultima actualização</strong></td>
                    <td><strong>Ação</strong></td>
                </tr>

                <!--parte refernte a listagem-->

                <c:forEach items="${versoesList}" var="receita">
                    <c:url var="url" value="/receita/${receita.id}" />   
                    <%-- <c:url var="url" value="/listarReceita/${receita.controle}" />   --%>
                    <tr id="y" class="success">

                        <%--url refere-se ao conteudo do id receitas, é uma variavel antes da listagem --%>
                        <form:form action="${url}/form" method="GET">

                            <%--aqui, definimos que será mostrado o id e o titulo da receita, mas apenas o titulo é clicavel --%>

                            <%--<td>${receita.id}</td>--%>
                            <td></td>
                            <td><a href="<c:url value="/receita/"/>${receita.id}/form" title="Mostrar Receita ao detalhe">${receita.titulo}</a></td>
                            <td>${receita.rec_criada}</td>                     

                        </form:form>

                        <%--url refere-se ao botão para eliminar receita --%>
                        <form:form action="${url}" method="DELETE">

                            <%--aqui, definimos um botão "eliminar" para cada receita. --%>
                            <td><a href="/delete/${receita.id}"><img src="../../resources/img/delete.png" title="Apagar Receita"/></a> </td>

                        </form:form>

                    </tr>           

                </c:forEach>
            </table>

            <%-- Faz o controle da numeração das versões--%>
            <script type="text/javascript">
                
              /*  var table = document.getElementsByTagName("table")[0];
                rows = table.getElementsByTagName("tr");
                text = "" in document ? "" : "innerText";
                
                for (var i = 1, len = rows.length; i < len; i++){
                    rows[i].children[1][text] = i + '' + rows[i].children[1][text];
                }*/
                
                var table = document.getElementsByTagName('table')[0],
                rows = table.getElementsByTagName('tr'),
                text = 'textContent' in document ? 'textContent' : 'innerText';
                
                for (var i = 1, len = rows.length; i < len; i++){
                    rows[i].children[1][text] = i + ' ' + rows[i].children[1][text];
                }
                
            </script>
            
            

            <%--fim da listagem--%>
        </div>
         <div class="modal-footer">My Cookbook Inc.</div>
    </body>
</html>