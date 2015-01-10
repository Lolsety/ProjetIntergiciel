<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.droits.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<%Droit droit=(Droit) request.getAttribute("droit"); %>
	<h1>You have been successfully logged in as </h1>
    <%= request.getUserPrincipal().getName() %> 
    <h1> And you are an </h1>	
    <%= droit %><br>
    <% 
    	switch (droit) {
			case ADMNINISTRATEUR:
				%>
					<a href="ServletDroits?op=GererDroits">Gérer les droits<br></a>
				<%
			break;
			default: break;
		}
%>

	<a href=ServletComptes?op=Deconnexion>Déconnexion <br></a>
	<a href="ServletComptes?op=RetourIndex"> Retour à l'accueil <br></a>
	<a href="ServletArticles?op=RedigerArticle">Rédiger un article<br></a>
	<a href="ServletArticles?op=listerArticles">Lister les articles<br></a>
	<a href="ServletMessagerie?op=accederMessagerie">Accéder à la
		messagerie<br>
	</a>
</body>
</html>