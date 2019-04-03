<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Shaolin Tennis</title>
<link rel="icon" href="img/kungten.png" type="image/png"
	sizes="16x16" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="robots" content="index, follow">
<meta name="description"
	content="Le Shaolin Tennis Tournament est un tournoi de tennis fictif créé par Octoven Nevotco dans le cadre d'une formation DevWeb de l'Afpa.">
<meta name="keywords"
	content="afpa, exercise, tennis, tournament, shaolin, html, css, jsp">
<meta name="author"
	content="Octoven Nevotco Web Dev and Mobile Web Dev trainee">
<link rel="stylesheet" type="text/css" media="all"
	href="css/login.css" />
</head>
<body>
	<header>
		<img src="img/kungten.png" alt="Kung Fu Kick" />

		<nav>
			<ul>
				<li><a href="Home">Accueil</a></li>
				<li><a href="About">À propos</a></li>
				<li><a href="Contact">Contact</a></li>
<!-- 				<li id="#bye"><a href="quiça">Connexion</a></li> -->
			</ul>
		</nav>
	</header>

	<main>
	<h1>Shaolin Tennis Tournament - Connexion</h1>
	<p id="war1"></p>
	<form action="Login" id="register" method="post">
		<p>
			<input type="text" name="pseudo" id="pseudo"
				placeholder="Votre identifiant" required />
		</p>
		<p>
			<input type="password" name="mdp" id="psswd"
				placeholder="Votre mot de passe" required />
		</p>
		<input type="submit" value="Connexion" id="rec" /> <input
			type="reset" value="Effacer" id="erase" />
	</form>
	</main>


	<footer>
		<p>©Los Stinky Pumas - 2018</p>
	</footer>

</body>
</html>