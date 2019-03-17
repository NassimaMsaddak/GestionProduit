package web; 

 import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Operation;
import metier.Produit;

public class ProduitServlet extends HttpServlet {  
		/*
		public Operation op;
		
		@Override
		public void init() throws ServletException {
			 op= new Operation();
		}
		*/
	
	//récuperer les informations
		protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
			
			Operation op= new Operation();  //créer une instance de Operation  pour pouvoir invoquer la méthode add de cette classe
			
			if ( req.getParameter("supprimer") != null ) { 
					op.remove(Long.parseLong(req.getParameter("id")));  
			} else {
				
					String nom= req.getParameter("nom"); 
					String desc= req.getParameter("desc");
					String prix= req.getParameter("prix");
					String etat= req.getParameter("etat");
					
					Produit p= new Produit(1L,nom,desc, Integer.parseInt(prix),Integer.parseInt(etat) );  //utilisation du constructeur paramétrer 
					
					
					op.add(p);
					
					
		
					
					
					/* 
					PrintWriter out=resp.getWriter();
					out.println("<BODY BGCOLOR=\"#FDF5E6\">\n" +
							"<H1 ALIGN=CENTER> </H1>\n" +
							"<B>Request Method: </B>" +
					req.getMethod() + "<BR>\n" +
					"<B>Request URI: </B>" +
					req.getRequestURI() + "<BR>\n" +
					"<B>Request Protocol: </B>" +
					req.getProtocol() + "<BR><BR>\n" +
					"<B>Adresse IP Client: </B>"+
					req.getRemoteAddr()+ "<BR>\n"+
					"<B>Nom Client: </B>"+
					req.getRemoteHost()+ "<BR>\n"+ 
					"<TABLE BORDER=1 ALIGN=CENTER>\n" +
					"<TH>Header Name<TH>Header Value");
					
					Enumeration headerNames = req.getHeaderNames();
					while(headerNames.hasMoreElements()) {
						String headerName = (String)headerNames.nextElement();
						out.println("<TR><TD>" + headerName);
						out.println(" <TD>" + req.getHeader(headerName));
					}
					out.println("</TABLE>\n</BODY></HTML>");
					
					*/
					
					
					// afficher les informations à partir du servlet
					
					//PrintWriter pr= resp.getWriter();
					//pr.println(" <html><head> <title> Getiteasy.Net </title> </head><body> ");
					//pr.println("<br>" + nom + " - " + desc +  " - " + prix + " - " + etat +  " . ");
					//pr.println("</body></html>");
			}
			 
			
			ProduitBeans pb= new ProduitBeans();
			pb.setListe(op.getAll());
			
			req.setAttribute("modele",pb);
			
			req.getRequestDispatcher("Produit.jsp").forward(req,resp);   //redirection to "Produit.jsp"
	 

		} 
	
}
 
