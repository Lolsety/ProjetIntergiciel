<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, beans.texte.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/STYLE/bootstrap/dist/css/bootstrap.css }">
<link href="${pageContext.request.contextPath}/STYLE/style.css" rel="stylesheet">
<title>Lecture du message</title>
</head>
<body>
<%
		String format = "dd/MM/yy H:mm:ss";
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 

		MessagePrive messagePrive = (MessagePrive) request.getAttribute("messagePrive");
		out.println("Auteur :" + messagePrive.getAuteur().getPseudoSite() ); 
		%>
		<br>
		<%
		out.println("Objet :" + messagePrive.getObjet() ); 
		%>
		<br>
		<%
		Date date =messagePrive.getDatePub();
		out.println(formater.format(date)); 
		%>
		<br>
		Contenu :
		<br>
		<%
		out.println(messagePrive.getText());
%>
</br>

<a href="ServletMessagerie?op=accederMessagerie">Retour à la messagerie</br></a>

</body>
</html>