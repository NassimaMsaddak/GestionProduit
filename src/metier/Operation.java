package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList; 

public class Operation {
	//attributs
	private ArrayList<Produit> produits = new ArrayList<Produit>();
	
	// generate getters and setters
		public ArrayList<Produit> getProduits(){
			return produits;
		}
		
		public void setProduits (ArrayList<Produit> produits) {
			this.produits= produits;
		}
	// generate getters and setters
		
		public void add(Produit  p) { 
				try{
					//1
					Class.forName("com.mysql.jdbc.Driver");
					//2
					Connection  cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduit","root","");  // 3306 est un port spéciale de mysql
				    //3
				   java.sql.PreparedStatement pr= cn.prepareStatement("INSERT INTO  produit VALUES (NULL,?,?,?,?)");
				   
				    pr.setString(1,p.getNom());
				    pr.setString(2,p.getDesc());
				    pr.setInt(3,p.getPrix());
				    pr.setInt(4,p.getEtat());  
				    //4
				  pr.execute(); 
				    
				 }catch(Exception e) { 
				 	 e.printStackTrace(); 
				 }
				
			produits.add(p); 
		}
			
		
		public void remove(Long  id) { 
				try{
					//1
					Class.forName("com.mysql.jdbc.Driver"); 
					//2
					Connection  cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduit","root","");
				    //3
				   java.sql.PreparedStatement pr= cn.prepareStatement("DELETE FROM  produit WHERE id=?"); 
				   
				   pr.setLong(1,id); 
				    pr.execute(); 
				    
				}catch(Exception e) { 
					e.printStackTrace(); 
				}
			
				// pour suppression "sans" base de données
				/* for (Produit p:produits) {
						if(p.getId()== id) {
							produits.remove(p);
							break;
						}
						
				} */
		}
				
		
	public ArrayList<Produit>  getAll() {
		ArrayList<Produit> listProduit = new ArrayList<Produit>();
		try{
			//1
			Class.forName("com.mysql.jdbc.Driver"); 
			//2
			Connection  cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduit","root","");
		    //3
		   java.sql.PreparedStatement pr= cn.prepareStatement("SELECT *  FROM  produit "); 
		     //4
		   ResultSet rs= pr.executeQuery(); 
		    //5
		   while(rs.next()) {
			
			   Produit p=new Produit();     //instantiation
			   
			  //attribution des valeurs aux attributs
			  p.setId(rs.getLong("id"));
			  p.setNom(rs.getString("nom"));
			  p.setDesc(rs.getString("desc"));
			  p.setPrix(rs.getInt("prix"));
			  p.setEtat(rs.getInt("etat"));
			  //remplissement du tableau
			  listProduit.add(p);
		   }
		}catch(Exception e) { 
			e.printStackTrace(); 
		}
		// pour affichage "sans" et "avec" base de données  (retourner la table à afficher)
			  return listProduit;
	}
				
	}