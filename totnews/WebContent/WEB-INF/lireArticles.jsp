<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../STYLE/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="../STYLE/style.css" rel="stylesheet">
<title>L’énergie du désespoir serait la seule énergie réellement renouvelable </title>
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
	
	  <!-- Menu -->
      <div class="row">
        <nav class="col-sm-2">   
          <ul class="nav nav-pills nav-stacked">
            <li class="menu"> Menu :  </li>
            <li> <a href="ServletComptes?op=RetourIndex"> <span class="glyphicon glyphicon-home"></span> Acceuil </a> </li>
            <li> <a href="ServletComptes?op=Deconnexion"> <span class="glyphicon glyphicon-remove"></span> Déconnexion </a> </li>
          </ul> 
        </nav>
		
		<!-- Affichage de l'Article -->
        <section class="col-lg-10">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">L’énergie du désespoir serait la seule énergie réellement renouvelable !</h3>
				</div>
				<div class="panel-body">
					<p>Selon plusieurs experts, il semble que l’énergie du désespoir serait vraisemblablement la seule énergie totalement renouvelable. 
					Une énergie que tout un chacun disposerait en lui, à tout moment et totalement inépuisable et ce toute sa courte vie. Chaque coup dur de 
					votre vie vous donne parfois envie de contre-attaquer et de vous battre, même si vous savez pertinemment que vous n’aurez pas cet appartement 
					ou que il ou elle ne vous parlera plus jamais. C’est cela cette incroyable énergie du désespoir dans laquelle désormais de grandes sociétés 
					placent de grands espoirs.</p>
					<p>Une énergie qui sera totalement renouvelable et ce tant qu’il y aura des humains et donc du désespoir. « Les deux vont ensemble. 
					Dès qu’il y a des gens quelque part, aussitôt le désespoir apparaît. Donc tant que nous aurons des gens à disposition, nous pouvons compter 
					sur une énergie quasi illimitée » explique un responsable d’ERDF. De plus, certains notent un grand avantage avec d’autres sources d’énergie 
					renouvelable comme les éoliennes. « Les éoliennes sont critiquées pour leur bruit et le fait qu’elles abîment le paysage tandis que les gens… 
					attendez… non oubliez » explique un autre expert, avant de comprendre que son analogie avec « les gens » ne fonctionnait pas du tout et 
					demandait à ce que ce passage soit retiré de cet article.</p>
					<p>Toujours selon ERDF, le système de captation de cette énergie est déjà étudié. « Il suffit juste de placer les gens en grande difficulté dans 
					un bâtiment clos avec des électrodes et ils ont cette énergie à foison » commente un expert qui chiffre le potentiel de cette énergie totalement 
					verte à l’équivalent de plusieurs centrales nucléaires, surtout dans des temps très durs comme la crise économique ou une annonce d’une blessure 
					d’Ibra. Seul bémol : les bonnes nouvelles pourraient altérer la production d’énergie du désespoir. « Mais la situation économique et internationale 
					nous laisse de la marge, au moins pour plusieurs siècles, largement après la fin du pétrole » souligne un spécialiste.</p>
					<p>Déjà EDF envisage de placer dans ce système de cuve connectée plusieurs personnes qui seraient potentiellement sources massives d’énergie 
					du désespoir comme un électeur de François Hollande, un supporter de Guimgamp ou un téléspectateur du Touche Pas mon Poste.
					</p>
				</div>
			</div>
 
		<!-- Afichage des Commentaires -->
		<div class="panel panel-default">
				<div class="panel-body">
					<b>Jean-Jacques goldman a dit :</b> Cet article c'est de la merde! </br>
					<b>Superman a dit :</b> youpiiiiiiiiiiiiiiiiii!</br>
					<b>Mireille Matthieu a dit :</b> j'ai pas compris !</br>
					
					<!-- Ecrire un commentaire -->
					<form method="get" action="ServletArticles">
						<textarea name="commentaire">
						</textarea> </br>
							<button class="btn btn-primary" type="submit" value="Poster le commentaire">Poster le commentaire</button></br>
							<input type="hidden" name="op" value="posterCommentaire">
						</form>
					
				</div>
	    </div>
 
        </section>
      </div>
	  </div>
    </div>
	</body>
</html>