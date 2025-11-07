package jeu;

import cartes.Carte;

public class Joueur {
	private ZoneDeJeu zone;
	private String nom;
	
	private MainJoueur main = new MainJoueur();
	
	public MainJoueur getMain() {
		return main;
	}

	public Joueur(String nom) {
		this.nom =nom;
		this.zone = new ZoneDeJeu();
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Joueur j) {
			return this.getNom().equals(j.getNom());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
	    return nom.hashCode();
	}
	
	public void donner (Carte c) {
		main.prendre(c);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte c = sabot.piocher();
		main.prendre(c);
		return c;
	}
	
	public int donnerKmParcourus() {
		return zone.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zone.deposer(c);
	}

	public ZoneDeJeu getZone() {
		return zone;
	}

	
}
