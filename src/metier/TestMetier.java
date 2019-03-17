package metier ;

import java.util.Iterator;
 

// cette classe sert à tester le package metier  
public class TestMetier {
	
		public static void main ( String[] args ) {
			
				Operation op = new Operation(); 
				
				op.add(      new Produit( new Long(1), "PC" ,"PC portable" ,8000, 1)      );
				op.add(      new Produit( 2L, "clavier" ,"clavier hp" ,70, 1)				);
				op.add(		 new Produit(3L, "sourie" ,"sourie DELL" ,100, 0)				);
				op.add(	 	 new Produit( 4L, "H-P" ,"HP C100" ,300, 1))					;
				
				//  op.remove(2L);
			
			   Iterator<Produit> produits=op.getAll().iterator();
			
				while(produits.hasNext() ) {
					Produit pr =  produits.next();
					pr.Show();
				}
			
	   }
	
}

