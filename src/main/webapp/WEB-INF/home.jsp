<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Shaolin Tennis</title>
<link rel="icon" href="img/kungten.png" type="image/png" sizes="16x16" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="robots" content="index, follow">
<link rel="stylesheet" type="text/css" href="css/home.css" />
</head>
<body>
	<header>
		<img src="img/kungten.png" alt="Kung Fu Kick" />

		<nav>
			<ul>
				<li><a href="About">À propos</a></li>
				<li><a href="Contact">Contact</a></li>
				<li id="#bye"><a href="quiça">Connexion</a></li>
			</ul>
		</nav>
	</header>

	<main>
	<div id="players">
		<p>Joueurs</p>
		<a href="AuthPlayers"><img src="img/mc00.jpg" alt="Joueur"></a>
	</div>
	<div id="umpires">
		<p>Arbitres</p>
		<a href="AuthUmpires"><img src="img/umpire.jpg" alt="Arbitre"></a>
	</div>
	<div id="courts">
		<p>Courts</p>
		<a href="AuthCourts"><img src="img/etc00.jpg" alt="Court"></a>
	</div>
	<div id="matches">
		<p>Rencontres</p>
		<a href="AuthMatches"><img src="img/tts00.jpg" alt="Rencontres"></a>
	</div>
	<div id="records">
		<p>Résultats</p>
		<a href="AuthResults"><img src="img/tsb00.jpg" alt="Tableau de score"></a>
	</div>
	<div id="exit">
		<p>Déconnexion</p>
		<a href="SoLong"><img src="img/dc.jpg" alt="Fuir"></a>
	</div>
	</main>


	<footer>
		<p>©Los Stinky Pumas - 2018</p>
	</footer>

</body>
</html>