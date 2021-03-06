<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, oneToMany.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Association d'une personne et d'une adresse</title>
</head>
<body>
<form method="get" action="Servlet">
	Choisir la personne : </br>
	<%
		for (oneToMany.Personne pers : (Collection<oneToMany.Personne>)request.getAttribute("listePersonnes")) {
        	out.println(pers.getNom()+ " " + pers.getPrenom());
	%>  	
			<input name="Personne"  value="<%= pers.getId()%>" type="radio"/> </br>
	<%  } %> </br>
	Choisir l'adresse : </br>
	<%
		for(Adresse adres : (Collection<Adresse>)request.getAttribute("listeAdresses")) {
			out.println(adres.getRue()+ " " + adres.getVille());
	%>		
			<input name="Adresse"  value="<%=adres.getId()%>" type="radio"/> </br>
	<% } %>
	<input type="submit" value="ok">
	<input type="hidden" name="op" value="association">
	</form>
</body>
</html>