<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="ServletArticles">
	<input type="text" name="Titre" value="Titre de l'article"> </br>
	<textarea name="CorpsArticle">
	</textarea> </br>
	<input type="submit" value="Soumettre l'article">
	<input type="hidden" name="op" value="soumissionArticle">
</form>

<a href="../index.html">Déconnexion </br></a>
<a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </br></a>
	
</body>
</html>