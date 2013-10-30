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

            </div> 
            <%--fim do cabeçalho--%>

            <br>
            <br>



            <%--inicio do formulario--%>

            <h4>Criar nova Receita</h4>  
            <form:form action="novaReceita.do" method="POST" commandName="receita" id="form">
                <table width=80% >

                    <tr>
                        <td><strong>Titulo da Receita </strong></td>
                        <td><form:input path="titulo"  class="input-xlarge" autofocus="autofocus" id="titulo"/></td>
                    </tr>
                    <tr>
                        <td valign=top><strong>Descrição do problema</strong></td>
                        <td><form:textarea path="desc_prob" class="input-xlarge" rows="3" id="desc_prob" /></td>
                    </tr>
                    <tr>

                        <td valign=top><strong>Descrição da solução</strong></td>
                        <td><form:textarea path="desc_soluc" class="input-xlarge" rows="6" id="desc_soluc"/></td>

                    </tr>
                    <tr>
                        <td><strong>Autor da Receita </strong></td>
                        <td><form:input path="autor" class="input-xlarge" id="autor"/></td>
                    </tr>   
                    <tr>
                        <td><strong>Tag</strong></td>
                        <td><form:input path="tag" class="input-xlarge" id="tag"/></td>
                    </tr>    

                    <tr>
                        <td>
                        <td>
                            <!--parte refernte aos botões -->                
                            <button type="submit" name="action" class="btn btn-success" value="add" id="add">Guardar</button>  
                            <button type="reset" name="action" class="btn btn-success" value="cancel">Cancelar</button>  
                        </td>

                    </tr>

                </table>

            </form:form>

            <%--script para validar os campos do lado do cliente --%>
            <script type="text/javascript">
                <%--se o botão que se chama 'add' for precionado faça o seguinte: --%>
                    $("button:eq(0)").click (function()
                    {
                        if (form.titulo.value=="") {
                            alert("Preencha o Titulo corretamente.");
                            form.titulo.focus();
                            return false;
                        }
                        if (form.desc_prob.value=="") {
                            alert("Preencha a Descrição do problema corretamente.");
                            form.desc_prob.focus();
                            return false;
                        }
                        if (form.desc_soluc.value=="") {
                            alert("Preencha a Solução do problema corretamente.");
                            form.desc_soluc.focus();
                            return false;
                        }
                        if (form.autor.value=="") {
                            alert("Preencha o autor corretamente.");
                            form.autor.focus();
                            return false;
                        }
                        if (form.autor.value=="") {
                            alert("Preencha a Tag corretamente.");
                            form.tag.focus();
                            return false;
                        }
                    });
                
            </script>

        </div>
                     <div class="modal-footer">My Cookbook Inc.</div>
    </body>
</html>
