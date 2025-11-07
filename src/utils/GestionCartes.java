package utils;
import java.util.*;
public class GestionCartes {
	private static Random random = new Random();
	//a.extraire_v1
	public static <T> T extraire (List<T> liste) {
		int i = random.nextInt(liste.size());  //indice de l'élement à supprimer
		return liste.remove(i);
	}
	//a.extraire_v2
	public static <T> T extraire_I (List<T> liste) {
		int index = random.nextInt(liste.size());
		ListIterator<T> iterateur = liste.listIterator();
		for(int i = 0; i<= index ; i++) { //avance jusqu'à l'élèment qu'on veut retirer
			iterateur.next();
		}
		T elem = iterateur.previous(); //element à supprimer
		iterateur.remove();
		return elem;
	}
	
	//b.mélanger 
	public static <T> List<T>melanger(List<T> liste){
		List<T> res = new ArrayList();
	    while (!liste.isEmpty()) {
	        int index = random.nextInt(liste.size());
	        res.add(liste.remove(index));
	    }
		return res;
		
	}
	
	//c.verifierMelange
	public static <T> boolean verifierMelange(List<T>lst1 , List<T> lst2) {
		if(lst1.size() != lst2.size()) {
			return false;
		}
		for(int i = 0; i< lst1.size(); i++) {
			if(Collections.frequency(lst1, lst1.get(i)) != Collections.frequency(lst2, lst1.get(i))){
				return false;
			}
		}
		return true;		
	}
	
	//d.rassembler 
	public static <T> List<T> rassembler(List<T> liste) {
	    List<T> resultat = new ArrayList<>();
	    Set<T> dejaVu = new HashSet<>();

	    for (T elem : liste) {
	        if (!dejaVu.contains(elem)) {
	            for (T e : liste) {
	                if (e.equals(elem)) {
	                    resultat.add(e);
	                }
	            }
	            dejaVu.add(elem);
	        }
	    }

	    return resultat;
	}
	
	
	//e.verifierRassemblement
	public static <T> boolean verifierRassemblement(List<T> liste) {
	    if (liste.isEmpty()) {
	    	return true;
	    }

	    ListIterator<T> it1 = liste.listIterator();
	    T precedent = it1.next(); //premier élément
	    while (it1.hasNext()) {
	        T courant = it1.next();
	        if (!courant.equals(precedent)) {
	            ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
	            while (it2.hasNext()) {
	                if (precedent.equals(it2.next())) {
	                }
	            }
	        }
	        precedent = courant; // mise à jour du précédent
	    }

	    return true;
	}

	
	
	
}
