package jeu;
import java.util.*;
import cartes.Carte;

public class MainJoueur {

		private List<Carte> carte = new ArrayList<>();
		
		public void prendre(Carte c) {
	        carte.add(c);
	    }

	    public void jouer(Carte c) {
	        assert carte.contains(c);
	        carte.remove(c);
	    }

	    public Iterator<Carte> iterator() {
	        return carte.iterator();
	    }

	    @Override
	    public String toString() {
	        return carte.toString();
	    }
		

}
