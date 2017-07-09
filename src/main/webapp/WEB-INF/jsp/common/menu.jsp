<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="nav nav-pills pull-left">
    <li id="menu-home" class="menu-button"><a href="<c:url value="/"/>">Home</a></li>
    <li id="menu-nova-receita"  class="menu-button"><a href="<c:url value="/novaReceita.html" />">Add Recipes</a></li>
    <li id="menu-listar-receita" class="menu-button"><a href="<c:url value="/listarReceita.html"/>">List Recipes</a></li>
    
</ul>


<script type="text/javascript">
    $(document).ready(function() {
        $(".menu-button").removeClass("active");
        if(document.location.pathname === "/") {
            $("#menu-home").addClass("active");
        } else if(document.location.pathname === "/novaReceita.html") {
            $("#menu-nova-receita").addClass("active");
        } else if(document.location.pathname === "/listarReceita.html") {
            $("#menu-listar-receita").addClass("active");
        }
    });
</script>
