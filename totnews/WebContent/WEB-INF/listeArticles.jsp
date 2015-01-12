<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.droits.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../STYLE/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="../STYLE/style.css" rel="stylesheet">
<title>Liste des articles </title>
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
            <li><a href="index.html">Déconnexion</a></li>
          </ul>
        </div>
      </div>
    </nav>

	<div class="container">
	
	  <!-- Menu -->
      <div class="row">
        <nav class="col-sm-2">   
          <ul class="nav nav-pills nav-stacked">
            <li class="menu"> Menu :  </li>
            <li> <a href="ServletComptes?op=RetourIndex"> <span class="glyphicon glyphicon-home"></span> Acceuil </a> </li>
            <li> <a href="ServletComptes?op=Deconnexion"> <span class="glyphicon glyphicon-remove"></span> Déconnexion </a> </li>
          </ul> 
        </nav>
		
		<section class="col-sm-10">
		<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Articles de T.O.T. News</h3>
				</div>
				<div class="panel-body">
					<div class="container">
						Un article de fou <dd>     
						<a href="#"> <span class="glyphicon glyphicon-book"></span> Lire </a>
						<a href="#"> <span class="glyphicon glyphicon-pencil"></span> Corriger </a>
						<a href="#"> <span class="glyphicon glyphicon-globe"></span> Publier</a>
						</br>
						Un autre article <dd>     
						<a href="#"> <span class="glyphicon glyphicon-book"></span> Lire </a>
						<a href="#"> <span class="glyphicon glyphicon-pencil"></span> Corriger </a>
						<a href="#"> <span class="glyphicon glyphicon-globe"></span> Publier</a>
						</br>
						Et un troisième <dd>     
						<a href="#"> <span class="glyphicon glyphicon-book"></span> Lire </a>
						<a href="#"> <span class="glyphicon glyphicon-pencil"></span> Corriger </a>
						<a href="#"> <span class="glyphicon glyphicon-globe"></span> Publier</a>
						</br>
						On est envahi !!! <dd>     
						<a href="#"> <span class="glyphicon glyphicon-book"></span> Lire </a>
						<a href="#"> <span class="glyphicon glyphicon-pencil"></span> Corriger </a>
						<a href="#"> <span class="glyphicon glyphicon-globe"></span> Publier</a>
					</div> 
				</div>
			</div>

	</section>
</body>
</html>