package jeu;

import cartes.JeuDeCartes;
import utils.GestionCartes;
import java.util.*;
import cartes.Carte;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] tab = jeu.donnerCartes();
		List<Carte> listeC = new ArrayList<>();
		Collections.addAll(listeC, jeu.donnerCartes());
		
		listeC = GestionCartes.melanger(listeC);
		sabot = new Sabot(listeC.toArray(tab));
	}
	
	public Sabot getSabot() {
		return sabot;
	}
}
