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
                <li><a href="/recipes.html">Listar Receita</a></li>
                <li class="active"><a href="#">Detalhes Receita</a></li>
            </ul>                     
        </div> 
    </div>
      
<ul>
<c:forEach var="item" items='${items}'>
	<li><c:out value="${item}"></c:out></li>
</c:forEach>
</ul>
     
     
      
      
</body>
</html>