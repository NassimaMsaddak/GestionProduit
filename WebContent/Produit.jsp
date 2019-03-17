<%@page import="metier.Operation"%>
<%@ page import ="java.util.Iterator" %>
<%@ page import ="web.ProduitBeans" %>
<%@ page import ="metier.Produit" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title> Get it easy .Net & (Gestion des produits) </title>
	</head>
<body> 
	<%
	ProduitBeans produits;
	
	if (request.getAttribute("modele") != null){
		produits=(ProduitBeans)request.getAttribute("modele");   //puis casting to (ProduitBeans)
	} else {
		Operation op=new Operation();
		
		produits=new ProduitBeans();
	
		produits.setListe(op.getAll());
	}
	%>
	
<h3> Tutoriel J2EE (JSP , Servlet , MVC et JDBC )   </h3>
<h5>  Ajouter un nouveau produit </h5>
 
 <form action="prodserv" method= "post">
	 <table border="1"  width= "50%" > 
	
			 <tr>
			    <td>  Nom      </td> 
			    <td> <input type="text" name="nom" /> </td>
			 </tr>
			 
			  <tr>
			    <td>   Description     </td> 
			    <td>  <input type="text" name="desc" />      </td>
			 </tr>
			 
			  <tr>
			    <td>    Prix    </td> 
			    <td>   <input type="text" name="prix" />     </td>
			 </tr>
			 
			  <tr>
			    <td>   Etat     </td> 
			    <td>   <input type="text" name="etat" />     </td>
			 </tr>
			 
			  <tr>
			    <td colspan="2"><input type="submit" name="valider" value ="Valider"/></td> 
			 </tr>
	 
	 </table>
  </form>
  
   <!--  2ème table  -->
	  <table border="1"  width= "60%" > 
	 	<tr>
	 		<th>Id </th>
	 		<th>Nom </th>
	 		<th>Description </th>
	 		<th> Prix</th>
	 		<th>Etat </th> 
	 		<th>Option </th> 
	 	</tr>
	 	
	 	<%
	 	Iterator<Produit>  list=produits.getListe().iterator();
	 	while( list.hasNext()) {
	 		Produit p= list.next();
	 	%>
	 
		 <tr>
		    <td> <%= p.getId()  %></td>  
		    <td> <%= p.getNom()  %></td>  
		    <td> <%= p.getDesc()  %></td>  
		    <td> <%= p.getPrix()  %></td>  
		    <td> <%= p.getEtat()  %></td>  
		    <td>  
				    <form action="prodserv" method="post"> 
				    	 <input type="hidden" name="id" value="<%= p.getId()  %>"/>   <!--  le type hidden sert à faire passer une valeur au script appelé non visibles par l'utilisateur   --> 
				  		  <input type="submit" name="supprimer" value="Supprimer"/>
				    </form>
		    </td> 
		 </tr>
		 
		 <% 
		 }
		 %>
	 
	 </table>
   
</body>
</html>