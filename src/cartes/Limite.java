package cartes;

public abstract class Limite extends Carte {
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Carte carte) {
			return getClass().equals(carte.getClass());
		}
		return false;
	}
	
}
