<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Quizz" %>
<%@ page import="entities.Reponse" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> PHD - Repondre au  Quizz </title>
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
<h3> Quizz </h3>
<p> Tentez de répondre aux questions du quizz ci-dessous.
</p>
</div>

<!--  Recuperation des données utiles a l'édition de la réponse -->
<%
	Quizz q = (Quizz) request.getAttribute("quizz");
	Integer erreur = (Integer) request.getAttribute("erreur");
		if (!(erreur == null)) {
			int err = erreur.intValue();
			if (err == 1)
	 		out.println(" <p class='erreur'> Veuillez répondre à toutes les avenues proposées par le Quizz ! <br /> <br /> </p>");	
	}
%>

<!-- Formulaire de réponse au Quizz -->

<%
	out.println("<form id='formulaire' method='post' action='resultat.do?id=" + String.valueOf(q.getNum()) + "'>");
%>

<section>
<div id="donnees">
	<fieldset>
		<legend><span class="info">Informations préliminaires</span> </legend>
		<br />
       	<label><span class="info">Auteur :</span></label> <!--<br />-->
       	<%
           	out.println(q.getMembre().getId() + " (" + q.getMembre().rang() + ")");
      	%>
      	<br /> <br /><br/>
		<label><span class="info">Main de départ :</span></label> <!--<br />-->
		<%
			out.println(q.getCarte1() + " de " + q.getCouleur1() +" - ");
			out.println(q.getCarte2() + " de " + q.getCouleur2());
		%>
		<br /> <br /><br/>
		<label><span class="info">Catégorie :</span></label> <!--<br />-->
		<%
			out.println(q.getCategorie());
		%>
		<br /> <br/><br/>
		<label><span class="info">Situation :</span></label>	<!--<br />-->
		<%
			out.println(q.getSituation());
		%>
		<br /><br/>
	</fieldset>
</div>

<div id="situation">
	<fieldset>
		<legend> Déroulement du coup </legend>
		<br />
		<ul>
		<li>
		<label> Situation <em>Pré-Flop :</em> </label>
		<br />
			<%
				out.println(q.getPreflop()+ "<br /> <br />");
			%>
        </li>
        <li>
        <label> Que faites-vous? </label><br/>
			<input type="radio" name="reponsePreflop" value="Fold"> Se coucher <br />
			<input type="radio" name="reponsePreflop" value="Call" > Suivre <br />
			<input type="radio" name="reponsePreflop" value="Raise"> Relancer <br />
        </li>
        <li>
			<label> Justifiez éventuellement :</label> <br />
			<textarea name="justificationPreflop" id="justificationPreflop"> </textarea> <br /> <br />
        </li>
        </ul>

		<ul>
		<li>
		<label> Situation au <em>Flop :</em> </label>
		<br />
			<%
				if (q.getChoixFlop() == null) {
					out.println("Le coup s'est arrêté <br /> <br /></li>");
				} else {
					out.println(q.getFlop()+ "<br /> <br /></li>");
					out.println("<li><label> Que faites-vous?</label><br/>");
					out.println("<input type='radio' name='reponseFlop' value='Fold'> Se coucher <br />");
					out.println("<input type='radio' name='reponseFlop' value='Call' > Suivre <br />");
					out.println("<input type='radio' name='reponseFlop' value='Raise'> Relancer <br />	</li>");
					out.println("<li><label> Justifiez éventuellement :</label> <br />");
					out.println("<textarea name='justificationFlop' id='justificationFlop'></textarea> <br /> <br /></li>	");
				}
			%>
		</ul>
		<ul>
		<li>
		<label> Situation au <em>Turn :</em> </label>
		<br />
			<%
				if (q.getChoixTurn() == null) {
					out.println("Le coup s'est arrêté <br /> <br /></li>");
				} else {
					out.println(q.getTurn()+ "<br /> <br /></li>");
					out.println("<li><label> Que faites-vous?</label><br/>");
					out.println("<input type='radio' name='reponseTurn' value='Fold'> Se coucher <br />");
					out.println("<input type='radio' name='reponseTurn' value='Call' > Suivre <br />");
					out.println("<input type='radio' name='reponseTurn' value='Raise'> Relancer <br />	</li>");
					out.println("<li><label> Justifiez éventuellement :</label> <br />");
					out.println("<textarea name='justificationTurn' id='justificationTurn'></textarea> <br /> <br /></li>	");
				}
			%>
		</ul>
		<ul>
		<li>
		<label> Situation à la <em>River :</em> </label>
		<br />
			<%
				if (q.getChoixRiver() == null) {
					out.println("Le coup s'est arreté <br /> <br /></li>");
				} else {
					out.println(q.getRiver()+ "<br /> <br /></li>");
					out.println("<li><label> Que faites-vous?</label><br/>");
					out.println("<input type='radio' name='reponseRiver' value='Fold'> Se coucher <br />");
					out.println("<input type='radio' name='reponseRiver' value='Call' > Suivre <br />");
					out.println("<input type='radio' name='reponseRiver' value='Raise'> Relancer <br />	</li>");
					out.println("<li><label> Justifiez éventuellement :</label> <br />");
					out.println("<textarea name='justificationRiver' id='justificationRiver'></textarea> <br /> <br /></li>	");
				}
			%>
		</ul>
	</fieldset>
</div>

    <fieldset>
       <legend> Commentaires </legend>
          <br />
          <div id="champ">
            <label> Eventuelles explications complémentaires sur vos réponses : </label> <br /> <br />
            <textarea name="description" id="description"> </textarea> <br />
          </div>
          <br />
    </fieldset>

        <p class="creation">
          <input type="submit" value="Envoyer mes réponses" />
        </p>

</form>

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
