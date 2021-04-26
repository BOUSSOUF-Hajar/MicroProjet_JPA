.<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title></title>
	</head>
	<body>
	<div id="content">
<%@page import="gi4.javaEE.microProjet_JPA.entity.Client" %>
<%
Client client =(Client) request.getAttribute("user");
String session_userName = (String)session.getAttribute("userName");
String session_userFName = (String)session.getAttribute("userFName");
if(client==null )
{
 %>
	

     	<h3>Bienvenue chez SEBO - Veuillez-vous identifier ou vous inscrire </h3>
    <!-- 
    
    <a href="fromAccueil?ID=ident">Déjà client : identifiez-vous </a><br />
    <a href="fromAccueil?ID=inscr">Nouveau client : inscrivez-vous </a>
    
    --> 
     <a href="identifier">Déjà client : identifiez-vous </a><br /> <br/>
     <a href="inscrire">Nouveau client : inscrivez-vous </a>
    

<%} else { 
 %>
 <h3>Bonjour Mr/Mme <%=client.getNom() %> <%=client.getPrenom()%> </h3>
 <br/>
 <a href="catalogue">Consulter le catalogue </a>
 <br/>
 <br/>
 <a href="">Suivre mes commandes</a>
 <br>
 <br/>
 <a href="">Visualiser mon panier</a>
 <br/>
 <br/>
 <% } 
 %>
 </div>
 </body>
 </html>
 
 
 
