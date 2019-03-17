package metier;

public class Produit {
	//attributs 
	private Long id;
	private String nom,desc;
	private int  prix ,etat;
					// generate getters and setters   of all the attributes
									public Long getId() {
										return id;
									}
								
									public void setId(Long id) {
										this.id = id;
									}
								
									public String getNom() {
										return nom;
									}
								
									public void setNom(String nom) {
										this.nom = nom;
									}
								
									public String getDesc() {
										return desc;
									}
								
									public void setDesc(String desc) {
										this.desc = desc;
									}
								
									public int getPrix() {
										return prix;
									}
								
									public void setPrix(int prix) {
										this.prix = prix;
									}
								
									public int getEtat() {
										return etat;
									}
								
									public void setEtat(int etat) {
										this.etat = etat;
									}
				         // end of getters and setters
	
  //différents constructors 
									
		//from menu Source --> Source --> Generate constructors from superclass
	    public Produit() {
			super();
			// TODO Auto-generated constructor stub
		}
	 
	  //from menu Source --> Source --> Generate constructor using Fields
		public Produit(String nom, String desc, int prix, int etat) {
			super();
			this.nom = nom;
			this.desc = desc;
			this.prix = prix;
			this.etat = etat;
		}

	
		public Produit(Long id, String nom, String desc, int prix, int etat) {
			super();
			this.id = id;
			this.nom = nom;
			this.desc = desc;
			this.prix = prix;
			this.etat = etat;
		}
//end of constructeurs
	
	@Override
	public String toString() {
		return id+ " - "+ nom + " - " +desc + " - " +prix+ " - " +etat + " . ";
	}
		
		
		
	public void Show() {
		System.out.println(toString()) ;
	}
		 
}
