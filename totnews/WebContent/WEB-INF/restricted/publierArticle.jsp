<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/STYLE/bootstrap/dist/css/bootstrap.css">
<link href="${pageContext.request.contextPath}/STYLE/style.css" rel="stylesheet">
 <% String action = "corrigé";
 if (request.getAttribute("publier").equals(Boolean.TRUE)) { action = "publié"; } else if (request.getAttribute("publier").equals(Boolean.FALSE)){ action = "retiré";}%>
<title>Article <%=action %></title>
</head>
   <!-- Barre de titre -->
   <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">
			T.O.T News
		  </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          <% if (request.getUserPrincipal()!=null) { %>
            <li><a href="ServletComptes?op=Deconnexion">Déconnexion</a></li>
            <% } %>
          </ul>
        </div>
      </div>
    </nav>

	<div class="container">
	
	  <!-- Menu -->
      <div class="row">
        <nav class="col-sm-2">   
          <ul class="nav nav-pills nav-stacked">
            <li class="menu"> Menu :  </li>
           
            <% if (request.getUserPrincipal()==null) { %>
            	<li> <a href="LoginServlet"> <span class="glyphicon glyphicon-remove"></span> Connexion </a> </li>
            	<li> <a href="./index.html"> <span class="glyphicon glyphicon-home"></span> Acceuil </a> </li>
            	<li><a href="ServletArticles?op=listerArticles"> <span class="glyphicon glyphicon-home"></span> Retour </a> </li>
            <% } else { %>
             <li> <a href="ServletComptes?op=RetourIndex"> <span class="glyphicon glyphicon-home"></span> Acceuil </a> </li>
             <li><a href="ServletArticles?op=listerArticles"> <span class="glyphicon glyphicon-home"></span> Retour </a> </li>
			 <li><a href="ServletComptes?op=Deconnexion">Déconnexion </a></li>
			 <li><a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </a></li>
             <% } %>
             
          </ul> 
        </nav>
	L'article a bien été <%=action%>.


</body>
</html>