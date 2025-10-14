package utils;
import java.util.*;
public class GestionCartes {
	
	//supprime et retourne l'élèment
	public static <T> T extraire (List<T> liste) {
		int i = new Random().nextInt(liste.size());  //indice de l'élement à supprimer
		return liste.remove(i);
	}
	
	public static <T> T extraire_I (List<T> liste) {
		int index = new Random().nextInt(liste.size());
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
		Random random = new Random();
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
	public static <T> List<T> rassembler(List<T> liste){
		List<T> res = new ArrayList<> (liste);
		for(T elem : liste) {
			if(!res.contains(elem)) {
				for(T e : liste) {
					if(e.equals(elem)) {
						res.add(e);
					}
				}
			}
		}
		return res;
	}
	
	//e.verifierRassemblement
	public static <T> boolean verifierRassemblement(List<T> liste) {
	    for (int i = 1; i < liste.size(); i++) {
	        if (liste.subList(i, liste.size()).contains(liste.get(i - 1))) {
	            return false;
	        }
	    }
	    return true;
	}

	
}
