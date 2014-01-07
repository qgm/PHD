<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Quizz" %>
<%@ page import="entities.Reponse" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> PHD - Résultat du  Quizz </title>
<link rel="stylesheet" href="style_quizz.css">
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
<h3> Réponse au quizz </h3>
<p> Voici les réponses attendues par l'auteur du quizz.
</p>
</div>

<!--  Recuperation des données utiles a l'édition du résultat -->
<%
	Quizz q = (Quizz) request.getAttribute("quizz");
	Reponse r = (Reponse) request.getAttribute("reponse");
%>

<!-- Résultat du Quizz -->
<section>
<div id="donnees">
	<fieldset>
		<legend><span class="info"> Informations préliminaires</span>  </legend>
		<br />
       	<label><span class="info"> Auteur :</span></label> <!--<br />-->
       	<%
       		out.println(q.getMembre().getId() + " (" + q.getMembre().rang() + ")");
      	%>
      	<br /> <br />
		<label><span class="info"> Main de départ :</span></label> <!--<br />-->
		<%
			out.println(q.getCarte1() + " de " + q.getCouleur1() +" - ");
			out.println(q.getCarte2() + " de " + q.getCouleur2());
		%>
		<br /> <br />
		<label><span class="info"> Catégorie :</span></label> <!--<br />-->
		<%
			out.println(q.getCategorie());
		%>
		<br /> <br/>
		<label><span class="info"> Situation :</span></label>	<!--<br />-->
		<%
			out.println(q.getSituation());
		%>
		<br /> <br />
		<!-- <label> Statistiques :</label> <!--<br />-->
		<%
			//out.println(q.statsQuizz() + " % des internautes sont d'accord avec " + q.getMembre().getId()+".");
		%>
	</fieldset>
</div>

<div id="situation">
	<fieldset>
		<legend> Déroulement du coup </legend>
		<br />
		<label> Situation <em>Pré-Flop :</em></label>
			<%
				out.println(" " +q.getPreflop()+ "<br />");
				out.println("Vous avez choisi : " + r.getReponsePreflop() + "<br />");
				out.println("La réponse était : " + q.getChoixPreflop() + "<br />");
				out.println("Voici sa justification : " + q.getJustificationPreflop() + "<br />");
				// out.println("<br /> Pourcentage de personnes qui se sont couchées : " +q.statsPreflopFold() + " % <br />");
				// out.println("<br /> Pourcentage de personnes qui ont suivi : " +q.statsPreflopCall() + " % <br />");
				// out.println("<br /> Pourcentage de personnes qui ont relancé : " +q.statsPreflopRaise() + " % <br />");
			%>
		<br />
		<hr> <br />
		<label> Situation au <em>Flop :</em> </label>
			<%
				if (q.getFlop().equals(" ") || q.getFlop() == null) {
					out.println(" Le coup s'est arrêté <br />");
				} else {
					out.println(" " +q.getFlop()+ "<br />");
					out.println("Vous avez choisi : " + r.getReponseFlop() + "<br />");
					out.println("La réponse était : " + q.getChoixFlop() + "<br />");
					out.println("Voici sa justification : " + q.getJustificationFlop() + "<br />");
					// out.println("<br /> Pourcentage de personnes qui se sont couchées : " +q.statsFlopFold() + " % <br />");
					// out.println("<br /> Pourcentage de personnes qui ont suivi : " +q.statsFlopCall() + " % <br />");
					// out.println("<br /> Pourcentage de personnes qui ont relancé : " +q.statsFlopRaise() + " % <br />");
				}
			%>
		<br />
		<hr> <br />
		<label> Situation au <em>Turn :</em> </label>
			<%
				if (q.getTurn().equals(" ") || q.getTurn() == null) {
					out.println(" Le coup s'est arrêté <br />");
				} else {
					out.println(" " +q.getTurn()+ "<br /> <br />");
					out.println("Vous avez choisi : " + r.getReponseTurn() + "<br />");
					out.println("La réponse était : " + q.getChoixTurn() + "<br />");
					out.println("Voici sa justification : " + q.getJustificationTurn() + "<br />");
					// out.println("<br /> Pourcentage de personnes qui se sont couchées : " +q.statsTurnFold() + " % <br />");
					// out.println("<br /> Pourcentage de personnes qui ont suivi : " +q.statsTurnCall() + " % <br />");
					// out.println("<br /> Pourcentage de personnes qui ont relancé : " +q.statsTurnRaise() + " % <br />");
				}
			%>
		<br />
		<hr> <br />
		<label> Situation à la <em>River :</em> </label>
			<%
				if (q.getRiver().equals(" ") || q.getRiver() == null) {
					out.println(" Le coup s'est arreté <br />");
				} else {
					out.println(" " +q.getRiver()+ "<br /> <br />");
					out.println("Vous avez choisi : " + r.getReponseRiver() + "<br />");
					out.println("La réponse était : " + q.getChoixRiver() + "<br />");
					out.println("Voici sa justification : " + q.getJustificationRiver() + "<br />");
					// out.println("<br /> Pourcentage de personnes qui se sont couchées : " +q.statsRiverFold() + " % <br />");
					// out.println("<br /> Pourcentage de personnes qui ont suivi : " +q.statsRiverCall() + " % <br />");
					// out.println("<br /> Pourcentage de personnes qui ont relancé : " +q.statsRiverRaise() + " % <br />");
				}
			%>
		<br />
	</fieldset>
</div>

    <fieldset>
       <legend> Description complémentaire </legend>
          <br />
          <div id="champ">
          <%
        		out.println("Explications complémentaires du créateur : <br />");
        		out.println(q.getDescription() + " <br /> <br /> ");
        		out.println("Vous avez gagné : " + r.pointsObtenus() + " points ! <br /> ");
          %>
   	      <br />
   	      </div>
    </fieldset>

  <p class="retour">
     <a href="/PHD/EspaceMembre"> Retour à l'espace membre </a>
  </p>

</section>

<footer>
    <p>
    <img src="images/env.jpeg" alt="enveloppe" id="env">
	<a href="mailto:tanguy.jovet@etu.enseeiht.fr"> Contact us </a></p>
<footer/>

</div>
</body>
</html>
