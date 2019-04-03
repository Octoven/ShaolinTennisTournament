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
<link rel="stylesheet" type="text/css" href="css/courtsGuest.css" />
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

	<table id="courts">
		<tr>
			<th colspan="3">Courts enregistrés</th>
		</tr>
		<tr>
			<th>Court</th>
			<th>Terrain</th>
			<th>Pays</th>
		</tr>
		<c:if test="${liste != null}">

			<c:forEach var="Court" items="${liste}">

				<tr>
				
					<td>${Court.nom}</td>
					<td>${Court.terrain}</td>
					<td>${Court.pays}</td>
					
				</tr>

			</c:forEach>

		</c:if>
	</table>

	</main>


	<footer>
		<p>©Los Stinky Pumas - 2018</p>
	</footer>


</body>
</html>