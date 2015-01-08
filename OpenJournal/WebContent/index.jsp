<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.droits.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>

<% Droit droit=(Droit) request.getAttribute("droit");
	switch (droit) {
	case ADMNINISTRATEUR:
	%>
		<a href="ServletArticles?op=PublierArticle">Publier un article</br></a>
		<a href="ServletDroits?op=GererDroits">Gérer les droits</br></a>
	<%
	break;
	case CORRECTEUR :
	%>
		<a href="ServletArticles?op=corrigerArticle">Corriger un article</br></a>
	<%
	break;
	}
%>

<a href="index.html">Déconnexion </br></a>
<a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </br></a>
<a href="ServletArticles?op=RedigerArticle">Rédiger un article</br></a>
<a href="ServletArticles?op=listerArticles">Lister les articles</br></a>
<a href="ServletMessagerie?op=accederMessagerie">Accéder à la messagerie</br></a>
</body>
</html>