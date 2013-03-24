<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
                    <li class="active"><a href="#">Criar Receita</a></li>
                    <li><a href="recipes.html">Listar Receitas</a></li>
                </ul>
                
            </div> 
             <%--fim do cabeçalho--%>

            <br>
            <br>
            <br>
            <br>

            <%--inicio do formulario--%>
            <form class="form-horizontal" method="POST" action="adicionaReceita" commandName="receita">  
                <fieldset>  
                    <legend>Criar nova Receita</legend>  

                    <div class="control-group">  
                        <label class="control-label" for="input01">Título</label>  
                        <div class="controls">  
                            <input path= "titulo" type="text" class="input-xlarge" id="input01">              
                        </div>  
                    </div>    

                    <div class="control-group">  
                        <label class="control-label" for="input02">Descrição do problema</label>  
                        <div class="controls">  
                            <input path= "desc_prob" type="text" class="input-xlarge" id="input02">              
                        </div>  
                    </div>    

                    <div class="control-group">  
                        <label class="control-label" for="input03">Descrição da solução</label>  
                        <div class="controls">  
                            <textarea path= "desc_soluc" class="input-xlarge" id="input03" rows="6"></textarea>  
                        </div>  
                    </div>  

                    <div class="control-group">  
                        <label class="control-label" for="input04">Autor</label>  
                        <div class="controls">  
                            <input path= "autor" type="text" class="input-xlarge" id="input04">              
                        </div>  
                    </div>   

                    <div class="form-actions">  
                        <button type="submit" name="action" class="btn nav-pills pull" value="add">Guardar</button>  
                        <button class="btn nav-pills pull" name="action_2" value="cancel">Cancelar</button>  
                    </div>  
                </fieldset>  
            </form>  
             <%--fim do formulario--%>

        </div>
    </body>
</html>
