<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../STYLE/bootstrap/dist/css/bootstrap.css">
<link href="../../STYLE/style.css" rel="stylesheet">
<title>Rediger un article</title>
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
					<center class="ecriture_message">
							<form method="get" action="ServletArticles">
								<input type="text" name="Titre" value="Titre de l'article"> </br>
								<textarea name="CorpsArticle"></textarea>
								</br></br>
								<button class="btn  btn-primary" type="submit">Soumettre l'article</button>
								<input type="hidden" name="op" value="soumissionArticle">
								</form>
					</center>
				</div>
			</div>
        </section>

      </div>
	  </div>
    </div>
	</body>
</head>
