package controleur;
import modele.Link;
import modele.Personnage;

public class Scrolling {

	private int posXFenetre,posYFenetre;
	private Link link;
	
	public Scrolling(Link l) {
		this.posXFenetre=0;
		this.posYFenetre=0;
		this.link=l;
	}
	
	public void setPosXFenetre() {
		this.posXFenetre=link.getPosx()-150;
		if(posXFenetre<0) {
			posXFenetre=0;
		}
		if(posXFenetre>320) {
			posXFenetre=320;
		}
	}
	
	public void setPosYFenetre() {
		this.posYFenetre=link.getPosy()-150;
		if(posYFenetre<0) {
			posYFenetre=0;
		}
		if(posYFenetre>320) {
			posYFenetre=320;
		}
	}
	
	public int getPosXFenetre() {
		return this.posXFenetre;
	}
	
	public int getPosYFenetre() {
		return this.posYFenetre;
	}

}
