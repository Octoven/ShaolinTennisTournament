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
<link rel="stylesheet" type="text/css" href="css/matches.css" />
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
	<h2>Inscription</h2>
	<div id="warn">
		<p id='warning'></p>
	</div>
	<form id="form_register" action="AddMatch" method="post">

		<div id="idnumber">
			<label for="id">ID</label> <input type="text" id="id" name="id"
				placeholder='Uniquement pour modif.'>
		</div>
		<div id="pl1">
			<label for="j1">J1</label> <select id='j1' name="joueur1">
				<c:if test="${listeJ != null}">
					<c:forEach var="Player" items="${listeJ}">
						<option value="${Player.player_id}">${Player.prenom} ${Player.nom}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div id="pl2">
			<label for="j2">J2</label> <select id='j2' name="joueur2">
				<c:if test="${listeJ != null}">
					<c:forEach var="Player" items="${listeJ}">
						<option value="${Player.player_id}">${Player.prenom} ${Player.nom}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div id="umpires">
			<label for="umpire">Arbitre</label> <select id='umpire' name="umpire">
				<c:if test="${listeU != null}">
					<c:forEach var="Umpire" items="${listeU}">
						<option value="${Umpire.umpire_id}">${Umpire.prenom} ${Umpire.nom}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div id="court">
			<label for="crt">Court</label> <select id='crt' name="court">
				<c:if test="${listeC != null}">
					<c:forEach var="Court" items="${listeC}">
						<option value="${Court.court_id}">${Court.nom}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div id="setDate">
			<label for="datepicker">Date</label> <input type="text" name="date"
				id="datepicker">
		</div>
		<input id="record" type="submit" value="Planifier la rencontre" name="update" /><input
			type="submit" id="update" name="update" value="Modifier la rencontre" />

	</form>
	</main>

	<section>
		<form action="RemoveMatch" method="post">
			<h3>Tableau des rencontres</h3>
			<table id="matches">
				<tr>
					<th colspan="7">Rencontres Planifiées</th>
				</tr>
				<tr>
					<th>ID</th>
					<th>Joueur A</th>
					<th>Joueur B</th>
					<th>Arbitre</th>
					<th>Court</th>
					<th>Date</th>
					<th>Select</th>
				</tr>
				<c:if test="${listeM != null}">

					<c:forEach var="Match" items="${listeM}">

						<tr>

							<td>${Match.match_id}</td>
							<td>${Match.player1.prenom} ${Match.player1.nom}</td>
							<td>${Match.player2.prenom} ${Match.player2.nom}</td>
							<td>${Match.umpire.prenom} ${Match.umpire.nom}</td>
							<td>${Match.court.nom}</td>
							<td>${Match.date}</td>
							<td><input type="radio" name="select"
								value="${Match.match_id}" /></td>

						</tr>

					</c:forEach>
					<tr>
						<td colspan="7"><input type="submit" value="Supprimer"
							name="action" /></td>
					</tr>
				</c:if>
			</table>
		</form>
	</section>


	<footer>
		<p>©Los Stinky Pumas - 2018</p>
	</footer>

	<script src="js/mrec.js"></script>
	<script src="js/calendrier.js"></script>
</body>
</html>