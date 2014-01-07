<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> PHD - Création d'un Quizz </title>
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
<h3> Création d'une analyse de main </h3>
<p> Décrivez ici vos coups de poker les plus intéressants.
</p>
</div>

<div id="erreur">
<%
Integer erreur = (Integer) request.getAttribute("erreur");
if (!(erreur == null)) {
	int err = erreur.intValue();
	if (err == 1)
		out.println("<br /> Vous devez remplir tous les champs <br />");
	if (err == 2)
		out.println("<br /> Vos 2 cartes sont identiques ! <br />");
}
%>
</div>

<!-- Formulaire de création du Quizz -->

<section>
<form  id="formulaire" method="post" action="creation.do">

<div id="donnees">
    <fieldset>
       <legend><span class="info"> Données </span></legend>
          <ul>
          <li>
            <label for="carte1"><span class="info"> Carte 1 :</span> </label> <br />
            <select name="carte1" id="carte1">
              <option value="choisir"> Choisir </option>
              <option value="As"> As </option>
              <option value="K"> Roi </option>
           	  <option value="Q"> Dame </option>
           	  <option value="J"> Valet</option>
           	  <option value="10"> Dix </option>
           	  <option value="9"> Neuf </option>
              <option value="8"> Huit </option>
              <option value="7"> Sept </option>
              <option value="6"> Six </option>
              <option value="5"> Cinq </option>
              <option value="4"> Quatre </option>
              <option value="3"> Trois </option>
              <option value="2"> Deux </option>
       	    </select><br />
       	    <label for="couleur1"><span class="info"> Couleur :</span> </label> <br />
            <select name="couleur1" id="couleur1">
              <option value="choisir"> Choisir </option>
              <option value="Pique"> Pique </option>
              <option value="Coeur"> Coeur </option>
           	  <option value="Carreau"> Carreau </option>
           	  <option value="Trefle"> Trefle </option>
           	</select>
   	      </li>
   	      <li>
            <label for="carte2"><span class="info"> Carte 2 :</span> </label> <br />
            <select name="carte2" id="carte2">
              <option value="choisir"> Choisir </option>
              <option value="As"> As </option>
              <option value="K"> Roi </option>
           	  <option value="Q"> Dame </option>
           	  <option value="J"> Valet</option>
           	  <option value="10"> Dix </option>
           	  <option value="9"> Neuf </option>
              <option value="8"> Huit </option>
              <option value="7"> Sept </option>
              <option value="6"> Six </option>
              <option value="5"> Cinq </option>
              <option value="4"> Quatre </option>
              <option value="3"> Trois </option>
              <option value="2"> Deux </option>
       	    </select><br />
       	    <label for="couleur2"><span class="info"> Couleur :</span> </label> <br />
            <select name="couleur2" id="couleur2">
              <option value="choisir"> Choisir </option>
              <option value="Pique"> Pique </option>
              <option value="Coeur"> Coeur </option>
           	  <option value="Carreau"> Carreau </option>
           	  <option value="Trefle"> Trefle </option>
           	</select>
   	      </li>
   	       <li>
            <label for="position"><span class="info"> Position :</span> </label> <br />
            <select name="position" id="position">
              <option value="choisir"> Choisir </option>
              <option value="UTG">   UTG   </option>
              <option value="UTG+1"> UTG+1 </option>
           	  <option value="UTG+2"> UTG+2 </option>
           	  <option value="UTG+3"> UTG+3 </option>
           	  <option value="UTG+4"> UTG+4 </option>
           	  <option value="Hijack"> Hijack </option>
              <option value="Cut-off"> Cut-off </option>
              <option value="Bouton"> Bouton </option>
              <option value="Small Blind"> Small Blind </option>
              <option value="Big Blind"> Big Bling </option>
       	    </select>
       	    </li>
       	    <li>
            <label for="categorie"><span class="info"> Categorie :</span> </label> <br />
            <select name="categorie" id="categorie">
              <option value="choisir"> Choisir </option>
              <option value="Tournoi">   Tournoi   </option>
              <option value="Cash Game"> Cash Game </option>
       	      <option value="Sit and Go">   Sit and Go    </option>
       	    </select><br />
       	    </li>
       	    </ul>
       	    <div id="champ">
       	    <label for="situation"> <span class="info">Situation générale :</span>
       	    </label> <br />
    		<textarea name="situation" id="situation" placeholder="Ex: C'est la bulle d'un deepstack short handed"></textarea><br/>
    		<span class="info">(tapis des joueurs, nombre de joueurs, tells et habitudes des joueurs jouant immédiatement après
       	    						et avant vous, etc...)</span>
            <br />
            <br />
            </div>
    </fieldset>
</div>

<div id="situation">
    <fieldset>
       <legend> Situation </legend>
			<ul>
                <label for="preflop"> <em>Preflop :</em></label><br/>
                <li>
                Expliquez la situation :<br />
				<textarea name="preflop" id="preflop" placeholder="Ex: utg minraise et tout le monde se couche"></textarea> <br />
				</li>
				<li>
				<label> Bonne réponse :</label><br/>
				<input type="radio" name="choixPreflop" value="Fold"> Se coucher <br />
				<input type="radio" name="choixPreflop" value="Call" > Suivre <br />
				<input type="radio" name="choixPreflop" value="Raise"> Relancer <br />
				</li>
				<li>
				<label for="preflop"> Expliquez cette réponse :</label> <br />
				<textarea name="justificationPreflop" id="justificationPreflop" placeholder="Ex: Il faut 3bet pour value"></textarea> <br /> <br />
                </li>
			</ul>
			<ul>
				<label for="flop"> <em>Flop :</em></label> <br />
				<li>
				Expliquez la situation :<br />
				<textarea name="flop" id="flop"></textarea> <br />
				</li>
				<li>
				<label> Bonne réponse :</label><br/>
				<input type="radio" name="choixFlop" value="Fold"> Se coucher <br />
				<input type="radio" name="choixFlop" value="Call" > Suivre <br />
				<input type="radio" name="choixFlop" value="Raise"> Relancer <br />
				</li>
				<li>
				<label for="flop"> Expliquez cette réponse :</label> <br />
				<textarea name="justificationFlop" id="justificationFlop"></textarea> <br /> <br />
				</li>
			</ul>
			<ul>
				<label for="turn"> <em>Turn :</em></label> <br />
				<li>
                Expliquez la situation :<br />
				<textarea name="turn" id="turn"> </textarea> <br />
				</li>
				<li>
				<label> Bonne réponse :</label><br/>
				<input type="radio" name="choixTurn" value="Fold"> Se coucher <br />
				<input type="radio" name="choixTurn" value="Call" > Suivre <br />
				<input type="radio" name="choixTurn" value="Raise"> Relancer <br />
				</li>
				<li>
				<label for="turn"> Expliquez cette réponse :</label><br />
				<textarea name="justificationTurn" id="justificationTurn"></textarea> <br /> <br />
				</li>
			</ul>
			<ul>
				<label for="river"> <em>River :</em></label><br />
				<li>
                Expliquez la situation :<br />
				<textarea name="river" id="river"> </textarea> <br />
				</li>
				<li>
				<label> Bonne réponse :</label><br/>
				<input type="radio" name="choixRiver" value="Fold"> Se coucher <br />
				<input type="radio" name="choixRiver" value="Call" > Suivre <br />
				<input type="radio" name="choixRiver" value="Raise"> Relancer <br />
				</li>
				<li>
				<label for="river">Expliquez cette réponse :</label><br />
				<textarea name="justificationRiver" id="justificationRiver"> </textarea> <br /> <br />
				</li>
			</ul>
    </fieldset>
</div>

    <fieldset>
       <legend> Description complémentaire </legend> <br />
          <div id="champ">
            <label for="description"> Explications sur le coup qui seront données aux membres <br /> après avoir répondu au Quizz :</label> <br /> <br />
            <textarea name="description" id="description"> </textarea> <br /><br/>
          </div>
    </fieldset>


    <p class="creation">
        <input type="submit" value="Créer ce quizz !" />
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
