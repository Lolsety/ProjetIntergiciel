<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.comptes.*, java.util.*,beans.droits.Droit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de gestions des droits</title>
</head>
<body>
<form method="get" action="ServletDroits">
	Voici la liste des comptes utilisateurs : <br>
	<%
		for (Compte compte : (Collection<Compte>)request.getAttribute("listeComptes")) {
			out.println(compte.getNom() + " " + compte.getPrenom() + " (" + compte.getPseudoLdap() + ") : ");
			%>
			<input name="Compte" value="<%= compte.getPseudoLdap()%>" type="radio"/> <br>
			<%
		}
	%>
	Quel droit associer à ce compte? : <br>
	<%
		for (Droit droit : Droit.values()) {
			out.println(droit + " : ");
			%>
			<input name="Droit" value="<%= droit%>" type="radio"/> <br>
			<%
		}
	%>
	<input type = "submit" value="ok">
	<input type="hidden" name="op" value="modifDroits">
</form>
</body>
</html>