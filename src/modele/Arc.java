package modele;


public class Arc implements Arme {

	private int degats;
	
	public Arc(int deg) {
		this.degats=deg;
	}

	@Override
	public int getDegats() {
		return this.degats;
	}

}
