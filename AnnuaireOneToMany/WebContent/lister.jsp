<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, oneToMany.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des personnes</title>
</head>
<body>
	Liste des personnes : </br>
	<%
		for (oneToMany.Personne pers : (Collection<oneToMany.Personne>)request.getAttribute("listePersonnes")) {
		out.println(pers.getNom() + " " + pers.getPrenom() + " : "); %> </br> 
			<% 
				for(oneToMany.Adresse adres : (Collection<oneToMany.Adresse>)pers.getAdressesPers()) {
					out.println(adres.getRue() + " " + adres.getVille()); %> </br> 
			    <% 
				}		
		}
	%>
</body>
</html>