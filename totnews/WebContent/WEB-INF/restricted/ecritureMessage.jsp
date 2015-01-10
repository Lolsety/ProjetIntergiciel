<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ecriture d'un nouveau message</title>
</head>
<body>


	<form method="get" action="ServletArticles">
		<input type="text" name="Destinaire" value="Destinaire"> </br> <input
			type="text" name="Objet" value="Objet du  message"> </br>
		<textarea name="CorpsArticle">
	</textarea>
		</br> <input type="submit" value="Envoyer le message"> <input
			type="hidden" name="op" value="envoiMessage">
	</form>

	<a href="ServletComptes?op=Deconnexion">Déconnexion </br></a>
	<a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </br></a>


</body>
</html>