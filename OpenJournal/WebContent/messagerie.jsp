<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ma messagerie</title>
</head>
<body>

Liste des messages...et pour chaque message, on aura le lien suivant : 
<a href="Servlet?op=lireMessages&id=numMessage">Lire le message</br></a>

<a href="Servlet?op=EcrireMessage">Ecriture d'un nouveau message </br></a>
<a href="index.html">Déconnection </br></a>
<a href="Servlet?op=RetourIndex"> Retour à l'accueil </br></a>

</body>
</html>