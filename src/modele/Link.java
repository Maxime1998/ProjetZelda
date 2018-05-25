package modele;

public class Link extends Personnage {
	
	private Arme epee;
	
	public Link(int abs,int ord, int[][]m){
		super(abs,ord,10,m, new Epee(7));
		
		
	}

}