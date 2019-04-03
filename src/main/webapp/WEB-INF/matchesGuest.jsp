<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Shaolin Tennis</title>
<link rel="icon" href="kungten.png" type="image/png" sizes="16x16" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="robots" content="index, follow">
<link rel="stylesheet" type="text/css" href="css/matchesGuest.css" />
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<img src="img/kungten.png" alt="Kung Fu Kick" />

		<nav>
			<ul>
				<li><a href="Home">Accueil</a></li>
				<li><a href="About">À propos</a></li>
				<li><a href="Contact">Contact</a></li>
				<li id="#bye"><a href="SoLong">Déconnexion</a></li>
			</ul>
		</nav>
	</header>

	<main>
			<table id="matches">
				<tr>
					<th colspan="7">Rencontres Planifiées</th>
				</tr>
				<tr>
					<th>Joueur A</th>
					<th>Joueur B</th>
					<th>Arbitre</th>
					<th>Court</th>
					<th>Date</th>
				</tr>
				<c:if test="${listeM != null}">

					<c:forEach var="Match" items="${listeM}">

						<tr>

							<td>${Match.player1.prenom} ${Match.player1.nom}</td>
							<td>${Match.player2.prenom} ${Match.player2.nom}</td>
							<td>${Match.umpire.prenom} ${Match.umpire.nom}</td>
							<td>${Match.court.nom}</td>
							<td>${Match.date}</td>
							
						</tr>

					</c:forEach>
				
				</c:if>
			</table>	
	</main>

	<footer>
		<p>©Los Stinky Pumas - 2018</p>
	</footer>

	<script src="js/mrec.js"></script>
	<script src="js/calendrier.js"></script>
</body>
</html>