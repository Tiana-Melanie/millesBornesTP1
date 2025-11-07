package cartes;

public abstract class Probleme extends Carte {

	private Type type;
	
	public Type getType() {
		return type;
	}

	protected Probleme(Type type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme pb) {
			return super.equals(obj) && type.equals(pb.getType());
		}
		return false;
	}

}
