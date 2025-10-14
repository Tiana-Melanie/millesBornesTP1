package jeu;

import cartes.JeuDeCartes;
import utils.GestionCartes;
import java.util.*;
import cartes.Carte;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeC = new ArrayList<>();
		Collections.addAll(listeC, jeu.donnerCartes());
		
		listeC = GestionCartes.melanger(listeC);
		sabot = new Sabot(listeC.toArray(new Carte[0]));
	}
	
	public Sabot getSabot() {
		return sabot;
	}
}
