<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style_inscription.css">
<title> PHD - Inscription </title>
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

<div id="presentation">
<h3> Inscription </h3>
<p> Veuillez remplir les champs ci-dessous :
</p>
</div>

<!-- formulaire d'inscription -->
<section>
<form id="formulaire" method="post" action="inscription.do">

   <fieldset>
	  <legend> Identifiants </legend>
	     <p>
	       <label> Pseudo : </label>
	       <input type="text" name="id" id="id" />
	     </p>
	     <p>
	       <label> Mot de passe : </label>
	       <input type="password" name="password" id="password" />
	     </p>
	     <p>
	       <label> Répeter le mot de passe : </label>
	       <input type="password" name="password2" id="password2" />
	     </p>
   </fieldset>

   <fieldset>
       <legend>Informations </legend>
	      <p>
	        <label> Nom : </label>
	        <input type="text" name="nom" id="nom" />
	      </p>
	      <p>
	        <label> Prénom : </label>
	        <input type="text" name="prenom" id="prenom" />
	      </p>
	      <p>
	        <label> Adresse mail : </label>
	        <input type="email" name="email" id="email" />
	      </p>
          <p>
	        <label> Ville : </label>
	        <input type="text" name="ville" id="ville" />
	      </p>
   </fieldset>

<p class="inscrire">
<input type="submit" value="S'inscrire" />
</p>
</form>
<div id="erreur">
<%
Integer erreur = (Integer) request.getAttribute("erreur");
if (!(erreur == null)) {
	int err = erreur.intValue();
	if (err == 1)
		out.println("<br /> Pseudo deja utilisé ");
	else if (err == 2)
		out.println("<br /> Mauvais mot de passe ");
	else if (err == 3)
		out.println("<br /> Veuillez remplir tous les champs ");
}
%>
</div>

  <p class="retour">
    <br/>
     <a href="Accueil.html"> Retour à la page d'accueil </a>
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
