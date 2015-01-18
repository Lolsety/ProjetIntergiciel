<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.droits.*,beans.texte.Article,java.util.Collection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/STYLE/bootstrap/dist/css/bootstrap.css">
<link href="${pageContext.request.contextPath}/STYLE/style.css" rel="stylesheet">
<title>Liste des articles </title>
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
            <% } else { %>
             <li> <a href="ServletComptes?op=RetourIndex"> <span class="glyphicon glyphicon-home"></span> Accueil </a> </li>
             <% } %>
          </ul> 
        </nav>
		
		<section class="col-sm-10">
		<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Articles de T.O.T. News</h3>
				</div>
				<div class="panel-body">
					<div class="container">
					<% Collection<Article> listeArticles = (Collection<Article>)request.getAttribute("listeArticles"); %>
					<% for (Article a : listeArticles) { %>
						<%= a.getTitre() %> <dd>     
						<li><a href="ServletArticles?op=lireArticle&id=<%=a.getId()%>"> <span class="glyphicon glyphicon-book"></span> Lire </a>
						
						<% if (request.getUserPrincipal()!=null) { 
								if (((Droit)request.getAttribute("droit")).compareTo(Droit.CORRECTEUR)<0) { %>
						<a href="ServletArticles?op=CorrigerArticle&id=<%=a.getId()%>"> <span class="glyphicon glyphicon-book"></span> Corriger </a>
						
								<% if (((Droit)request.getAttribute("droit")).compareTo(Droit.MODERATEUR)<0 & !a.isPublicationAutorise()) { %>
						<a href="ServletArticles?op=PublierArticle&id=<%=a.getId()%>"> <span class="glyphicon glyphicon-book"></span> Publier </a>
						<%} else { %>
						<a href="ServletArticles?op=PublierArticle&id=<%=a.getId()%>"> <span class="glyphicon glyphicon-book"></span> Retirer </a>
							<% }
								} 
								 }%>
						</li>
						
					<% } %>
					</div> 
				</div>
			</div>

	</section>
</body>
</html>