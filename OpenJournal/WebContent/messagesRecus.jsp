<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ page import="java.util.*, beans.texte.*"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Boite mail de messages reçus</title>
</head>
<body>

Liste des messages reçus :
<% 
	String format = "dd/MM/yy H:mm:ss";
	java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
	
	for (MessagePrive mpRecu : (Collection<MessagePrive>)request.getAttribute("mpRecus")) {
		out.println("Auteur :" + mpRecu.getAuteur().getPseudoSite() ); 
		%>
		</br>
		<%
		out.println("Objet :" + mpRecu.getObjet() ); 
		%>
		</br>
		<%
		Date date =mpRecu.getDatePub();
		out.println(formater.format(date)); 
		%>
		</br>
		<a href="ServletMessagerie?op=lireMessages&id=<%=mpRecu.getId()%>">Lire le message</br></a>	
		<%
	}
%>
</br>



</body>
</html>