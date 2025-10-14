package testsFonctionnels;
import cartes.*;

public class TestMethodeEquals {
	public static void main(String[] args ) {
		Carte c1 = new Borne(25);
		Carte c2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ?" + c1.equals(c2));
		
		Carte f1 = new Attaque(Type.FEU);
		Carte f2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feu rouge sont identiques ?" + f1.equals(f2));
		
		Carte feuR = new Attaque(Type.FEU);
		Carte feuV = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ?" + feuR.equals(feuV));
		
		Carte c3 = new DebutLimite();
		Carte c4 = new FinLimite();
		System.out.println("Deux cartes debut et fin limites sont identiques ?" + c3.equals(c4));
		
	}
}
