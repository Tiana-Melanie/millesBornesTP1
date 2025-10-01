package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	private Carte[] carte;
	private int nbCartes;
	private int indicateur = 0;
	
	 public Sabot(Carte[] initial) {
	        this.carte = new Carte[initial.length];
	        System.arraycopy(initial, 0, this.carte, 0, initial.length);
	        this.nbCartes = initial.length;
	    }
	 
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte c) {
		if(nbCartes >= carte.length) {
			throw new IllegalStateException("dépassement capacité");
		}
		carte[nbCartes++] = c;
		indicateur++;
		
	}
	
	@Override 
	public Iterator<Carte> iterator(){
		return new SabotIterator();
	}
	
	
	private class SabotIterator implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private int dernier = -1;
		private int nombreOperationsReference = indicateur;
		
		@Override 
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		@Override 
		public Carte next() {
			if(nombreOperationsReference != indicateur) {
				throw new ConcurrentModificationException("Sabot modifié en dehors de l'itérateur");
			}
			if(indiceIterateur >= nbCartes) {
				throw new IllegalStateException("next");
			}
			dernier = indiceIterateur;
			return carte[indiceIterateur++];
		}
		
		@Override 
		public void remove() {
			if(nombreOperationsReference != indicateur) {
				throw new ConcurrentModificationException("Sabot modifié en dehors de l'itérateur");
			}
			if(dernier < 0) {
				throw new IllegalStateException("remove appelé avant next()");
			}
			//decalage à gauche
			for(int i = dernier + 1 ; i< nbCartes;i ++) {
				carte[i-1] = carte[i];
			}
			carte[--nbCartes] = null;
			indiceIterateur = dernier;
			dernier = -1;
			
			indicateur ++;
			nombreOperationsReference = indicateur;
		}
	}
	//on pioche la première carte-> donc on supprime dans le tableau et on décale de reste
	public Carte piocher() {
	    Iterator<Carte> it = iterator();
	    if (!it.hasNext()) {
	        throw new NoSuchElementException("Le sabot est vide");
	    }
	    Carte c = it.next();
	    it.remove(); // supprime la première carte
	    return c;
	}
	
	
}
