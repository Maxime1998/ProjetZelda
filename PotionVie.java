package modele;

public class PotionVie extends Objets {
	
	public PotionVie(String n) {
		super(n);
	}
	
	public void donnerPV(Link l){
		l.gagnerPV(10);
	}
}
