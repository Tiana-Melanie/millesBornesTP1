package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = new Configuration[19];
	
	//classe interne
	private static class Configuration{

		private int nbExemplaires;
		private Carte carte;
		
		public Configuration(Carte carte, int nbExemplaire) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaire;;
			
		}
	}
	
	public JeuDeCartes() {
		typesDeCartes[0] = new Configuration(new Borne(25), 10);
		typesDeCartes[1] = new Configuration(new Borne(50), 10);
		typesDeCartes[2] = new Configuration(new Borne(75), 10);
		typesDeCartes[3] = new Configuration(new Borne(100), 12);
		typesDeCartes[4] = new Configuration(new Borne(200), 4);
		typesDeCartes[5] = new Configuration(new Parade(Type.FEU), 14);
		typesDeCartes[6] = new Configuration(new Parade(Type.LIMITE), 6);
		typesDeCartes[7] = new Configuration(new Parade(Type.ESSENCE), 6);
		typesDeCartes[8] = new Configuration(new Parade(Type.CREVAISON), 6);
		typesDeCartes[9] = new Configuration(new Parade(Type.ACCIDENT), 6);
		typesDeCartes[10] = new Configuration(new Attaque(Type.FEU), 5);
		typesDeCartes[11] = new Configuration(new Attaque(Type.LIMITE), 4);
		typesDeCartes[12] = new Configuration(new Attaque(Type.ESSENCE), 3);
		typesDeCartes[13] = new Configuration(new Attaque(Type.CREVAISON), 3);
		typesDeCartes[14] = new Configuration(new Attaque(Type.ACCIDENT), 3);
		typesDeCartes[15] = new Configuration(new Botte(Type.FEU), 1);
		typesDeCartes[16] = new Configuration(new Botte(Type.ESSENCE), 1);
		typesDeCartes[17] = new Configuration(new Botte(Type.CREVAISON), 1);
		typesDeCartes[18] = new Configuration(new Botte(Type.ACCIDENT), 1);
	}
	
	public String affichageJeuCartes() {
		StringBuilder res = new StringBuilder();
		for(int i = 0; i <typesDeCartes.length; i++) {
			res.append(typesDeCartes[i].nbExemplaires + " " + typesDeCartes[i].carte.toString() + " \n");
		}
		return res.toString();
	}
	
	public Carte[] donnerCartes() {
		int total = 0;
		for(int i = 0; i <typesDeCartes.length; i++) {
			total += typesDeCartes[i].nbExemplaires;
		}
		
		Carte[] cartes = new Carte[total];
		int index = 0;
		for(int i = 0; i <typesDeCartes.length; i++) {
			for(int j = 0; j <typesDeCartes[i].nbExemplaires; j++) {
				cartes[index++] = typesDeCartes[i].carte;
			}
		}
		return cartes;
	}
	
	public boolean checkCount() {
		int total_carte = 0;
		for(int i = 0; i <typesDeCartes.length; i++) {
			total_carte += typesDeCartes[i].nbExemplaires;
		}
		return total_carte == 106;
	}
	
	
}
