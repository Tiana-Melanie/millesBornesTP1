package jeu;

import java.util.*;

import cartes.*;

public class ZoneDeJeu {
	private List<Limite> pileLimites = new ArrayList<>();
	private List<Bataille> pileBatailles = new ArrayList<>();
	private List<Borne> bornes = new ArrayList<>();
	
	
	public List<Limite> getPileLimites() {
		return pileLimites;
	}
	public List<Bataille> getPileBatailles() {
		return pileBatailles;
	}
	public List<Borne> getBornes() {
		return bornes;
	}
	
	public int donnerLimitationVitesse() {
		if(pileLimites.isEmpty()) {
			return 200;
		}
		Limite sommet = pileLimites.get(pileLimites.size()-1); //on recupére le sommet de la pile
		if(sommet instanceof FinLimite) {
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int km_total = 0;
		for(Borne b : bornes) {
			km_total += b.getKm();
		}
		return km_total;
	}
	
	public void deposer (Carte c) {
		if(c instanceof Borne) {
			bornes.add((Borne)c);
		}
		else if(c instanceof Limite) {
			pileLimites.add((Limite)c);
		}
		else if (c instanceof Bataille) {
			pileBatailles.add((Bataille)c);
		}
	}
	
	// === Partie 3 ===
	
    public boolean peutAvancer() {
        if (pileBatailles.isEmpty()) return false;
        Carte sommet = pileBatailles.get(pileBatailles.size() - 1);
        return sommet instanceof Parade && ((Parade) sommet).getType() == Type.FEU;
    }

    public boolean estDepotFeuVertAutorise() {
        if (pileBatailles.isEmpty()) return true;

        Carte sommet = pileBatailles.get(pileBatailles.size() - 1);

        // sommet = Feu rouge
        if (sommet instanceof Attaque && ((Attaque) sommet).getType() == Type.FEU) return true;

        // sommet = autre parade que feu vert
        if (sommet instanceof Parade && ((Parade) sommet).getType() != Type.FEU) return true;

        return false;
    }

 
    public boolean estDepotBorneAutorise(Borne borne) {
        if (!peutAvancer()) return false;
        if (borne.getKm() > donnerLimitationVitesse()) return false;
        if (donnerKmParcourus() + borne.getKm() > 1000) return false;
        return true;
    }

    public boolean estDepotLimiteAutorise(Limite limite) {
        if (limite instanceof FinLimite) {
            return !pileLimites.isEmpty() && (pileLimites.get(pileLimites.size() - 1) instanceof DebutLimite);
        } else  if (limite instanceof DebutLimite){
            // C’est un début de limite
            return pileLimites.isEmpty() || (pileLimites.get(pileLimites.size() - 1) instanceof FinLimite);
        }
        else {
        	return false;
        }
        
    }

  
    public boolean estDepotBatailleAutorise(Bataille bataille) {
        if (bataille instanceof Attaque) {
            // Une attaque peut être déposée si le joueur n'est pas déjà bloqué
            return peutAvancer();
        } else if (bataille instanceof Parade p) {
            // Cas Feu Vert
            if (p.getType() == Type.FEU) {
                return estDepotFeuVertAutorise();
            } else {
                // Autre parade : sommet = attaque du même type
                if (pileBatailles.isEmpty()) return false;
                Carte sommet = pileBatailles.get(pileBatailles.size() - 1);
                return (sommet instanceof Attaque a) && a.getType() == p.getType();
            }
        }
        return false;
    }

   
    public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Borne b) return estDepotBorneAutorise(b);
        if (carte instanceof Limite l) return estDepotLimiteAutorise(l);
        if (carte instanceof Bataille b) return estDepotBatailleAutorise(b);
        return false;
    }
	
	
	
}
