package modele;

public class Epee implements Arme{

	private int degats;
	
	public Epee(int deg) {
		this.degats=deg;
		
	}
	@Override
	public int getDegats() {
		return degats;
	}

}
