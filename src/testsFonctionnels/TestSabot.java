package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());

	// 4.2.a
	public void questionA() {

		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("Je pioche " + carte);
		}
/*		Console :
		Je pioche Accident
		Je pioche Accident
		Je pioche Accident
		Je pioche R�paration
		Je pioche R�paration
		Je pioche R�paration
		Je pioche As du volant*/
	}

	// 4.2.b
	public void questionB() {
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			System.out.println("Je pioche " + iterator.next());
			iterator.remove();
		}
	}

	// 4.2.c
/*	public void questionC() {
		Carte cartePiochee = sabot.piocher();
		System.out.println("Je pioche " + cartePiochee);
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			System.out.println("Je pioche " + carte);
			iterator.remove();
			Carte cartePiochee1 = sabot.piocher();
			sabot.ajouterCarte(new Botte(cartes.Type.ACCIDENT));
		}
		Iterator<Carte> iterator = sabot.iterator();
		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}*/
	
	public void questionC() {

	    //Cas1 : utiliser piocher() dans une boucle avec un itérateur
	    try {
	        sabot = new Sabot(new JeuDeCartes().donnerCartes()); // recréer un sabot complet
	        for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
	            Carte carte = iterator.next();
	            System.out.println("Je pioche " + carte);
	            sabot.piocher(); //
	        }
	    } catch (Exception e) {
	        System.out.println("piocher dans boucle: " + e);
	    }

	    //Cas2 : insérer une carte pendant la boucle
	    try {
	        sabot = new Sabot(new JeuDeCartes().donnerCartes()); 
	        sabot.piocher(); //pour éviter un dépassement du tableau
	        for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
	            Carte carte = iterator.next();
	            System.out.println("Je pioche " + carte);
	            sabot.ajouterCarte(new Botte(cartes.Type.ACCIDENT));
	        }
	    } catch (Exception e) {
	        System.out.println("ajouterCarte dans boucle : " + e);
	    }
	}


	public static void main(String[] args) {
		TestSabot testPioche = new TestSabot();
//		testPioche.questionA();
//		testPioche.questionB();
		testPioche.questionC();
	}

}
