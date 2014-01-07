<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Quizz"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style_recherche.css">
<title> PHD - Recherche </title>
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
<h3> Rechercher une analyse de main </h3>
<p> Vous pouvez rechercher un quizz par cartes
</p>
</div>

<!-- formulaire de recherche -->
<section>
<form id="formulaire" method="post" action="recherche.do">

    <fieldset>
       <legend> Recherche </legend>
          <p>
            <label for="carte1"> Carte 1 : </label> <br />
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
       	    </select>
   	      </p>
   	      <p>
            <label for="carte2"> Carte 2 : </label> <br />
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
       	    </select>
   	      </p>
   	      <p>
   	      <input type="radio" name="couleur" value="suited" id="suited" /> <label for="suited"> Assorties </label> <br />
   	      <input type="radio" name="couleur" value="offsuit" id="offsuit" /> <label for="offsuit"> Dépareillées </label> <br />
   	      <input type="radio" name="couleur" value="tous" id="toutes" checked="checked" /> <label for="toutes"> Toutes </label> <br />
   	      </p>
   	      <p class="recherche">
            <input type="submit" value="Rechercher" />
          </p>
    </fieldset>

</form>

    <fieldset>
       <legend> Résultats </legend>
       <!-- Afficher les résultats de la recherche dynamiquement -->
       <%
       List<Quizz> resultat = (List<Quizz>) request.getAttribute("resultat");
       if (resultat != null) {
       	if (resultat.size() == 0) {
    		out.println("Aucun résultat pour cette recherche");
       	}
       	else {
    		int i;
		   	for(i=0;i<resultat.size();i++) {
    	   		Quizz q = resultat.get(i);
    	   		// reponse.do avec l'ID du Quizz passé en paramètre
    	   		out.println("<a href='reponse.do?id=" + String.valueOf(q.getNum()) + "'>");
    	   		out.println(q.getCarte1() + " de " + q.getCouleur1() + " - " +q.getCarte2() + " de " + q.getCouleur2());
    	   		out.println("</a>");
    	   		out.println("<br />");
			}
	   	}
       }
       %>
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
