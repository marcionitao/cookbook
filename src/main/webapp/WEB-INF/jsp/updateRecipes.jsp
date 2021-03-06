<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

                <%-- aqui, chama o ficheiro jsp que contem os links do menu --%>
                <%@include file="/WEB-INF/jsp/common/menu.jsp" %>

                <%-- aqui, torna activo apenas a opção "Editar Receitas" na barra de menu, e quero que mostre apenas aqui--%>
                <ul class="nav nav-pills pull-left">
                    <li id="menu-editar-receita" class="active"><a href="#">Edit Recipe</a></li>
                </ul>


            </div> 
            <%--fim do cabeçalho--%>

            <br>
            <br>

            <%--inicio do formulario--%>

            <h4>Edit Recipe</h4>

            <%-- <c:url var="url" value="/receita/${receita.id}" />  --%>
            <form:form action="/cookbook/receita/${receita.id}" method="post" commandName="receita">
                <table width=80% >

                    <tr>
                        <td><strong>ID Recipe </strong></td>
                        <td><form:input path="controle" class="input-small"/></td>                         
                    </tr>
                  
                    <tr>
                        <td><strong>Recipe title</strong></td>
                        <td><form:input path="titulo" class="input-xlarge"/></td>
                    </tr>
                    
                     <tr>
                        <td><strong>Tags</strong></td>
                        <td><form:input path="tag" value="${tagString}" class="input-xlarge"/></td>
                    </tr>
                    
                    <tr>
                        <td valign=top><strong>Problem description</strong></td>
                        <td><form:textarea path="desc_prob" class="input-xlarge" rows="3" /></td>
                    </tr>
                    <tr>

                        <td valign=top><strong>Solution description</strong></td>
                        <td><form:textarea path="desc_soluc" class="input-xlarge" rows="6" /></td>

                    </tr>
                    <tr>
                        <td><strong>Recipe Author</strong></td>
                        <td><form:input path="autor" class="input-xlarge"/></td>

                    <tr>
                        <td><strong>Creation date of recipe</strong></td>
                        <td><form:input path="rec_criada" class="input-small" disabled="true"/></td>
                    </tr> 

                    <tr>

                        <td>
                        <td>
                            <!--parte refernte aos botões -->                
                            <button type="submit" name="action" class="btn nav-pills pull" value="add">Save</button>

                        </td>

                    </tr>

                </table>

            </form:form> 

        </div>
             
    </body>
    <footer>
	<div class="modal-footer">My Cookbook Inc.</div>
</footer>
</html>
