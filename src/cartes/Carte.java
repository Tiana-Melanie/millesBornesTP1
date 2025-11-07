package cartes;

public abstract class Carte {
	public abstract String toString();
	
	//comparer les types
	public boolean equals(Object obj) {
		if(obj instanceof Carte carte) {
			return this.getClass().equals(carte.getClass());
		}
		return false;
	}
	
}
