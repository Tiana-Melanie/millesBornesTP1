package cartes;

public abstract class Probleme extends Carte {

	private Type type;
	
	public Type getType() {
		return type;
	}

	public Probleme(Type type) {
		this.type = type;
	}

}
