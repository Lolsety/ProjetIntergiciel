<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.droits.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/STYLE/bootstrap/dist/css/bootstrap.css }">
<link href="${pageContext.request.contextPath}/STYLE/style.css" rel="stylesheet">
<title>T.O.T; News </title>
</head>

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
            <li><a href="ServletComptes?op=Deconnexion">Déconnexion</a></li>
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
            	<%switch (droit) {
				  case ADMNINISTRATEUR:
				%>
					<li><a href="ServletDroits?op=GererDroits">Gérer les droits</a></li>
						<%
						break;
					default: break;
					}
					%>				
					<li> <a href="ServletComptes?op=Deconnexion">Déconnexion</a>  </li>
					<li> <a href="ServletComptes?op=RetourIndex"> Retour à l'accueil</a>  </li>
					<li> <a href="ServletArticles?op=redigerArticle">Rédiger un article</a>  </li>
					<li> <a href="ServletArticles?op=listerArticles">Lister les articles</a>  </li>
					<li> <a href="ServletMessagerie?op=accederMessagerie">Messagerie</a>  </li>
          </ul> 
        </nav>
		
		<!-- Article -->
        <section class="col-lg-10">
			<div class="panel panel-default">
				<div class="panel-body">
					<center>
					<h1>You have been successfully logged in as </h1>
    				<h1><%= request.getUserPrincipal().getName() %> </h1>
    				<h1> And you are an <%= droit %> </h1>	
    				<br>
					</center>
				</div>
			</div>
        </section>

      </div>
	  </div>
    </div>
	</body>
</html>