<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="resources/css/bootstrap.css"/>"/>
<link rel="stylesheet" href="<c:url value="resources/css/mystyle.css"/>"/>
<link rel="stylesheet" href="<c:url value="resources/css/bootstrap-responsive.css"/>"/>

<title>CookBook</title>
</head>
<body>
    
    <!--cabeçalho-->
    
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
                <li class="active"><a href="#">Listar Receita</a></li>
            </ul>                     
        </div> 
    </div>
        
    <br>
    <br>
    <br>
    <br>
    <br>
        
    <!--lista de itens-->
    
    <div class="container">
        <div class="row" >
            <div class="span4">
                <h4>Receitas</h4>
                <div class="container-fluid">
                    <div class="row-fluid">
                        <div class="span6">
                            <ul>
                                <c:forEach var="item" items='${items}'>
                                    <li><a href="/recipes/{id}.html"><c:out value="${item}"></c:out></a></li>
                                </c:forEach>
                            </ul>
                        </div>
                            
                    </div>
                </div>
            </div>
                
        </div>
    </div>
        
    <!--javascrip-->          
        
    <script src="../../resources/js/jquery.js"></script>
    <script src="../../resources/js/bootstrap-transition.js"></script>
    <script src="../../resources/js/bootstrap-alert.js"></script>
    <script src="../../resources/js/bootstrap-modal.js"></script>
    <script src="../../resources/js/bootstrap-dropdown.js"></script>
    <script src="../../resources/js/bootstrap-scrollspy.js"></script>
    <script src=".../../resources/js/bootstrap-tab.js"></script>
    <script src="../../resources/js/bootstrap-tooltip.js"></script>
    <script src="../../resources/js/bootstrap-popover.js"></script>
    <script src="../../resources/js/bootstrap-button.js"></script>
    <script src="../../resources/js/bootstrap-collapse.js"></script>
    <script src="../../resources/js/bootstrap-carousel.js"></script>
    <script src="../../resources/js/bootstrap-typeahead.js"></script>
        
        
        
</body>
</html>