<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.comptes.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de gestions des droits</title>
</head>
<body>

	Voici la liste des comptes utilisateurs :
	<%
		for (Compte compte : (Collection<Compte>)request.getAttribute("listeComptes")) {
			out.println(compte.getNom() + " " + compte.getPrenom() + " : "); 
		}
%>
	</br>

</body>
</html>