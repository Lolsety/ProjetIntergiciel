<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nom de l'article</title>
</head>
<body>
On lit d'abord l'article et les commentaires, puis on peut commenter soi-même.
<form method="get" action="ServletArticles">
	<textarea name="commentaire">
	</textarea> </br>
	<input type="submit" value="Poster le commentaire">
	<input type="hidden" name="op" value="posterCommentaire">
</form>

<a href="index.html">Déconnexion </br></a>
<a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </br></a>
</body>
</html>