<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.comptes.*, java.util.*,beans.droits.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/STYLE/bootstrap/dist/css/bootstrap.css">
<link href="${pageContext.request.contextPath}/STYLE/style.css" rel="stylesheet">
<title>Page de gestions des droits</title>
</head>
<body>

  <!-- Barre de titre -->
   <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">
			T.O.T News
		  </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="LoginServlet">Déconnexion</a></li>
          </ul>
        </div>
      </div>
    </nav>

	<div class="container">
	
	<%Droit droit=(Droit) request.getAttribute("droit"); %>
	
	  <!-- Menu -->
      <div class="row">
        <nav class="col-sm-2">   
          <ul class="nav nav-pills nav-stacked">
            <li class="menu"> Menu :  </li>
				<li> <a href="ServletComptes?op=RetourIndex"> Retour à l'accueil </a> </li>
				<li> <a href="ServletComptes?op=Deconnexion">Déconnexion </a> </li>			
          </ul> 
        </nav>
		
		<!-- Article -->
        <section class="col-lg-10">
			<div class="panel panel-default">
				<div class="panel-body">
					<center>
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
						for (Droit d : Droit.values()) {
						out.println(d + " : ");
						%>
						<input name="Droit" value="<%= droit%>" type="radio"/> <br>
						<%
						}
						%>
						</br>
						<button class="btn  btn-primary" type="submit">OK</button>
						<input type="hidden" name="op" value="modifDroits">
						</form>	
					</center>
				</div>
			</div>
        </section>

</body>
</html>