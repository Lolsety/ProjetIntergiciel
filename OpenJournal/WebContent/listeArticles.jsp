<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.droits.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La liste des articles</title>
</head>
<body>
Liste des articles...et pour chaque article, on aura le lien suivant : 
<a href="Servlet?op=lireArticles&titre=nomArticle">Lire l'article</br></a>
<% Droit droit=(Droit) request.getAttribute("droit");
	switch (droit) {
	case ADMNINISTRATEUR:
	%>
		<a href="ServletArticles?op=CorrigerArticle">Corriger l'article</br></a>
		<a href="ServletArticles?op=PublierArticle">Publier l'article</br></a>
	<%
	break;
	case CORRECTEUR :
	%>
		<a href="ServletArticles?op=CorrigerArticle">Corriger l'article</br></a>
	<%
	break;
	}
%>


<a href="index.html">Déconnexion </br></a>
<a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </br></a>
</body>
</html>