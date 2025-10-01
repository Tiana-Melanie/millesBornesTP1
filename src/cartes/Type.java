package cartes;

public enum Type {
	FEU("Feu rouge", "Feu vert","Prioriatire"),
	ESSENCE ("Panne d'essence", "bidon essence", "Citerne"), 
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "Réparation", "as du volant");
	
	private String attaque;
	private String parade;
	private String botte;
	
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}


	public String getAttaque() {
		return attaque;
	}


	public String getParade() {
		return parade;
	}


	public String getBotte() {
		return botte;
	}
	
	
	
	
	
}
