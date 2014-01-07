<%@page import="entities.Membre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, javax.servlet.http.HttpSession, entities.Quizz;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> PHD - Espace Membre </title>
<link rel="stylesheet" href="style_espace_membre.css">
</head>

<body>
<div id="page_interieure">

<header>
<img src="images/logoPHD.png" alt="logo as" id="logo">
	<div id="titre">
	<h1> Poker Hand Database</h1>
	<h2> Sauriez-vous jouer toutes ces mains? </h2>
	</div>
</header>

<nav>
<ul>
	<li><a href="deconnexion.do">Accueil</a></li>
	<li><a href="/PHD/EspaceMembre">Espace Membre</a></li>
	<li><a href="CreerQuizz.jsp">Créer mon quizz</a></li>
	<li><a href="Recherche.jsp">Rechercher un quizz</a></li>
</ul>
</nav>

<div id="presentation">
<h3> Espace Membre </h3>
<p> Ce site communautaire de Poker vous propose de <a href="CreerQuizz.jsp" class="intxt">créer</a> vos analyses de main sous forme de quizzs et de répondre aux <a href="Recherche.jsp" class="intxt">quizzs</a> soumis par les autres membres
<br />
<br/>
Gagnez des points pour améliorer votre Rang en créant des Quizz ou en répondant à ceux des autres ! <br />
</p>
</div>

<!-- Infos de connexion : Récuperer les infos de la session pour indentifier le membre -->
<%
entities.Membre membre =(entities.Membre) session.getAttribute("membre");
%>

<section>

	<div id="derniers_quizzs">
	<!-- Rien pour l'instant à l'intérieur -->
	<h4>Voici les derniers quizzs qui ont été postés :</h4>

	<fieldset>
    <legend> Liste des Quizz </legend>
       <!-- Afficher les 10 derniers quizzs postés -->
       <%
       List<Quizz> quizzs = (List<Quizz>) request.getAttribute("quizzs");
       if (quizzs != null) {
       	if (quizzs.size() == 0) {
    		out.println("Pas de Quizz récemment posté");
       	}
       	else {
    		int i;
		   	for(i=quizzs.size()-10;i<quizzs.size();i++) {
    	   		if (i>=0) {
    	   			Quizz q = quizzs.get(i);
    	   			// reponse.do avec l'ID du Quizz passé en paramètre
    	   			out.println("<a href='reponse.do?id=" + String.valueOf(q.getNum()) + "'>");
    	   			out.println(q.getCarte1() + " de " + q.getCouleur1() + " - " +q.getCarte2() + " de " + q.getCouleur2());
    	   			out.println("</a>");
    	   			out.println("<br />");
    	   		}
			}
	   	}
       }
       %>
	</fieldset>
	</div>

    <aside>
    <fieldset>
        <legend> Mon compte </legend>
        <p class="mon_compte">
	    <span class="info">Pseudo :</span> <% out.println(membre.getId()); %> <br />
	  	<span class="info">Nom :</span> <% out.println(membre.getNom()); %> <br />
	    <span class="info">Prénom :</span> <% out.println(membre.getPrenom()); %> <br />
	    <span class="info">Rang :</span> <% out.println(membre.rang() + " ( " + membre.getPoints() + " points )"); %> <br />
	    <br />
        </p>
    </fieldset>

    <fieldset>
        <legend> Options</legend>
        <p class="options">
	    <a href="ChangementMDP.html"> Changer mon mot de passe </a> <br />
	    <a href="ChangementMail.html"> Changer mon adresse e-mail </a> <br />
        </p>
	    <p>
	    <a href="deconnexion.do"> Se déconnecter </a> <br />
        </p>
    </fieldset>

<!-- Afficher des stats ? -->
	</aside>

</section>

<footer>
    <p>
    <img src="images/env.jpeg" alt="enveloppe" id="env">
	<a href="mailto:tanguy.jovet@etu.enseeiht.fr"> Contact us </a></p>
<footer/>

</div>
</body>

</html>
